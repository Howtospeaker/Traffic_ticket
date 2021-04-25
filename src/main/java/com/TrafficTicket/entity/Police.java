package com.TrafficTicket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Police {
    private String policeId;
    private String name;
    private String policeStation;
    private String loginAct;
    private String loginPwd;
    private String sex;
    private Integer age;
}
