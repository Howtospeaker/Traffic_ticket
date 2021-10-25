package com.TrafficTicket.controller;

import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.service.AdminService;
import com.TrafficTicket.util.MD5Util;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

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
    public boolean addCarInfo(Car car) {
        car.setCarId(car.getCarId().toUpperCase());
        System.out.println(car.getCarId());
        if (!(car.getCarId().contains("I") || car.getCarId().contains("O"))) {
            if (adminService.addCarInfo(car) == 1) {
                System.out.println("录入成功");
                return true;
            } else {
                System.out.println("录入车辆信息失败");
            }
        } else {
            System.out.println("车牌号中不能出现I 和 O 的字符");
        }
        return false;
    }

    //车辆修改
    public boolean updateCarInfo(Car car) {
        if (adminService.updateCarInfo(car) == 1) {
            System.out.println("更新成功");
            return true;
        } else {
            System.out.println("更新失败");
        }
        return false;
    }

    //车辆删除(根据carId来进行删除)
    public boolean deleteCarInfo(String carId) {
        if (adminService.deleteCarInfo(carId) == 1) {
            System.out.println("删除成功");
            return true;
        } else {
            System.out.println("删除失败");
        }
        return false;
    }

    //车辆查询
    public List<Object> selectAllCarInfo() {

        return adminService.selectAllCarInfo();
    }

    //对交警信息的操作
    //交警录入
    public boolean addPolice(Police police) {
        if (adminService.addPolice(police) == 1) {
            System.out.println("录入成功");
            return true;
        } else {
            System.out.println("录入失败");
        }
        return false;
    }

    //交警修改
    public boolean updatePolice(Police police,Integer age) {
        if(age>=18){
            police.setLoginPwd(MD5Util.getMD5(police.getLoginPwd()));
            if (adminService.updatePolice(police) == 1) {
                System.out.println("更新成功");
                return true;
            } else {
                System.out.println("更新失败");
            }
        }else {
            JOptionPane.showMessageDialog(null, "年龄不能小于18岁", "修改失败", JOptionPane.WARNING_MESSAGE);
        }

        return false;
    }

    //交警删除
    public boolean deletePolice(String policeId) {
        if (adminService.deletePolice(policeId) == 1) {
            System.out.println("删除成功");
            return true;
        } else {
            System.out.println("删除失败");
        }
        return false;
    }

    //交警查询
    public List<Object> selectAllPolice() {
        return adminService.selectAllPolice();
    }

    //罚单查询
    public List<Object> selectTicketView() {
        return adminService.selectTicketView();
    }

    //管理员登录
    public boolean login(String loginAct, String loginPwd) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.toString();
            System.out.println(ip);
            loginPwd = MD5Util.getMD5(loginPwd);
            if (adminService.login(loginAct, loginPwd, ip) == 1) {
                System.out.println("登录成功");
                return true;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDriver(Driver driver, Integer age) {
        if (age >= 18) {
            driver.setLoginPwd(MD5Util.getMD5(driver.getLoginPwd()));
            System.out.println(driver.getLoginPwd());
            if (adminService.updateDriverInfo(driver) == 1) {
                return true;
            } else {
                System.out.println("更新失败");
            }
        } else {
            JOptionPane.showMessageDialog(null, "年龄不能小于18岁", "修改失败", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public Police findPoliceById(String inquireText) {
        return adminService.findPoliceById(inquireText);
    }

    public List<Object> selectAllDriver() {
        return adminService.selectAllDriver();
    }

    public boolean deleteDriver(Integer id) {
        if (adminService.deleteDriver(id) == 1) {
            System.out.println("删除成功");
            return true;
        } else {
            System.out.println("删除失败");
        }
        return false;
    }

    public Driver findDriverById(Integer driverId) {
        return adminService.findDriverById(driverId);
    }


    public List<Object> findTicketByCarId(String carId) {
        return adminService.findTicketByCarId(carId);
    }

    public Car findCarByCarId(String carId) {
        return adminService.findCarByCarId(carId);
    }

    public List<Object> selectOwnCarInfo(Integer driverId) {
        return adminService.selectOwnCarInfo(driverId);
    }
}
