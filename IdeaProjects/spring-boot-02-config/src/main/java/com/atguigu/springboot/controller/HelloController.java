package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    private volatile  boolean lockFlag = true;
    @ResponseBody
    @RequestMapping("/hello")
    public String helloWorld(){
        return "fast helloWorld!";
    }

    @ResponseBody
    @RequestMapping("/testLock")
    public String testLock(){

        if(lockFlag){

            System.out.println("大家都即将卡住");

                lockFlag = false;
                System.out.println("成功改变锁");
        }else {
            System.out.println("系统被占用");
            return "系统被占用";
        }
        lockFlag = true;
        System.out.println("流程成功启动");
        return "流程成功启动";
    }

}
