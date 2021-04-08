package com.hui.tgs.service.db17.impl;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.commonutils.been.TgsParameter;
import com.hui.tgs.dao.db17.TgsDao;
import com.hui.tgs.service.db17.TgsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author lihui
 * @title: TgsServiceImpl
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:41
 */
@Service
@Slf4j
@RefreshScope
public class TgsServiceImpl extends ServiceImpl<TgsDao, TgsParameter> implements TgsService {

    @Autowired
    private TgsDao tgsDao;

    @Value(value = "${tgs.CollectFlag}")
    private String collectFlag;

    @Override
    public String tgsToDealWith(TgsParameter tgsParameter) {
        String result = "";
        if (tgsParameter != null){
            try {
                switch (tgsParameter.getCmd()) {
                    case "UOP":
                        result = uop(tgsParameter);
                        break;
                    case "ADD":
                        result = add(tgsParameter);
                        //读取配置collectFlag，如果为Y时进行异步处理
                        if ("Y".equals(collectFlag)) {
                            //异步线程处理
                            new Thread((new Runnable() {
                                @Override
                                public void run() {
                                    addLog(tgsParameter);
                                }
                            })).start();
                        }
                        break;
                    case "ATT":
                        result = att(tgsParameter);
                        break;
                    default:
                        result = "CMD Error,Not UOP,ADD,ATT";
                        break;
                }
            }catch (Exception e){
                result = "存储过程调用异常";
                log.error(result+" : "+e.getMessage());
            }
        }
        return result;
    }

    /**
     * UOP命令处理
     * @param tgsParameter
     * @return
     */
    public String uop(TgsParameter tgsParameter){
        String result = "";
        try {
            tgsDao.callUop(tgsParameter);
            if ("OK".equals(tgsParameter.getRes())){
                result = "0 SFC_OK" + "\r\n" + "tsid::" + tgsParameter.getTerminal() + "::unit_process_check=OK ";
            }else {
                result = "0 SFC_OK" + "\r\n" + "tsid::" + tgsParameter.getTerminal() + "::unit_process_check=UNIT OUT OF PROCESS " + tgsParameter.getRes();
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "存储过程调用异常";
            log.error(result+" : "+e.getMessage());
        }
        //result = "0 SFC_OK " + "\r\n" + "tsid::" + tgsParameter.getTerminal() + "::unit_process_check=OK ";
        return result;
    }

    /**
     * ADD命令处理
     * @param tgsParameter
     * @return
     */
    public String add(TgsParameter tgsParameter){
        String result = "";
        try {
            tgsDao.callAdd(tgsParameter);
            if ("OK".equals(tgsParameter.getRes())){
                result = "0 SFC_OK ";
            }else {
                result = "0 SFC_OK " + tgsParameter.getRes();
            }
        }catch (Exception e){
            result = "存储过程调用异常";
            log.error(result+" : "+e.getMessage());
        }
        return result;
    }

    /**
     * ADD LOG 处理（数据采集）
     * @param tgsParameter
     * @return
     */
    public void addLog(TgsParameter tgsParameter){
        String result = "";
        if (tgsParameter.getResults() != null && tgsParameter.getResults() != ""){
            String lresult = "["+tgsParameter.getResults()+"]";
            System.out.println(lresult);
            //强转
            List<Map<String,Object>> resultList = (List<Map<String,Object>>) JSONArray.parse(lresult);
            if (resultList != null){
                if (resultList.size() != 0){
                    StringBuilder strsql = new StringBuilder();
                    for (int i = 0; i < resultList.size(); i++) {
                        Map<String,Object> mapList = resultList.get(i);
                        Iterator<String> it = mapList.keySet().iterator();
                        while(it.hasNext() ) {
                            String kValue = (String) mapList.get(it.next());
                            //取出用逗号拼接
                            strsql.append("'"+kValue+"',");
                        }
                    }
                    //去掉最后一个逗号
                    tgsParameter.setStrSql(strsql.toString().substring(0,strsql.length()-1)+")");
                    //System.out.println(tgsParameter.getStrSql());
                }
            }
        }
        try {
            tgsDao.callAddLog(tgsParameter);
        }catch (Exception e){
            result = "存储过程调用异常";
            log.error(result+" : "+e.getMessage());
        }
        /**
         * 如果调用存储过程接口得到的接口不为OK，则记录错误日志
         */
        if (!tgsParameter.getRes().equals("OK")){
            log.error(tgsParameter.toString());
        }
    }

    /**
     * ATT数据处理
     * @param tgsParameter
     * @return
     */
    public String att(TgsParameter tgsParameter){
        String result = "";
        try {
            tgsDao.callAtt(tgsParameter);
            if ("OK".equals(tgsParameter.getRes())){
                result = "0 SFC_OK " + tgsParameter.getRes();
            }else {
                result = "0 SFC_OK " + tgsParameter.getRes();
            }
        }catch (Exception e){
            result = "存储过程调用异常";
            log.error(result+" : "+e.getMessage());
        }
        return result;
    }
}

