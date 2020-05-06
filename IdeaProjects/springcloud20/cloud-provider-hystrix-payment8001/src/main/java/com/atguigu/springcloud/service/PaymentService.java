package com.atguigu.springcloud.service;

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
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+" payment_Timeout,id:"+id+"\t T-T";
    }
}
