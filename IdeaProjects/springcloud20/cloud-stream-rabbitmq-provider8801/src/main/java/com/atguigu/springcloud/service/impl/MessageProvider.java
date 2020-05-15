package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author lzx
 * @date 2020/5/15 16:45
 * @Description TODO
 **/
@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serialNumber = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serialNumber).build());
        return null;
    }
}
