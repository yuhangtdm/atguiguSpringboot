package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HelloController {

    @RequestMapping("abc")
    public String hello(Model model){
        model.addAttribute("users",Arrays.asList("tom","jack","rocy"));
        return "success";
    }
}
