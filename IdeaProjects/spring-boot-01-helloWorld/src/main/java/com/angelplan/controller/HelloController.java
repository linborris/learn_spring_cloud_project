package com.angelplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public ModelAndView hello(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:http://www.baidu.com");
        return modelAndView;
    }
}
