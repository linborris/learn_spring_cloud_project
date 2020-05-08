package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author lzx
 * @date 2020/5/8 14:17
 * @Description TODO
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderHystrixMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
