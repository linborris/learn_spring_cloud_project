package com.atguigu.springboot.config;

import com.atguigu.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyAppConfig {

//    @Bean
    public HelloService helloService(){
        System.out.println("执行配置，添加类....");
        return new HelloService();
    }
}
