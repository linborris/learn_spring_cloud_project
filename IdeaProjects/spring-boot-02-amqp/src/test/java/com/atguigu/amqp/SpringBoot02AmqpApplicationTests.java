package com.atguigu.amqp;

import com.atguigu.amqp.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.amqp.core.Binding.DestinationType.QUEUE;

@SpringBootTest
class SpringBoot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    void contextLoads() {
    }

    @Test
    void sendDirectMsg(){
        Map map = new HashMap();
        map.put("key1", Arrays.asList("hello",123,true));
        map.put("key2","val2");
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",map);

    }
    @Test
    void receiveDirectMsg(){

        Object o = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(o.getClass());
        System.out.println(o);
    }
    @Test
    void sendDirectBookMsg(){
       Book b = new Book("西游记","吴承恩");
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",b);
    }
    @Test
    void receiveDirectBookMsg(){

        Object o = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(o.getClass());
        System.out.println(o);
    }
    @Test
    void auto() throws Exception{
        Book b = new Book("西游记","吴承恩");
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",b);
        Thread.sleep(5000);
        Object o = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(o.getClass());
        System.out.println(o);
    }
    @Test
    void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",QUEUE,"amqpadmin.exchange","amqpadmin.hello",null));
        System.out.println("创建交换器，队列，绑定成功！");
    }

}
