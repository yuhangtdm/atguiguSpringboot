package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session,
                        Map<String,Object> map){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("msg","密码错误");
        return "login";
    }
}
