package com.TrafficTicket.entity;


public class Admin {
    private Integer adminId;
    private String name;
    private String loginAct;
    private String loginPwd;
    private String allowsIp;

    public Admin(Integer adminId, String name, String loginAct, String loginPwd, String allowsIp) {
        this.adminId = adminId;
        this.name = name;
        this.loginAct = loginAct;
        this.loginPwd = loginPwd;
        this.allowsIp = allowsIp;
    }

    public Admin() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAllowsIp() {
        return allowsIp;
    }

    public void setAllowsIp(String allowsIp) {
        this.allowsIp = allowsIp;
    }
}
