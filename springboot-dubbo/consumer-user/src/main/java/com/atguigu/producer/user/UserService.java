package com.atguigu.producer.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.producer.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello(){
        System.out.println("我看了"+ticketService.getTicket());
    }
}
