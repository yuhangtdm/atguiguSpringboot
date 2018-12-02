package com.atguigu.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * rabbitmq阿里云的docker安装以后
 * manager的方式安装
 * 15672是rabbitmq的管理控制台
 * springboot项目导入rabbit的jar包
 * 配置好了一切
 * 指定host
 * exchange：交换器
 * queue 队列
 * binding 用于绑定队列和交换器的 多对多
 * rootkey 路由器 用于指定发送的队列
 * @EnableRabbit 开启mq
 * RabbitMqTemplate 用于操作发送消息和接受消息
 * AmqpAdmin用于创建rabbitmq的对象
 *  @RabbitListener(queues = "atguigu") 用于监听队列的消息
 *
 *
 */
@SpringBootApplication
@EnableRabbit
public class SpringbootAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAmqpApplication.class, args);
    }
}
