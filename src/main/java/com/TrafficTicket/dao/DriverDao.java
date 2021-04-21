package com.TrafficTicket.dao;

import com.TrafficTicket.entity.DriverTicketView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverDao {
    List<DriverTicketView> selectTicketView();

    int findTicketByDriver(Integer driverId);

    int updateTicketFine(Integer driverId);

    int findTicketFine(Integer driverId);

    int login(@Param("loginAct") String loginAct,@Param("loginPwd") String loginPwd);
}
