package com.hui.bobCat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lihui
 * @title: Application
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/111:44
 */
//支持计划任务
@EnableScheduling
/**
 * 支持多线程计划任务
 */

@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.hui"})
public class BobCatApplication {

    public static void main(String[] args) {
        SpringApplication.run(BobCatApplication.class, args);
    }

}
