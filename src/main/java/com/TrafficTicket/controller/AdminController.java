package com.TrafficTicket.controller;

import com.TrafficTicket.entity.AdminTicketView;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.service.AdminService;
import com.TrafficTicket.util.MD5Util;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Locale;

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
    public boolean addCarInfo(Car car){
        car.setCarId(car.getCarId().toUpperCase());
        if (!(car.getCarId().contains("I")&&car.getCarId().contains("O"))) {
            System.out.println("车牌号中不能出现I 和 O 的字符");
        } else {
            if (adminService.addCarInfo(car) == 1) {
                System.out.println("录入成功");
                return true;
            } else {
                System.out.println("录入车辆信息失败");
            }
        }
        return false;
    }
    //车辆修改
    public boolean updateCarInfo(Car car){
        if (adminService.updateCarInfo(car)==1){
            System.out.println("更新成功");
            return true;
        } else {
            System.out.println("更新失败");
        }
        return false;
    }
    //车辆删除(根据carId来进行删除)
    public boolean deleteCarInfo(String carId){
        if (adminService.deleteCarInfo(carId)==1){
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        return false;
    }
    //车辆查询
    public List<Car> selectAllCarInfo(){

        return adminService.selectAllCarInfo();
    }

    //对交警信息的操作
    //交警录入
    public boolean addPolice(Police police){
        if (adminService.addPolice(police)==1){
            System.out.println("录入成功");
            return true;
        } else {
            System.out.println("录入失败");
        }
        return false;
    }
    //交警修改
    public boolean updatePolice(Police police){
        if (adminService.updatePolice(police)==1){
            System.out.println("更新成功");
            return true;
        } else {
            System.out.println("更新失败");
        }
        return false;
    }
    //交警删除
    public boolean deletePolice(String policeId){
        if (adminService.deletePolice(policeId)==1){
            System.out.println("删除成功");
            return true;
        } else {
            System.out.println("删除失败");
        }
        return false;
    }
    //交警查询
    public List<Police> selectAllPolice(){
        return adminService.selectAllPolice();
    }

    //罚单查询
    public List<AdminTicketView> AdminSelectTicketView(){
        return adminService.selectTicketView();
    }

    //管理员登录
    public boolean login(String loginAct, String loginPwd) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.toString();
            System.out.println(ip);
            loginPwd= MD5Util.getMD5(loginPwd);
            if (adminService.login(loginAct,loginPwd,ip)==1){
                System.out.println("登录成功");
                return true;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }
}
