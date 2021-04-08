package com.hui.bobCat.controller;


import com.hui.bobCat.been.BobcatErrorLog;
import com.hui.bobCat.service.db77.BobcatMainService;
import com.hui.commonutils.R;
import com.hui.commonutils.been.BobcatParameter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    public Boolean bobCat(@RequestBody BobcatParameter params) {
        return bobcatMainService.bobcatInfoDeal(params);
    }


    @ApiOperation("测试")
    @RequestMapping(value = "/test")
    public int BobCat(@RequestBody BobcatErrorLog logParams){

        return 0;
    }

}
