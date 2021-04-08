package com.hui.tgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lihui
 * @title: TgsApplication
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2021/3/2513:35
 */
@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.hui"})
public class TgsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TgsApplication.class, args);
    }
}
