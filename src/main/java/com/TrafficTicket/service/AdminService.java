package com.TrafficTicket.service;

import com.TrafficTicket.entity.*;

import java.util.List;

public interface AdminService {
    int addCarInfo(Car car);

    int updateCarInfo(Car car);

    int deleteCarInfo(String carId);

    List<Object> selectAllCarInfo();

    int addPolice(Police police);

    int updatePolice(Police police);

    int deletePolice(String policeId);

    List<Object> selectAllPolice();

    List<Object> selectTicketView();

    int login(String loginAct, String loginPwd, String ip);

    int updateDriverInfo(Driver driver);

    Police findPoliceById(String inquireText);

    List<Object> selectAllDriver();

    int deleteDriver(Integer id);

    Driver findDriverById(Integer driverId);

    List<Object> findTicketByCarId(String carId);

    Car findCarByCarId(String carId);

    List<Object> selectOwnCarInfo(Integer driverId);
}
