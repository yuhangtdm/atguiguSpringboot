package com.atguigu.producerticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者
 */
@SpringBootApplication
@EnableEurekaClient
public class ProducerTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerTicketApplication.class, args);
    }
}
