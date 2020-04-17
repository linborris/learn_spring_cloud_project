package com.atguigu.task.controller;

import com.atguigu.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
public class HelloController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("hello")
    public String hello(){
        asyncService.hello();
        return "success";
    }
}
