package com.hui.bobCat.service.db77.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.bobCat.been.BobcatErrorLog;
import com.hui.bobCat.been.BobcatStationMapping;
import com.hui.bobCat.been.SjTransferPdcaInput;
import com.hui.bobCat.dao.db77.BobcatErrorLogDAO;
import com.hui.bobCat.dao.db77.BobcatMain;
import com.hui.bobCat.service.db77.BobcatMainService;
import com.hui.bobCat.util.StationMappingInit;
import com.hui.commonutils.been.BobcatParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @author lihui
 * @title: BobcatMainServiceImpl
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:41
 */
@Service
@Slf4j
public class BobcatMainServiceImpl extends ServiceImpl<BobcatMain, SjTransferPdcaInput> implements BobcatMainService {

    @Autowired
    private BobcatMain bobcatMain;

    @Autowired
    private BobcatErrorLogDAO bobcatErrorLogDAO;

    public void errorMappingLog(BobcatParameter params) {
        //创建对象
        QueryWrapper<BobcatErrorLog> queryWrapper = new QueryWrapper<>();
        //通过queryWrapper设置条件
        //第一个参数字段名称，第二个参数设置值
        queryWrapper.eq("SN",params.getSn());
        queryWrapper.eq("PRODUCT",params.getProduct());
        queryWrapper.eq("PDCA_STATION",params.getStationId());
        int result = 0;
        int resultNum = 0;
        try {
                resultNum = bobcatErrorLogDAO.selectCount(queryWrapper);
                System.out.println(resultNum);
            if (resultNum == 0){
                BobcatErrorLog errorLog = new BobcatErrorLog();
                errorLog.setSn(params.getSn());
                errorLog.setPdcaStation(params.getStationId());
                errorLog.setProduct(params.getProduct());
                errorLog.setErrorType("ERROR_MAPPING");
                errorLog.setErrorMsg("错误信息: "+ params.getErrorMessage());
                errorLog.setParameter(params.getStringParameter());
                try {
                    result = bobcatErrorLogDAO.insert(errorLog);
                }catch (Exception e){
                    log.error("\t\n站点:" + params.getStationId() + "站点映射信息，请及时添加"  +
                            "\t\n插入日志SQL错误:"+e.getMessage() +
                            "\t\n接受参数为："+params.toString()+
                            "\t\nSQL错误信息为:"+e.getMessage());
                }
                if (result == 0){
                    log.error("\t\n站点:" + params.getStationId() + "站点映射信息，请及时添加"  +
                            "\t\n插入日志失败,result:" + result +
                            "\t\n接受参数为："+params.toString());
                }
            }
        }catch (Exception e){
            log.error("\t\n站点:" + params.getStationId() + "站点映射信息，请及时添加"  +
                    "\t\n查询日志失败,result:" + resultNum +
                    "\t\n接受参数为："+params.toString()+
                    "\t\nSQL错误信息为:"+e.getMessage());
        }

    }

    public void errorSqlLog(BobcatParameter params) {
        BobcatErrorLog errorLog = new BobcatErrorLog();
        errorLog.setSn(params.getSn());
        errorLog.setPdcaStation(params.getStationId());
        errorLog.setProduct(params.getProduct());
        errorLog.setErrorType("ERROR_SQL");
        errorLog.setErrorMsg("错误信息: "+ params.getErrorMessage());
        errorLog.setParameter(params.getStringParameter());
        int result = 0;
        try {
            result = bobcatErrorLogDAO.insert(errorLog);
        }catch (Exception e){
            log.error("\t\n站点:" + params.getStationId() +
                    "\t\n插入日志SQL错误:"+e.getMessage() +
                    "\t\n接受参数为："+params.toString()+
                    "\t\nSQL错误信息为:"+e.getMessage());
        }
        if (result == 0){
            log.error("\t\n站点:" + params.getStationId() +
                    "\t\n插入日志失败,result:" + result +
                    "\t\n接受参数为："+params.toString());
        }
    }

