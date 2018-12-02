package com.atguigu.eurakaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 配置euraka
 * 开启服务
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakaServerApplication.class, args);
    }
}
