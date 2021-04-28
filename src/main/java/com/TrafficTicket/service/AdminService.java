package com.TrafficTicket.service;

import com.TrafficTicket.entity.AdminTicketView;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.Police;

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

    List<AdminTicketView> selectTicketView();

    int login(String loginAct, String loginPwd, String ip);

    int updateDriverInfo(Driver driver);

    Police findPoliceById(String inquireText);

    List<Object> selectAllDriver();

    int deleteDriver(Integer id);

    Driver findDriverById(Integer driverId);
}