    public void errorCallLog(BobcatParameter params) {
        BobcatErrorLog errorLog = new BobcatErrorLog();
        errorLog.setSn(params.getSn());
        errorLog.setPdcaStation(params.getStationId());
        errorLog.setProduct(params.getProduct());
        errorLog.setErrorType("ERROR_CALL");
        errorLog.setErrorMsg("错误信息: "+ params.getErrorMessage());
        errorLog.setParameter(params.getStringParameter());
        int result = 0;
        try {
            result = bobcatErrorLogDAO.insert(errorLog);
        }catch (Exception e){
            log.error("\t\n站点:" + params.getStationId() +
                    "\t\n存储过程错误错误:"+e.getMessage() +
                    "\t\n接受参数为："+params.toString()+
                    "\t\nSQL错误信息为:"+e.getMessage());
        }
        if (result == 0){
            log.error("\t\n站点:" + params.getStationId() +
                    "\t\n插入日志失败,result:" + result +
                    "\t\n接受参数为："+params.toString());
        }
    }


    @Override
    public Boolean bobcatInfoDeal(BobcatParameter params) {
        //插入结果
        int result = 0;
        BobcatStationMapping bobcatStationMapping = new BobcatStationMapping();
        try {
            /**
             * 判断接受站点是否有维护映射关系
             * 如果存在返回true，否则返回false
             * @param params
             * @return
             */
            try {
                bobcatStationMapping = (BobcatStationMapping) StationMappingInit.contextMap.get(params.getStationId());
                //设置mes站点
                params.setTerminalId(bobcatStationMapping.getMesTerminal());
            } catch (Exception e) {
                params.setErrorMessage(e.toString());
                //插入日志表
                errorMappingLog(params);
                return false;
            }

            //设置defect
            if (params.getResult() != null) {
                if (params.getResult().equals("FAIL")) {
                    params.setDefect("ET001");
                }
            }
            //调用存储过程
            bobcatMain.queryMainId(params);
        } catch (Exception e) {
            params.setErrorMessage(e.toString()+"\t\n"+"SN:"+ params.getSn()+"RES:"+ params.getRes()+"TRECID:" + params.getTrecId());
            errorCallLog(params);
            return false;
        }
        //调用cgsn
        if (params.getLcgSn() != null && !StringUtils.isEmpty(params.getTrecId()) && params.getLcgSn().length() == 173) {
            //trceId不能为0
            if (!"0".equals(params.getTrecId())){
                //截取cg码，从40位开始截取，截取长度44
                params.setTcgSn(StrUtil.subWithLength(params.getLcgSn(), 39, 44));
                try {
                    bobcatMain.queryCgSn(params);
                } catch (Exception e) {
                    params.setErrorMessage(e.toString()+"\t\n"+"SN:"+ params.getSn()+"CGSNRES:"+ params.getCgsnRes()+"CGSN:" + params.getTcgSn());
                    errorCallLog(params);
                    return false;
                }
            }
        }
        //判断trecId是否为空和表名是否存在
        if (!StringUtils.isEmpty(params.getTrecId()) && !StringUtils.isEmpty(bobcatStationMapping.getStationTableName())) {
            //trceId不能为0
            if (!"0".equals(params.getTrecId())){
                try {
                    params.setMainId(params.getTrecId());
                    //执行插入
                    result = bobcatMain.insertStationTable(bobcatStationMapping.getStationTableName(), params);
                } catch (Exception e) {
                    params.setErrorMessage(e.toString());
                    errorSqlLog(params);
                    return true;
                }
            }
        } else {
            if ("OK".equals(params.getRes())) {
                log.info("\n重复过站:" + "\nsn:" + params.getSn() + "\nres:" + params.getRes() + "\ntraceId:" + params.getTrecId());
                return true;
            } else {
                log.info("\n参数异常:" + "\nsn:" + params.getSn() + "\nres:" + params.getRes() + "\ntraceId:" + params.getTrecId());
                return true;
            }
        }
        return true;
    }



}
