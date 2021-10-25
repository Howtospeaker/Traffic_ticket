package com.TrafficTicket.service;

import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.DriverTicketView;

import java.util.List;

public interface DriverService {
    List<DriverTicketView> selectTicketView();

    int updateTicketFine(String ticketId);

    Driver login(String loginAct, String loginPwd);

    boolean register(Driver driver);

    List<Object> selectOwnTicket(Integer driverId);
}
