package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * spring
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //spring 启动该类


        /**
         */
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }

    public void test(HttpServletRequest request){

    }
}
