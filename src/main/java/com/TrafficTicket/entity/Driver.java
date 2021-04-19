package com.TrafficTicket.entity;

import lombok.Data;

@Data
public class Driver {
    private Integer driverId;
    private String name;
    private String sex;
    private Integer age;
    private Integer driverNum;
    private String loginAct;
    private String loginPwd;
}
