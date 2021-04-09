package com.hui.tgs.controller;

import com.hui.commonutils.been.TgsParameter;
import com.hui.tgs.service.db17.TgsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihui
 * @title: TestController
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2021/3/2513:49
 */
@RestController
@RequestMapping(value = "/tgs")
@RefreshScope
public class tgsController {

    @Autowired
    private TgsService tgsService;

    @ApiOperation(value = "tgs接口测试")
    @RequestMapping(value = "/index.cgx",method = RequestMethod.POST)
    @ResponseBody
    public String tgsController(TgsParameter tgsParameter){
        return tgsService.tgsToDealWith(tgsParameter);
    }
}
