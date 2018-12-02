package com.atguigu.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 必须有@MapperScan 指定mapper接口的包位置 创建代理对象
 */
@Configuration
@MapperScan(basePackages = {"com.atguigu.springboot.mapper"})
public class MybatisConfig {
    /**
     * 用以定制Configuration的配置
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){

            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
