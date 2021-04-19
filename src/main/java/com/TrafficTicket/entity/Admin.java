package com.TrafficTicket.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer adminId;
    private String name;
    private String loginAct;
    private String loginPwd;
    private String allowsIp;
}
