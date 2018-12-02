package com.atguigu.springboot;

import com.atguigu.springboot.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {
        User user=new User(1,"小黄");
        rabbitTemplate.convertAndSend("exchange.fanout","xxx",user);
    }



    @Test
    public void test() {
        Object obj=rabbitTemplate.receiveAndConvert("gulixueyuan.news");
        System.out.println(obj.getClass());
        System.out.println(obj);
    }

    /**
     * 创建exchange queue binding
     */
    @Test
    public void test2(){
        //Exchange exchange=new DirectExchange("amqp.springboot");
        //amqpAdmin.declareExchange(exchange);
        //Queue queue=new Queue("amqp.queue");
        //amqpAdmin.declareQueue(queue);
        Binding binding=new Binding("amqp.queue",Binding.DestinationType.QUEUE,"amqp.springboot","amqp.root",null);
        amqpAdmin.declareBinding(binding);
    }

}
