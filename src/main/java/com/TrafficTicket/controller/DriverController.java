package com.TrafficTicket.controller;

import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.DriverTicketView;
import com.TrafficTicket.entity.Ticket;
import com.TrafficTicket.service.DriverService;
import com.TrafficTicket.service.PoliceService;
import com.TrafficTicket.service.impl.DriverServiceImpl;
import com.TrafficTicket.util.MD5Util;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.List;

public class DriverController {
    /*
        驾驶员：
        (1)罚单查询（分别按车牌号、驾驶证号等）、罚单缴费（修改缴费状态）
    * */
    DriverService driverService = (DriverService) new ClassPathXmlApplicationContext("conf/applicationContext.xml").getBean("driverServiceImpl");

    public List<Object> selectOwnTicket(Integer driverId) {
        return driverService.selectOwnTicket(driverId);
    }

    //罚单查询
    public List<DriverTicketView> DriverSelectTicketView() {
        return driverService.selectTicketView();
    }

    //罚单缴费（修改缴费状态）
    public boolean updateTicketFine(String ticketId) {

        if (driverService.updateTicketFine(ticketId) == 1) {
            System.out.println("缴费成功");
            return true;
        } else {
            System.out.println("缴费失败");
        }
        return false;
    }

    //驾驶员登录
    public Driver login(String loginAct, String loginPwd) {
        loginPwd = MD5Util.getMD5(loginPwd);
        Driver driver = driverService.login(loginAct, loginPwd);
        if (driver != null) {
            System.out.println("登录成功");
            return driver;
        } else {
            JOptionPane.showMessageDialog(null, "账号或密码输入错误，请检查！", "登录失败", JOptionPane.WARNING_MESSAGE);
            System.out.println("账号密码错误");
        }
        return null;
    }

    //驾驶员注册
    public boolean register(Driver driver, Integer age) {
        if (age >= 18) {
            driver.setLoginPwd(MD5Util.getMD5(driver.getLoginPwd()));
            return driverService.register(driver);
        } else {
            JOptionPane.showMessageDialog(null, "年龄不能小于18岁", "注册失败", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
