package com.TrafficTicket.service;

import com.TrafficTicket.entity.AdminTicketView;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Police;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    int addCarInfo(Car car);

    int updateCarInfo(Car car);

    int deleteCarInfo(String carId);

    List<Car> selectAllCarInfo();

    int addPolice(Police police);

    int updatePolice(Police police);

    int deletePolice(String policeId);

    List<Police> selectAllPolice();

    List<AdminTicketView> selectTicketView();
}
