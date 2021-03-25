package com.hui.bobCat.util;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.bobCat.been.BobcatStationMapping;
import com.hui.bobCat.dao.db77.BobcatStationMappingDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihui
 * @title: StationMappingInit
 * @projectName self_discipline_freedom
 * @description: TODO 站点映射
 * @date 2020/12/149:36
 */
@Component
@Slf4j
public class StationMappingInit {

    public static Map<String, Object> contextMap=new HashMap<String,Object>();

    @Autowired
    private BobcatStationMappingDAO bobcatStationMappingDAO;


    /**
     * @Description 每五分钟同步数据库数据到内存中
     */
    @Scheduled(cron = "*/30 * * * * ?")
    /**
     * 启动加载一次
     */
    @PostConstruct
    public void init(){
        //log.info("************ 开始从数据库同步字典表到内存中 ************");
        try {
            QueryWrapper<BobcatStationMapping> queryWrapper = new QueryWrapper<>();
            //enabled为Y的才加载
            queryWrapper.eq("enabled","Y");
            List<BobcatStationMapping> result= bobcatStationMappingDAO.selectList(queryWrapper);
            for (BobcatStationMapping lresult: result) {
                contextMap.put(lresult.getPdcaStation() , lresult);
            }

            //log.info("站点映射表数据:"+contextMap.toString());
            //log.info("************ 结束从数据库同步字典表到内存中 ************");
        }catch (Exception e){
            log.error("同步数据到内存中出现异常："+e.getMessage());
        }
    }



}
