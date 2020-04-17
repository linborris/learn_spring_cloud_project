package com.atguigu.providerticket.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public String getTicket(){
        System.out.println("在8002端口启动");
        return "《厉害了，我的国》";
    }

}
