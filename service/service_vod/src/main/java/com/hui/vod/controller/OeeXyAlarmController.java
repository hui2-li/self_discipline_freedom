package com.hui.vod.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.vod.been.OeeXyAlarm;
import com.hui.vod.service.db166.OeeXyAlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@Api("测试接口")
@RestController
@RequestMapping("/oee-xy-alarm")
@RefreshScope//nacos自动刷新配置
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihui
 * @since 2020-12-02
 */
public class OeeXyAlarmController {


    @Autowired
    private OeeXyAlarmService oeeXyAlarmService;

    @ApiOperation("测试Bobcat是否通过")
    @GetMapping("test/{pid}")
    public List<OeeXyAlarm> dd(@PathVariable BigDecimal pid) {
        OeeXyAlarm o = new OeeXyAlarm();
        o.setPid(pid);
        QueryWrapper<OeeXyAlarm> queryWrapper = new QueryWrapper<OeeXyAlarm>();
        //queryWrapper.gt("pid",pid);
        queryWrapper.eq("pid",o.getPid());
        List<OeeXyAlarm> result = oeeXyAlarmService.list(queryWrapper);
        return result;
    }

}

