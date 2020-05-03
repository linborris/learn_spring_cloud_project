package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current < Integer.MAX_VALUE ? current+1 : 0;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.println("****这是第"+next+"次访问****");
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        if(serviceInstances==null || serviceInstances.size() < 1 ){
            return null;
        }
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
