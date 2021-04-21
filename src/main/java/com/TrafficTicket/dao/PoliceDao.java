package com.TrafficTicket.dao;

import com.TrafficTicket.entity.Ticket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PoliceDao {
    int addTicket(Ticket ticket);

    int findTicket(String ticketId);

    int updateTicket(Ticket ticket);

    int deleteTicket(String ticketId);

    List<Ticket> selectAllTicket();

    int login(@Param("loginAct") String loginAct,@Param("loginPwd") String loginPwd);
}
