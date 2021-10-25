package com.TrafficTicket.service.impl;

import com.TrafficTicket.dao.AdminDao;
import com.TrafficTicket.dao.DriverDao;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.DriverTicketView;
import com.TrafficTicket.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverDao driverDao;
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<DriverTicketView> selectTicketView() {
        return driverDao.selectTicketView();
    }

    @Override
    public int updateTicketFine(String ticketId) {
            if (driverDao.findTicketFine(ticketId) == 1) {
                return driverDao.updateTicketFine(ticketId);
            } else {
                System.out.println("你已缴费");
                JOptionPane.showMessageDialog(null, "你已缴费", "失败", JOptionPane.WARNING_MESSAGE);

            }
        return 0;
    }

    @Override
    public Driver login(String loginAct, String loginPwd) {
        return driverDao.login(loginAct, loginPwd);
    }

    @Override
    public boolean register(Driver driver) {
        if (adminDao.findDriverId(driver.getDriverId()) == null) {
            if (adminDao.findDriverNum(driver.getDriverNum())==0) {
                if (adminDao.findDriverLoginAct(driver.getLoginAct())==0) {
                    JOptionPane.showMessageDialog(null, "注册成功", "注册成功", JOptionPane.WARNING_MESSAGE);
                    System.out.println("注册成功");
                    return driverDao.register(driver);
                }else {
                    JOptionPane.showMessageDialog(null, "账号已存在，请重新注册", "注册失败", JOptionPane.WARNING_MESSAGE);
                    System.out.println("账号存在");
                }
            } else {
                JOptionPane.showMessageDialog(null, "驾驶证号已存在，请重新注册", "注册失败", JOptionPane.WARNING_MESSAGE);
                System.out.println("驾驶证号存在");
            }
        } else {
            System.out.println("此驾驶员已存在");
            JOptionPane.showMessageDialog(null, "账号重复或身份证号重复，请重新注册", "注册失败", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    @Override
    public List<Object> selectOwnTicket(Integer driverId) {
        if (driverDao.selectOwnTicket(driverId)==null){
            System.out.println("没有信息");
        }else {
            return driverDao.selectOwnTicket(driverId);
        }
        return null;
    }
}
