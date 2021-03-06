package com.TrafficTicket.controller;


import com.TrafficTicket.entity.Police;
import com.TrafficTicket.entity.Ticket;
import com.TrafficTicket.service.AdminService;
import com.TrafficTicket.service.DriverService;
import com.TrafficTicket.service.PoliceService;
import com.TrafficTicket.util.MD5Util;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.List;

public class PoliceController {
    /*
        交警：
         (1)罚单信息（车牌号、驾驶证号、交警代号、违章时间、违章地点、罚款金额、缴费状态默认为未缴费等）的录入、
         对自己开出的罚单进行修改、删除、查询
    */
    PoliceService policeService = (PoliceService) new ClassPathXmlApplicationContext("conf/applicationContext.xml").getBean("policeServiceImpl");//罚单录入

    public boolean addTicket(Ticket ticket) {
        if (policeService.addTicket(ticket) == 1) {
            System.out.println("添加成功");
            return true;
        } else {
            System.out.println("添加失败");
        }
        return false;
    }

    //罚单修改
    public boolean updateTicket(Ticket ticket) {
        if (policeService.updateTicket(ticket) == 1) {
            System.out.println("更新成功");
            return true;
        } else {
            System.out.println("更新失败");
        }
        return false;
    }

    //罚单删除
    public boolean deleteTicket(String ticketId) {
        if (policeService.deleteTicket(ticketId) == 1) {
            System.out.println("删除成功");
            return true;
        } else {
            System.out.println("删除失败");
        }
        return false;
    }

    //罚单查询
    public List<Ticket> selectAllTicket() {
        return policeService.selectAllTicket();
    }

    //交警登录
    public Police login(String loginAct, String loginPwd) {
        loginPwd = MD5Util.getMD5(loginPwd);
        Police police = policeService.login(loginAct, loginPwd);
        if (police != null) {
            System.out.println("登录成功");
            return police;
        } else {
            JOptionPane.showMessageDialog(null, "账号或密码输入错误，请检查！", "登录失败", JOptionPane.WARNING_MESSAGE);
            System.out.println("账号密码错误");
        }
        return null;
    }

    //交警注册
    public boolean register(Police police, Integer age) {
        if (age >= 18) {
            police.setLoginPwd(MD5Util.getMD5(police.getLoginPwd()));
            return policeService.register(police);
        } else {
            JOptionPane.showMessageDialog(null, "年龄不能小于18岁", "注册失败", JOptionPane.WARNING_MESSAGE);

        }
        return false;
    }

    public List<Object> selectOwnTicket(String policeId) {
        return policeService.selectOwnTicket(policeId);
    }
}
