package com.TrafficTicket.dao;

import com.TrafficTicket.entity.AdminTicketView;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Police;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminDao {
    //对车辆信息表的操作
    int addCarInfo(Car car);
    int updateCarInfo(Car car);
    int deleteCarInfo(String carId);
    List<Car> selectAllCarInfo();
    int findDriverId(Integer driverId);
    int findCarId(String carId);

    //对交警信息表的操作
    int addPolice(Police police);
    int updatePolice(Police police);
    int deletePolice(String policeId);
    List<Police> selectAllPolice();
    int findPolice(String policeId);

    //查询罚单视图
    List<AdminTicketView> selectTicketView();
}
