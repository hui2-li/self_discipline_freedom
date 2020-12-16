package com.hui.bobcat.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lihui
 * @title: BobcatGateWayApplication
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/914:16
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BobcatGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(BobcatGateWayApplication.class, args);
    }
}
