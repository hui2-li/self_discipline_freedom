package com.hui.bobCat.service.db77.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.bobCat.been.BobcatStationMapping;
import com.hui.bobCat.been.SjTransferPdcaInput;
import com.hui.bobCat.dao.db77.BobcatMain;
import com.hui.bobCat.service.db77.BobcatMainService;
import com.hui.bobCat.util.StationMappingInit;
import com.hui.commonutils.been.BobcatParameter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


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


    @Override
    public Boolean bobcatInfoDeal(BobcatParameter params) {
        //插入结果
        int result = 0;
        BobcatStationMapping bobcatStationMapping = new BobcatStationMapping();
        try {
            //得到站点id
            try {
                bobcatStationMapping = (BobcatStationMapping) StationMappingInit.contextMap.get(params.getStationId());
                //设置mes站点
                params.setTerminalId(bobcatStationMapping.getMesTerminal());
            } catch (Exception e) {
                log.error("\n没有" + params.getStationId() + "站点映射信息，请及时添加" + "\n接收信息：" + params.toString());
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
            e.printStackTrace();
            log.error("\n存储过程调用异常" + "\nsn:" + params.getSn() + "\nres:" + params.getRes() + "\ntrecId:" + params.getTrecId());
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
                    e.printStackTrace();
                    log.info(e.getMessage());
                    log.error("\n存储过程cgsn调用异常" + "\nsn:" + params.getSn() + "\ncgsnRes:" + params.getCgsnRes() + "\ncgsn：" + params.getTcgSn());
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
                    log.error("\nSQL执行异常" + e.getMessage() + "\n接收信息：" + params.toString());
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
