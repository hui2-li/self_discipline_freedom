package com.hui.bobcatweb.feign.impl;

import com.hui.bobcatweb.feign.TgsFeign;
import com.hui.commonutils.been.TgsParameter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lihui
 * @title: TgsFeignImpl
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/04/07 18:01
 */
@Slf4j
@Component
public class TgsFeignImpl implements TgsFeign {

    @Setter
    private Throwable cause;


    @Override
    public String tgs(TgsParameter tgsParameter) {
        log.error("feign调用异常"+cause);
        return null;
    }
}
