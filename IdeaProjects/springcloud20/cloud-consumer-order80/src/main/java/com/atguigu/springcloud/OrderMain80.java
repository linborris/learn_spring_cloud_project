package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author lzx
 * @date 2020/4/16 16:54
 * @Description TODO
 **/
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {

public static void main(String[] args){
    SpringApplication.run(OrderMain80.class, args);
}


    
}
