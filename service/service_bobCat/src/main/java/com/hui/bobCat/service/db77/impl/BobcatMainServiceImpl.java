package com.hui.bobCat.service.db77.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.bobCat.been.SjTransferPdcaInput;
import com.hui.bobCat.dao.db77.BobcatMain;
import com.hui.bobCat.service.db77.BobcatMainService;
import com.hui.bobCat.util.StationMappingInit;
import com.hui.commonutils.R;
import com.hui.commonutils.been.BobcatParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @author lihui
 * @title: BobcatMainServiceImpl
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:41
 */
@Service
@Slf4j
public class BobcatMainServiceImpl extends ServiceImpl<BobcatMain, SjTransferPdcaInput>  implements BobcatMainService {

    @Autowired
    private BobcatMain bobcatMain;

    @Override
    public String testInsert(BobcatParameter params){
        Map<String, Object> mapParams = new HashMap<String, Object>();
        //得到站点id
        params.setTerminalId(StationMappingInit.contextMap.get(params.getStationName()).toString());
        //根据站点获取制程
        System.out.println("terminalId:"+params.getTerminalId());
        //mapParams.put("trecId",params.getTrecId());
        bobcatMain.queryMainId(params);
        //List<SjTransferPdcaInput> resultMainId = (List<SjTransferPdcaInput>)mapParams.get("res");
        String mainId = "";
        System.out.println(params.getTrecId());
        return mainId;
    }

    @Override
    public R bobcatInfoDeal(BobcatParameter params) {
        //main_id
        String mainId = null;
        //插入结果
        int result = 0 ;
        try {
            //得到站点id
            params.setTerminalId(StationMappingInit.contextMap.get(params.getStationName()).toString());
            System.out.println("terminalId:"+params.getTerminalId());
            //调用存储过程
            bobcatMain.queryMainId(params);
            System.out.println(params.getTrecId());
        }catch (Exception e){
            e.printStackTrace();
            log.error("存储过程调用异常"+e.getMessage());
            return R.error();
        }
        //根据机种和制程动态获取表名
        String tableName = chooseTableName(params.getProduct(),params.getStationName());
        //如果main_id不等于空插入对应的表
        if (!StringUtils.isEmpty(params.getTrecId()) && !StringUtils.isEmpty(tableName)){
            try {
                params.setMainId(params.getTrecId());
                //执行插入
                result = bobcatMain.insertStationTable(tableName,params);
            }catch (Exception e){
                e.printStackTrace();
                log.error("SQL执行异常"+e.getMessage());
                return R.error();
            }
        }else {
            log.info("main_id为空");
        }
        return R.ok().data("Number of successful",result);
    }

    /**
     * 获取表名
     * @param product 机种
     * @param stationName 制程
     * @return
     */
    public String chooseTableName(String product, String stationName){
        String tabelName = "bobcat_";
        if (product.equals("D846")){
            switch (stationName){
                case "IQC-DISPLAY-2":
                    tabelName=tabelName+"D846"+"_"+"IQC_DISPLAY_2";
                    break;
                case "TEST22":
                    tabelName=tabelName+"D846"+"_"+"TEST22";
                    break;
                case "IQC-DEV5":
                    tabelName=tabelName+"D846"+"_"+"D846_IQC_DEV5";
                    break;
                case "LCM_DISPLAY_2":
                    tabelName=tabelName+"D846"+"_"+"LCM-DISPLAY-2";
                    break;
                case "TEST18":
                    tabelName=tabelName+"D846"+"_"+"TEST18";
                    break;
                case "IQC-DISPLAY":
                    tabelName=tabelName+"D846"+"_"+"IQC_DISPLAY";
                    break;
                case "IQC-GRAPE":
                    tabelName=tabelName+"D846"+"_"+"IQC_GRAPE";
                    break;
                case "TEST38":
                    tabelName=tabelName+"D846"+"_"+"TEST38";
                    break;
                case "SUB-OQC-DISPLAY":
                    tabelName=tabelName+"D846"+"_"+"SUB_OQC_DISPLAY";
                    break;
                default:
                    log.error("此制程有误："+"机种:"+product+";制程:"+stationName);
                    return null;
            }
            return tabelName;
        }else if (product.equals("D847")){
            switch (stationName){
                case "IQC-DISPLAY-2":
                    tabelName=tabelName+"D847"+"_"+"IQC_DISPLAY_2";
                    break;
                case "LCM-GRAPE-CAL":
                    tabelName=tabelName+"D847"+"_"+"LCM_GRAPE_CAL";
                    break;
                case "TEST24":
                    tabelName=tabelName+"D847"+"_"+"TEST24";
                    break;
                case "TEST22":
                    tabelName=tabelName+"D847"+"_"+"TEST22";
                    break;
                case "IQC-DEV5":
                    tabelName=tabelName+"D847"+"_"+"IQC_DEV5";
                    break;
                case "TEST26":
                    tabelName=tabelName+"D847"+"_"+"TEST26";
                    break;
                case "LCM-DISPLAY-2":
                    tabelName=tabelName+"D847"+"_"+"LCM_DISPLAY_2";
                    break;
                case "CG-5":
                    tabelName=tabelName+"D847"+"_"+"CG_5";
                    break;
                case "TEST18":
                    tabelName=tabelName+"D847"+"_"+"TEST18";
                    break;
                case "IQC-DISPLAY":
                    tabelName=tabelName+"D847"+"_"+"IQC_DISPLAY";
                    break;
                case "IQC-GRAPE":
                    tabelName=tabelName+"D847"+"_"+"IQC_GRAPE";
                    break;
                case "TEST38":
                    tabelName=tabelName+"D847"+"_"+"TEST38";
                    break;
                case "TEST25":
                    tabelName=tabelName+"D847"+"_"+"TEST25";
                    break;
                case "TEST20":
                    tabelName=tabelName+"D847"+"_"+"TEST20";
                    break;
                case "SUB-OQC-DISPLAY":
                    tabelName=tabelName+"D847"+"_"+"SUB_OQC_DISPLAY";
                    break;
                default:
                    log.error("此制程有误："+"机种:"+product+";制程:"+stationName);
                    return null;
            }
            return tabelName;
        }else {
            log.error("此机种有误:"+"机种为："+product);
            return null;
        }
    }
}
