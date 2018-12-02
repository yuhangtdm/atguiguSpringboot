package com.atguigu.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置dubbo生产者
 *  引入dubbo和zkclient的相关依赖
 *  1).配置dubbo的扫描包和服务注册地址等等
 *  2).配置dubbo的Service
 *
 */
@SpringBootApplication
public class ProducerTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerTicketApplication.class, args);
    }
}
