package com.TrafficTicket.service.impl;

import com.TrafficTicket.dao.AdminDao;
import com.TrafficTicket.dao.PoliceDao;
import com.TrafficTicket.entity.Ticket;
import com.TrafficTicket.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceServiceImpl implements PoliceService {
    @Autowired
    private PoliceDao policeDao;
    @Autowired
    private AdminDao adminDao;
    @Override
    public int addTicket(Ticket ticket) {
        return policeDao.addTicket(ticket);
    }

    @Override
    public int updateTicket(Ticket ticket) {
        if (policeDao.findTicket(ticket.getTicketId())==1){
            if (adminDao.findCarId(ticket.getCarId())==1){
                if (adminDao.findDriverId(ticket.getDriverId())==1){
                    return policeDao.updateTicket(ticket);
                }else {
                    System.out.println("不存在此驾驶员");
                }
            } else {
                System.out.println("不存在此车牌号");
            }
        } else {
            System.out.println("不存在此罚单");
        }
        return 0;
    }

    @Override
    public int deleteTicket(String ticketId) {
        if (policeDao.findTicket(ticketId)==1){
            return policeDao.deleteTicket(ticketId);
        }else {
            return 0;
        }
    }

    @Override
    public List<Ticket> selectAllTicket() {
        return policeDao.selectAllTicket();
    }
}
