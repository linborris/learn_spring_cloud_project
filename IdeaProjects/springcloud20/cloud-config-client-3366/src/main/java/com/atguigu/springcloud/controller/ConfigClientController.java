package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lzx
 * @date 2020/5/14 16:50
 * @Description TODO
 **/
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;


    //curl -X POST "http://localhost:3366/actuator/refresh" 运维手动激活
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
