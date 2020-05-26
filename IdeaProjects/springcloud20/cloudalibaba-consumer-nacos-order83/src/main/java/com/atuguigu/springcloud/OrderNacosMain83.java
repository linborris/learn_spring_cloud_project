package com.atuguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lzx
 * @date 2020/5/26 14:50
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {
    public static void main(String[] args){
        SpringApplication.run(OrderNacosMain83.class, args);
    }
}
