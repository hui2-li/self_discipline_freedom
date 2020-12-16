package com.hui.bobCat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.bobCat.been.OeeXyAlarm;
import com.hui.bobCat.service.db166.OeeXyAlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihui
 * @since 2020-12-01
 */
@Api("测试接口")
@RestController
@RequestMapping("/oee-xy-alarm")
@RefreshScope
public class OeeXyAlarmController {

    @Value(value = "${mybatis-plus.mapper-locations-db166}")
    private String locations;

    @Autowired
    private OeeXyAlarmService oeeXyAlarmService;

    @ApiOperation("测试Bobcat是否通过")
    @GetMapping("test/{pid}")
    @RefreshScope
    public List<OeeXyAlarm> dd(@PathVariable double pid) {
        OeeXyAlarm o = new OeeXyAlarm();

        o.setPid(pid);
        QueryWrapper<OeeXyAlarm> queryWrapper = new QueryWrapper<OeeXyAlarm>();
        //queryWrapper.gt("pid",pid);
        queryWrapper.eq("pid",o.getPid());
        List<OeeXyAlarm> result = oeeXyAlarmService.list(queryWrapper);
        return result;
    }

    @ApiOperation("测试Bobcat是否通过")
    @GetMapping("test1")
    @RefreshScope
    public List<OeeXyAlarm> testY() {

        return oeeXyAlarmService.testY();
    }
}

