package com.TrafficTicket.service;

import com.TrafficTicket.entity.DriverTicketView;

import java.util.List;

public interface DriverService {
    List<DriverTicketView> selectTicketView();

    int updateTicketFine(Integer driverId);

    int login(String loginAct, String loginPwd);
}
