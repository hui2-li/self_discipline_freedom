package com.hui.bobCat.nacos;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lihui
 * @title: NacosPassword
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/117:00
 */
public class NacosPassword {
    @Test
    public void dd(){

        System.out.println(new BCryptPasswordEncoder().encode(""));
    }
}
