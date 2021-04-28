package com.TrafficTicket.service.impl;

import com.TrafficTicket.dao.AdminDao;
import com.TrafficTicket.dao.PoliceDao;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.entity.Ticket;
import com.TrafficTicket.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class PoliceServiceImpl implements PoliceService {
    @Autowired
    private PoliceDao policeDao;
    @Autowired
    private AdminDao adminDao;

    @Override
    public int addTicket(Ticket ticket) {
        if (policeDao.findTicket(ticket.getTicketId())==1){
            if (adminDao.findCarId(ticket.getCarId())==1){
                if (adminDao.findDriverId(ticket.getDriverId())!= null){
                    return policeDao.addTicket(ticket);
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
    public int updateTicket(Ticket ticket) {
        if (policeDao.findTicket(ticket.getTicketId()) == 1) {
            if (adminDao.findCarId(ticket.getCarId()) == 1) {
                if (adminDao.findDriverId(ticket.getDriverId()) != null) {
                    return policeDao.updateTicket(ticket);
                } else {
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
        if (policeDao.findTicket(ticketId) == 1) {
            return policeDao.deleteTicket(ticketId);
        } else {
            return 0;
        }
    }

    @Override
    public List<Ticket> selectAllTicket() {
        return policeDao.selectAllTicket();
    }

    @Override
    public int login(String loginAct, String loginPwd) {
        return policeDao.login(loginAct, loginPwd);
    }

    @Override
    public boolean register(Police police) {
        if (adminDao.findPolice(police.getPoliceId()) == 0) {
            if (adminDao.addPolice(police) == 1)
                return true;
        } else {
            System.out.println("此交警已存在");
            JOptionPane.showMessageDialog(null, "账号重复或交警编号重复，请重新注册", "注册失败", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
