package com.hui.bobcatweb.controller;

import com.hui.bobcatweb.feign.BobcatMainFeign;
import com.hui.commonutils.R;
import com.hui.commonutils.been.BobcatParameter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lihui
 * @title: BobcatMainController
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1514:43
 */
@Api("bobcat接口负载")
@RestController
@RequestMapping("/mes/bobcat")
@Slf4j
public class BobcatMainController {

    @Resource
    private BobcatMainFeign bobcatMainFeign;


    @ApiOperation("bobcat的ADD_RECORD接口")
    @RequestMapping(value = "/index.cgi",method = RequestMethod.POST)
    @ResponseBody
    public R bobCat(@RequestBody BobcatParameter params) {

        return R.ok().data("result", bobcatMainFeign.bobCat(params));
    }
}
