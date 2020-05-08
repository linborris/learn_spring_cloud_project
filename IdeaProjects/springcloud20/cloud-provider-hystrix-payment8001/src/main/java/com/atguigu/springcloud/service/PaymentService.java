package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author lzx
 * @date 2020/5/6 14:42
 * @Description TODO
 **/
@Service

public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" payment_OK,id:"+id+"\t O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int a=10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+" payment_Timeout,id:"+id+"\t"+" O(∩_∩)O哈哈~耗时长";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeoutHandler,id:"+id+"程序异常请稍后再试\t o(╥﹏╥)o";
    }
}
