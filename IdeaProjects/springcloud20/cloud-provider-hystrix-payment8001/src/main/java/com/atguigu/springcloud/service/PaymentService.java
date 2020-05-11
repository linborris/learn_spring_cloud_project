package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
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

    /**
     * 服务降级
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" payment_OK,id:"+id+"\t O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+" payment_Timeout,id:"+id+"\t"+" O(∩_∩)O哈哈~耗时长";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeoutHandler,id:"+id+"程序异常请稍后再试\t o(╥﹏╥)o";
    }

    //==========================服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_FallBack",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw  new RuntimeException("***id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t 调用成功！，流水号:"+serialNumber;
    }

    public String paymentCircuitBreaker_FallBack(Integer id){
        return "id不能为负数，请稍后再试\t o(╥﹏╥)o" +id;
    }
}
