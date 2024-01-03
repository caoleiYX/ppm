package com.example.demo;

import erd.cloud.core.config.BaseErdApplication;
import erd.cloud.core.controller.ApplicationStarter;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableAsync
@EnableFeignClients(basePackages = {"erd.cloud","com.example.demo"})
@ComponentScan(basePackages = {"erd.cloud","com.example.demo"})
@MapperScan(basePackages = {"erd.cloud.**.mapper","com.example.demo.**.mapper"})
@DubboComponentScan(basePackages = {"erd.cloud.*","com.example.demo.*"})
public class ErdcloudApplication extends BaseErdApplication {

    public static void main(String[] args) {
        ApplicationStarter.start(ErdcloudApplication.class, args);
    }

}
