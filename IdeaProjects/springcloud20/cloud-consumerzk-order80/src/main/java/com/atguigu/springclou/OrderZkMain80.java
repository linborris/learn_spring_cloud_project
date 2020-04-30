package com.atguigu.springclou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lzx
 * @date 2020/4/30 17:09
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
