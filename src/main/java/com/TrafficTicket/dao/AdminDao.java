package com.TrafficTicket.dao;

import com.TrafficTicket.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    //对车辆信息表的操作
    int addCarInfo(Car car);
    int updateCarInfo(Car car);
    int deleteCarInfo(String carId);
    List<Object> selectAllCarInfo();
    Driver findDriverId(Integer driverId);
    Car findCarId(String carId);

    //对交警信息表的操作
    int addPolice(Police police);
    int updatePolice(Police police);
    int deletePolice(String policeId);
    List<Object> selectAllPolice();
    int findPolice(String policeId);

    //查询罚单视图
    List<Object> selectTicketView();

    //管理员登陆操作
    int findAdminIp(String allowsIp);
    int login(@Param("loginAct") String loginAct,@Param("loginPwd") String loginPwd);

    int updateDriver(Driver driver);

    Car findCarInfo(Integer driverId);

    Police findPoliceById(String inquireText);

    List<Object> selectAllDriver();

    int deleteDriver(@Param("driverId") Integer id);

    List<Object> findTicketByCarId(String carId);

    int findDriverNum(Integer driverNum);

    int findDriverLoginAct(String loginAct);

    List<Object> selectOwnCarInfo(Integer driverId);
}
