package com.TrafficTicket.entity;

import com.TrafficTicket.exception.registerException;
import lombok.AllArgsConstructor;
import lombok.Data;


public class Driver {
    private Integer driverId;
    private String name;
    private String sex;
    private Integer age;
    private Integer driverNum;
    private String loginAct;
    private String loginPwd;

    public Driver(Integer driverId, String name, String sex, Integer age, Integer driverNum, String loginAct, String loginPwd) {
        this.driverId = driverId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.driverNum = driverNum;
        this.loginAct = loginAct;
        this.loginPwd = loginPwd;
    }

    public Driver() {
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(Integer driverNum) {
        this.driverNum = driverNum;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
