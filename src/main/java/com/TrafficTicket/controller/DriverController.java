package com.TrafficTicket.controller;

import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.DriverTicketView;
import com.TrafficTicket.service.DriverService;
import com.TrafficTicket.service.PoliceService;
import com.TrafficTicket.service.impl.DriverServiceImpl;
import com.TrafficTicket.util.MD5Util;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DriverController {
/*
    驾驶员：
    (1)罚单查询（分别按车牌号、驾驶证号等）、罚单缴费（修改缴费状态）
* */
    DriverService driverService = (DriverService) new ClassPathXmlApplicationContext("conf/applicationContext.xml").getBean("driverServiceImpl");
    //罚单查询
    public List<DriverTicketView> DriverSelectTicketView(){
        return driverService.selectTicketView();
    }
    //罚单缴费（修改缴费状态）
    public String updateTicketFine(Integer driverId){
        
        if (driverService.updateTicketFine(driverId)==1){
            return "缴费成功";
        }
        return "缴费失败";
    }

    //驾驶员登录
    public boolean login(String loginAct, String loginPwd) {
        loginPwd= MD5Util.getMD5(loginPwd);
        if (driverService.login(loginAct,loginPwd)==1){
            System.out.println("登录成功");
            return true;
        } else {
            System.out.println("账号密码错误");
        }
        return false;
    }

    //驾驶员注册
    public boolean register(Driver driver){
        driver.setLoginPwd(MD5Util.getMD5(driver.getLoginPwd()));
        return driverService.register(driver);
    }
}
