package com.TrafficTicket.controller;


import com.TrafficTicket.entity.Ticket;
import com.TrafficTicket.service.PoliceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
