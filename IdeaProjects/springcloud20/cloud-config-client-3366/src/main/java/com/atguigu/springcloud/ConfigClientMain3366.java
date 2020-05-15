package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author lzx
 * @date 2020/5/15 11:02
 * @Description TODO
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3366.class, args);
    }
}
