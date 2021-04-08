package com.hui.bobcatweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lihui
 * @title: BobcatWebApplication
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/714:44
 */
@ComponentScan(basePackages = {"com.hui"})
@EnableFeignClients(basePackages = "com.hui.bobcatweb.feign")
@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class TgsConApplication {

    public static void main(String[] args) {
        SpringApplication.run(TgsConApplication.class,args);
    }
}
