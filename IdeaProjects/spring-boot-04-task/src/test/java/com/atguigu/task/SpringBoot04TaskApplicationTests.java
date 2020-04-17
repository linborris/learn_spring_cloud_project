package com.atguigu.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    void contextLoads() {
    }

    @Test
    void sendMail1(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("345099945@qq.com");
        mailMessage.setText("我JAVA测试发送的第一封邮件");
        mailMessage.setTo("linborris@163.com");
        mailMessage.setSubject("刚刚忘了写标题");
        javaMailSender.send(mailMessage);
    }
    @Test
    void sendMail2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("345099945@qq.com");
        mimeMessageHelper.setText("<b style='color:red'>成功发送啦！高兴！<b>",true);
        mimeMessageHelper.setTo("linborris@163.com");
        mimeMessageHelper.setSubject("第三封邮件");
        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\每日任务药水分布图.jpg"));
        javaMailSender.send(mimeMessage);
    }
}
