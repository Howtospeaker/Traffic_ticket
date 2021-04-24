package com.TrafficTicket.entity;

import com.TrafficTicket.exception.registerException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Driver {
    private Integer driverId;
    private String name;
    private String sex;
    private Integer age;
    private Integer driverNum;
    private String loginAct;
    private String loginPwd;

//    public void setAge(Integer age) throws registerException {
//        if (age<18){
//            throw new registerException("注册异常");
//        } else
//        this.age = age;
//    }
}
