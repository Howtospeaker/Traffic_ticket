package com.TrafficTicket.service.impl;

import com.TrafficTicket.dao.AdminDao;
import com.TrafficTicket.entity.AdminTicketView;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public int addCarInfo(Car car) {
        //先判断是否存在此车主
        int flag = adminDao.findDriverId(car.getDriverId());
        if (flag == 1){
            return adminDao.addCarInfo(car);
        } else {
            System.out.println("找不到"+car.getDriverId()+"编号的车主");
        }
        return 0;
    }

    @Override
    public int updateCarInfo(Car car) {
        //先查找是否存在此车牌号
        if (adminDao.findCarId(car.getCarId()) == 1){
            //先判断需要换的新车主是否存在
            if (adminDao.findDriverId(car.getDriverId())==0){
                System.out.println("找不到"+car.getDriverId()+"编号的车主");
            } else{
                System.out.println("找不到"+car.getDriverId()+"编号的车主");
            }
        } else {
            System.out.println("找不到"+car.getCarId()+"车牌号的车");
        }
        return adminDao.updateCarInfo(car);
    }

    @Override
    public int deleteCarInfo(String carId) {
        //先查找是否存在此车牌号
        if (adminDao.findCarId(carId) == 1){
        } else {
            System.out.println("找不到"+carId+"车牌号的车");
        }
        return adminDao.deleteCarInfo(carId);
    }

    @Override
    public List<Car> selectAllCarInfo() {
        return adminDao.selectAllCarInfo();
    }

    @Override
    public int addPolice(Police police) {
        return adminDao.addPolice(police);
    }

    @Override
    public int updatePolice(Police police) {
        //先判断是否存在此交警
        int flag = adminDao.findPolice(police.getPoliceId());
        if (flag == 1){
            return adminDao.updatePolice(police);
        } else {
            System.out.println("找不到"+police.getPoliceId()+"编号的交警");
        }
        return 0;
    }

    @Override
    public int deletePolice(String policeId) {
        //先判断是否存在此交警
        int flag = adminDao.findPolice(policeId);
        if (flag == 1){
            return adminDao.deletePolice(policeId);
        } else {
            System.out.println("找不到"+policeId+"编号的交警");
        }
        return 0;
    }

    @Override
    public List<Police> selectAllPolice() {
        return adminDao.selectAllPolice();
    }

    @Override
    public List<AdminTicketView> selectTicketView() {
        return adminDao.selectTicketView();
    }

}
