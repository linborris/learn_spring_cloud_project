package com.atguigu.springboot;

import com.atguigu.springboot.bean.Person;
import com.atguigu.springboot.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringBoot02ConfigApplicationTests {


    @Autowired
    Person person;
    @Autowired
    private ApplicationContext ioc;
    @Autowired
    private HelloController helloController;

    @Test
    public void contextLoads() {

//        Person person1 = new Person();
//        Person person2 = person1;
//        person1.setAge(6);

//        System.out.println(person2.getAge());
        System.out.println(person);
    }

    @Test
    public void testIoc() {
        System.out.println(ioc.containsBean("helloService"));

    }
}
