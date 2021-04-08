package com.hui.bobcatweb.controller;

import com.hui.bobcatweb.feign.TgsFeign;
import com.hui.commonutils.been.TgsParameter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lihui
 * @title: TgsTestController
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2021/3/2514:09
 */
@RestController
@RequestMapping(value = "testCon")
public class TgsController {

    @Resource
    private TgsFeign tgsFeign;

    @RequestMapping(value = "c1")
    public String c1(TgsParameter tgsParameter){
        return tgsFeign.tgs(tgsParameter);
    }
}
