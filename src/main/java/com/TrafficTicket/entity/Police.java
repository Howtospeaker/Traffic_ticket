package com.TrafficTicket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Police {
    private String policeId;
    private String name;
    private String sex;
    private Integer age;
    private String policeStation;
    private String loginAct;
    private String loginPwd;


    @Override
    public String toString() {
        return "Police{" +
                "policeId='" + policeId + '\'' +
                ", name='" + name + '\'' +
                ", policeStation='" + policeStation + '\'' +
                ", loginAct='" + loginAct + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public Police(String policeId, String name, String sex, Integer age, String policeStation, String loginAct, String loginPwd) {
        this.policeId = policeId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.policeStation = policeStation;
        this.loginAct = loginAct;
        this.loginPwd = loginPwd;

    }

    public Police() {
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
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

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
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
