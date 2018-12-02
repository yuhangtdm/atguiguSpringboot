package com.atguigu.producer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.producer.service.TicketService;
import org.springframework.stereotype.Component;

@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "无问西东";
    }
}
