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
    public int updateTicketFine(Integer driverId) {
        if (driverDao.findTicketByDriver(driverId) == 1) {
            if (driverDao.findTicketFine(driverId) == 1) {
                System.out.println("你的罚单已缴费");
                return 0;
            } else {
                return driverDao.updateTicketFine(driverId);
            }
        } else {
            System.out.println("你暂时还没有罚单，请继续努力");
        }
        return 0;
    }

    @Override
    public int login(String loginAct, String loginPwd) {
        return driverDao.login(loginAct, loginPwd);
    }

    @Override
    public boolean register(Driver driver) {
        if (adminDao.findDriverId(driver.getDriverId()) != null) {

            return driverDao.register(driver);
        } else {
            System.out.println("此驾驶员已存在");
            JOptionPane.showMessageDialog(null, "账号重复或身份证号重复，请重新注册", "注册失败", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
