package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author lzx
 * @date 2020/5/11 11:25
 * @Description TODO
 **/
@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "fallback-paymentInfo_OK-o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "fallback-paymentInfo_Timeout-o(╥﹏╥)o";
    }
}
