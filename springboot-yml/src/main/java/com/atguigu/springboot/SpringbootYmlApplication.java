package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource() 用来读取xml里的bean
 */
@SpringBootApplication
@ImportResource()
public class SpringbootYmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootYmlApplication.class, args);
    }
}
