package com.hui.bobcatweb.feign.impl;

import com.hui.bobcatweb.feign.BobcatMainFeign;
import com.hui.commonutils.R;
import com.hui.commonutils.been.BobcatParameter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lihui
 * @title: BobcatMainFeignImpl
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1516:01
 */
@Slf4j
@Component
public class BobcatMainFeignImpl implements BobcatMainFeign {

    @Setter
    private Throwable cause;

    @Override
    public R bobCat(BobcatParameter params) {
        log.error("feign调用异常"+cause);
        return R.error();
    }
}
