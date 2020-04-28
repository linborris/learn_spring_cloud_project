package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lzx
 * @date 2020/4/26 13:50
 * @Description TODO
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//集群通过这个注解赋予负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
