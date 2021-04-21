package com.TrafficTicket.service;

import com.TrafficTicket.entity.Ticket;

import java.util.List;

public interface PoliceService {
    int addTicket(Ticket ticket);

    int updateTicket(Ticket ticket);

    int deleteTicket(String ticketId);

    List<Ticket> selectAllTicket();

    int login(String loginAct, String loginPwd);
}
