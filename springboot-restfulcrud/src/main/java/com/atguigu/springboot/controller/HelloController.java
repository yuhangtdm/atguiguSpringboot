package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.CustomerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(String user){
        if(!"admin".equals(user)){
            throw new CustomerException(-1,"非管理员不可访问");
        }
        return "hello world";
    }


    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users",Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
