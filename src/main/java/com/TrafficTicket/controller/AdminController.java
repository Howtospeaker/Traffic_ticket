package com.TrafficTicket.controller;

import com.TrafficTicket.entity.AdminTicketView;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.service.AdminService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminController {
/*
    管理员：
    (1) 车辆信息（车牌号、行驶证号、车主信息等）、
         交警信息（交警代号、交警姓名、所属分局等）的录入、修改、删除，查询
    (2) 罚单查询（分别按车牌号、驾驶证号、交警代码等）
*/
    AdminService adminService = (AdminService) new ClassPathXmlApplicationContext("conf/applicationContext.xml").getBean("adminServiceImpl");

    //对车辆信息的操作
    //车辆录入
    public String addCarInfo(Car car){
        if (adminService.addCarInfo(car)==0){
            return "插入失败";
        }
        return "插入成功";
    }
    //车辆修改
    public String updateCarInfo(Car car){
        if (adminService.updateCarInfo(car)==0){
            return "更新失败";
        }
        return "更新成功";
    }
    //车辆删除(根据carId来进行删除)
    public String deleteCarInfo(String carId){
        if (adminService.deleteCarInfo(carId)==0)
            return "删除失败";
        return "删除成功";
    }
    //车辆查询
    public List<Car> selectAllCarInfo(){

        return adminService.selectAllCarInfo();
    }

    //对交警信息的操作
    //交警录入
    public String addPolice(Police police){
        if (adminService.addPolice(police)==0){
            return "插入失败";
        }
        return "插入成功";
    }
    //交警修改
    public String updatePolice(Police police){
        if (adminService.updatePolice(police)==0){
            return "更新失败";
        }
        return "更新成功";
    }
    //交警删除
    public String deletePolice(String policeId){
        if (adminService.deletePolice(policeId)==0)
            return "删除失败";
        return "删除成功";
    }
    //交警查询
    public List<Police> selectAllPolice(){
        return adminService.selectAllPolice();
    }

    //罚单查询
    public List<AdminTicketView> AdminSelectTicketView(){
        return adminService.selectTicketView();
    }
}
