package com.TrafficTicket.dao;

import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.DriverTicketView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverDao {
    List<DriverTicketView> selectTicketView();

    int findTicketByTicketId(String ticketId);

    int updateTicketFine(String ticketId);

    int findTicketFine(String ticketId);

    Driver login(@Param("loginAct") String loginAct,@Param("loginPwd") String loginPwd);

    boolean register(Driver driver);

    List<Object> selectOwnTicket(Integer driverId);
}
