package com.atguigu.amqp.service;

import com.atguigu.amqp.entity.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AmqpService {

    @RabbitListener(queues = "atguigu")
    public void getMsg(Book book){
        System.out.println("获取到了队列消息！");
        System.out.println(book);
    }


}
