package com.TrafficTicket.service.impl;

import com.TrafficTicket.dao.AdminDao;
import com.TrafficTicket.entity.*;
import com.TrafficTicket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public int addCarInfo(Car car) {
        //先判断是否存在此驾驶员
        if (adminDao.findDriverId(car.getDriverId()) != null) {
            return adminDao.addCarInfo(car);
        } else {
            System.out.println("此驾驶员不存在");
        }
        return 0;
    }

    @Override
    public int updateCarInfo(Car car) {
        //先查找是否存在此车牌号
        if (adminDao.findCarId(car.getCarId()) != null) {
            //先判断需要换的新车主是否存在
            if (adminDao.findDriverId(car.getDriverId()) != null) {
                return adminDao.updateCarInfo(car);
            } else {
                System.out.println("找不到" + car.getDriverId() + "编号的车主");
            }
        } else {
            System.out.println("找不到" + car.getCarId() + "车牌号的车");
        }
        return 0;
    }

    @Override
    public int deleteCarInfo(String carId) {
        //先查找是否存在此车牌号
        if (adminDao.findCarId(carId) != null) {
            System.out.println("删除成功");
            return adminDao.deleteCarInfo(carId);
        } else {
            System.out.println("找不到" + carId + "车牌号的车");
        }
        return 0;
    }

    @Override
    public List<Object> selectAllCarInfo() {
        return adminDao.selectAllCarInfo();
    }

    @Override
    public int addPolice(Police police) {
        if (adminDao.findPolice(police.getPoliceId()) == 1) {
            System.out.println("此交警已存在");
            return 0;
        }
        return adminDao.addPolice(police);
    }

    @Override
    public int updatePolice(Police police) {
        //先判断是否存在此交警
        int flag = adminDao.findPolice(police.getPoliceId());
        if (flag == 1) {
            return adminDao.updatePolice(police);
        } else {
            System.out.println("找不到" + police.getPoliceId() + "编号的交警");
        }
        return 0;
    }

    @Override
    public int deletePolice(String policeId) {
        //先判断是否存在此交警
        int flag = adminDao.findPolice(policeId);
        if (flag == 1) {
            return adminDao.deletePolice(policeId);
        } else {
            System.out.println("找不到" + policeId + "编号的交警");
        }
        return 0;
    }

    @Override
    public List<Object> selectAllPolice() {
        return adminDao.selectAllPolice();
    }

    @Override
    public List<Object> selectTicketView() {
        return adminDao.selectTicketView();
    }

    @Override
    public int login(String loginAct, String loginPwd, String ip) {
        if (adminDao.findAdminIp(ip) == 1) {
            if (adminDao.login(loginAct, loginPwd) == 1) {
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "账号或密码输入错误，请检查！", "登录失败", JOptionPane.WARNING_MESSAGE);
                System.out.println("账号密码错误");
            }
        } else {
            JOptionPane.showMessageDialog(null, "请在允许的ip地址下登录！", "登录失败", JOptionPane.WARNING_MESSAGE);
            System.out.println("请在允许的ip地址下登录！");
        }
        return 0;
    }

    @Override
    public int updateDriverInfo(Driver driver) {
        if (adminDao.findDriverId(driver.getDriverId()) != null) {
            if (adminDao.updateDriver(driver) == 1) {
                System.out.println("更新成功");
                return 1;
            }
        } else {
            System.out.println("此驾驶员的身份证号不存在");
        }
        return 0;
    }

    @Override
    public Police findPoliceById(String inquireText) {
        return adminDao.findPoliceById(inquireText);
    }

    @Override
    public List<Object> selectAllDriver() {
        return adminDao.selectAllDriver();
    }

    @Override
    public int deleteDriver(Integer id) {
        return adminDao.deleteDriver(id);
    }

    @Override
    public Driver findDriverById(Integer driverId) {
        return adminDao.findDriverId(driverId);
    }

    @Override
    public List<Object> findTicketByCarId(String carId) {
        return adminDao.findTicketByCarId(carId);
    }

    @Override
    public Car findCarByCarId(String carId) {
        return adminDao.findCarId(carId);
    }

    @Override
    public List<Object> selectOwnCarInfo(Integer driverId) {
        if (adminDao.selectOwnCarInfo(driverId)==null){
            System.out.println("没有信息");
        }else {
            return adminDao.selectOwnCarInfo(driverId);
        }
        return null;
    }
}
