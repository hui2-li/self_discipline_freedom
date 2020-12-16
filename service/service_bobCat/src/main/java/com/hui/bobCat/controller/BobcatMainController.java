package com.hui.bobCat.controller;


import com.hui.bobCat.service.db77.BobcatMainService;
import com.hui.commonutils.R;
import com.hui.commonutils.been.BobcatParameter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihui
 * @title: BobcatMainController
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:43
 */
@Api("bobcat接口文档")
@RestController
@RequestMapping("/bobcat")
@Slf4j
public class BobcatMainController {

    @Autowired
    private BobcatMainService bobcatMainService;

    @ApiOperation("bobcat的ADD_RECORD接口")
    @RequestMapping(value = "/index.cgi",method = RequestMethod.POST)
    @ResponseBody
    public R bobCat(@RequestBody BobcatParameter params) {

        return R.ok().data("result", bobcatMainService.bobcatInfoDeal(params));
    }

    @ApiOperation("测试添加接口")
    @PostMapping(value = "testInsert")
    public R testInsert(@RequestBody BobcatParameter parameter) {
        String result = bobcatMainService.testInsert(parameter);
        return R.ok().data("结果", result);
    }


}
