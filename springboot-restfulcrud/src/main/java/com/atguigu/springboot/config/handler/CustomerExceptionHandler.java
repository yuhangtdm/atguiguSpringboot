package com.atguigu.springboot.config.handler;

import com.atguigu.springboot.exception.CustomerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomerExceptionHandler  {

    /**
     * 此方法可以针对于特定异常返回对应的json数据 但是不可以自适应页面和客户端
     * @param ex
     * @return
     */
    /*@ExceptionHandler(CustomerException.class)
    @ResponseBody
    public Map<String,Object> handleCustomerException(CustomerException ex){
        Map<String,Object> map=new HashMap<>();
        map.put("code",ex.getCode());
        map.put("msg",ex.getMsg());
        return map;
    }*/

    @ExceptionHandler(CustomerException.class)
    public String handleCustomerException(CustomerException ex, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("code",ex.getCode());
        map.put("msg",ex.getMsg());
        request.setAttribute("javax.servlet.error.status_code",400);
        request.setAttribute("data",map);
        return "forward:/error";
    }
}
