package com.atguigu.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BuyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("buy")
    public String buy(String name){
        String ticket = restTemplate.getForObject("http://PRODUCER-TICKET/ticket", String.class);
        return name+"购买了"+ticket;
    }
}
