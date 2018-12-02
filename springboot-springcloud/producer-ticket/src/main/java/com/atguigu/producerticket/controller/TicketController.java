package com.atguigu.producerticket.controller;

import com.atguigu.producerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("ticket")
    public String ticket(){
        return ticketService.ticket();
    }
}
