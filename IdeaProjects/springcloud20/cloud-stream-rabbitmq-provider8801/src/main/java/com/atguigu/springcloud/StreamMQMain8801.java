package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author lzx
 * @date 2020/5/15 16:42
 * @Description TODO
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8801 {
    public static void main(String[] args){
        SpringApplication.run(StreamMQMain8801.class, args);
    }
}
