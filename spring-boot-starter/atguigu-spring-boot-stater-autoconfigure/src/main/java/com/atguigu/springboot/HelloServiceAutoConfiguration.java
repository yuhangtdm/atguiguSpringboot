package com.atguigu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类 目的是提供服务给springboot 直接导入 可以利用配置文件完成一些配置 提供组件实现一些功能
 *
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloProperties properties;

    @Bean
    public HelloService helloService(){
        HelloService helloService=new HelloService();
        helloService.setHelloProperties(properties);
        return helloService;
    }

}
