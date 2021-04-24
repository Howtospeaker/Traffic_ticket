package com.TrafficTicket.controller;


import com.TrafficTicket.entity.Police;
import com.TrafficTicket.entity.Ticket;
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
    PoliceService policeService = (PoliceService) new ClassPathXmlApplicationContext("conf/applicationContext.xml").getBean("policeServiceImpl");

    //罚单录入
    public String addTicket(Ticket ticket) {
        if (policeService.addTicket(ticket)==1){
            return "录入成功";
        }
        return "录入失败";
    }
    //罚单修改
    public String updateTicket(Ticket ticket){
        if (policeService.updateTicket(ticket)==1){
            return "更新成功";
        }
        return "更新失败";
    }
    //罚单删除
    public String deleteTicket(String ticketId){
        if (policeService.deleteTicket(ticketId)==1){
            return "删除成功";
        }
        return "删除失败";
    }
    //罚单查询
    public List<Ticket> selectAllTicket(){
        return policeService.selectAllTicket();
    }

    //交警登录
    public boolean login(String loginAct, String loginPwd) {
        loginPwd= MD5Util.getMD5(loginPwd);
        if (policeService.login(loginAct,loginPwd)==1){
            System.out.println("登录成功");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "账号或密码输入错误，请检查！", "登录失败",JOptionPane.WARNING_MESSAGE);
            System.out.println("账号密码错误");
        }
        return false;
    }
    //交警注册
    public boolean register(Police police){
        police.setLoginPwd(MD5Util.getMD5(police.getLoginPwd()));
        return policeService.register(police);
    }
}
