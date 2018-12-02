package com.atguigu.consumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * 用于服务发现
 * @EnableTransactionManagement 开启事务
 * proxyTargetClass 指定生成cglib代理 意思是在类上加 @Aspect注解会报错 如果类实现了接口则没问题
 * @Transactional 只回滚RuntimeException 和Error的 受检查异常抛出异常也不会回滚
 * 可以指定抛出异常的父类 @Transactional(rollbackFor = Exception.class)
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableTransactionManagement
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }

    @Bean
    @LoadBalanced //用于负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
