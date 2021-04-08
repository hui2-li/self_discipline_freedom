package com.hui.bobcatweb.feign;

import com.hui.bobcatweb.feign.impl.BobcatMainFeignImpl;
import com.hui.commonutils.been.BobcatParameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lihui
 * @title: BobcatMainFeign
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1515:59
 */

@FeignClient(name = "bobCat-serivice" ,fallback = BobcatMainFeignImpl.class)
public interface BobcatMainFeign {

    /**
     * 调用
     * @param params
     * @return
     */
    @RequestMapping(value = "/bobcat/index.cgi",method = RequestMethod.POST)
    @ResponseBody
    public Boolean bobCat(@RequestBody BobcatParameter params);
}
