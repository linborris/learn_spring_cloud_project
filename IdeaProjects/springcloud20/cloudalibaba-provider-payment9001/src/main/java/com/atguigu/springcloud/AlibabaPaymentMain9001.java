package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lzx
 * @date 2020/5/26 14:25
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentMain9001 {
    public static void main(String[] args){
        SpringApplication.run(AlibabaPaymentMain9001.class, args);
    }
}
