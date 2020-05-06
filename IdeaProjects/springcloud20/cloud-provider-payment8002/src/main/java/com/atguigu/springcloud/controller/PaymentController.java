package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author lzx
 * @date 2020/4/16 15:01
 * @Description TODO
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("****插入结果个数："+result);
        if(result >0){
            return new CommonResult(200,"插入数据库成功，server port："+serverPort,payment);
        }else {
            return new CommonResult(444,"插入数据库失败，server port："+serverPort,null);
        }

    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果：111"+payment);
        if(payment !=null ){
            return new CommonResult(200,"查询成功，server port："+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询id："+id+"server port："+serverPort,null);
        }
    }

    @GetMapping("/payment/discovery")
    public CommonResult<Object> discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services) {
            log.info("******"+element+"******");
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return new CommonResult(200,"服务注册发现成功，server port："+serverPort,discoveryClient);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping("/payment/feign/timeout")
    public String paymentTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
