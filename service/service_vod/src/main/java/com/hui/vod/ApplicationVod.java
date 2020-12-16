package com.hui.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lihui
 * @title: ApplicationVod
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/220:27
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.hui"})
public class ApplicationVod {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationVod.class, args);
    }

}
