package com.atguigu.springboot.controller;

import com.atguigu.springboot.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("say")
    @ResponseBody
    public String say(String name){
        return helloService.say(name);
    }
}
