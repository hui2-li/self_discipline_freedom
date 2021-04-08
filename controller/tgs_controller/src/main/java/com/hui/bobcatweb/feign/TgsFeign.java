package com.hui.bobcatweb.feign;

import com.hui.bobcatweb.feign.impl.TgsFeignImpl;
import com.hui.commonutils.been.TgsParameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lihui
 * @title: TgsFeign
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/04/07 18:01
 */

@FeignClient(name = "tgs-serivice" ,fallback = TgsFeignImpl.class)
public interface TgsFeign {


    @RequestMapping(value = "/tgs/index.cgx",method = RequestMethod.POST)
    @ResponseBody
    public String tgs(TgsParameter tgsParameter);
}
