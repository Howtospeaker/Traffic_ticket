package com.TrafficTicket.guiMain.mainUI.Police;

import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.controller.PoliceController;
import com.TrafficTicket.entity.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class updateTicketDialog {
    private JLabel ticketId;
    private JTextField driverId;
    private JTextField carId;
    private JLabel policeId;
    private JTextField vioTime;
    private JTextField VioAddress;
    private JTextField fine;
    private JLabel payStatus;

    public void init(String TICKETID, Integer DRIVERID, String CARID, String POLICEID, String VIOTIME, String VIOADDRESS, Integer FINE, Integer PAYSTATUS) {
        JFrame jf2 = new JFrame("缴费窗口");
        jf2.setBounds(600, 200, 350, 450);
        jf2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Container c = jf2.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("缴        费"));
        c.add(titlePanel, "North");
        //输入信息左边部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jticketId = new JLabel("罚单编号");
        JLabel jdriverId = new JLabel("身份证号");
        JLabel jcarId = new JLabel("车牌号");
        JLabel jpoliceId = new JLabel("交警编号");
        JLabel jvioTime = new JLabel("违章时间");
        JLabel jVioAddress = new JLabel("违章地点");
        JLabel jfine = new JLabel("罚款金额");
        JLabel jpayStatus = new JLabel("缴费状态");
        jticketId.setBounds(30, 20, 50, 20);
        jdriverId.setBounds(30, 60, 50, 20);
        jcarId.setBounds(30, 100, 50, 20);
        jpoliceId.setBounds(30, 140, 50, 20);
        jvioTime.setBounds(30, 180, 80, 20);
        jVioAddress.setBounds(30, 220, 80, 20);
        jfine.setBounds(30, 260, 80, 20);
        jpayStatus.setBounds(30, 300, 80, 20);
        //左边标签添加
        filedPanel.add(jticketId);
        filedPanel.add(jdriverId);
        filedPanel.add(jcarId);
        filedPanel.add(jpoliceId);
        filedPanel.add(jvioTime);
        filedPanel.add(jVioAddress);
        filedPanel.add(jfine);
        filedPanel.add(jpayStatus);


        //输入信息部分
        ticketId = new JLabel(TICKETID);
        driverId = new JTextField(String.valueOf(DRIVERID));
        carId = new JTextField(CARID);
        policeId = new JLabel(POLICEID);
        vioTime = new JTextField(VIOTIME);
        VioAddress = new JTextField(VIOADDRESS);
        fine = new JTextField(String.valueOf(FINE));
        payStatus = new JLabel(String.valueOf(PAYSTATUS));
        //输入信息部分
        ticketId.setBounds(110, 20, 170, 20);
        driverId.setBounds(110, 60, 140, 20);
        carId.setBounds(110, 100, 140, 20);
        policeId.setBounds(110, 140, 140, 20);
        vioTime.setBounds(110, 180, 140, 20);
        VioAddress.setBounds(110, 220, 140, 20);
        fine.setBounds(110, 260, 140, 20);
        payStatus.setBounds(110, 300, 140, 20);
        //文本框添加
        filedPanel.add(ticketId);
        filedPanel.add(driverId);
        filedPanel.add(carId);
        filedPanel.add(policeId);
        filedPanel.add(vioTime);
        filedPanel.add(VioAddress);
        filedPanel.add(fine);
        filedPanel.add(payStatus);

        c.add(filedPanel, "Center");
        //按钮设置
        JPanel buttonPanel = new JPanel();
        //修改事件
        JButton button1 = new JButton("修改");
        buttonPanel.add(button1);
        //修改行为
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int result = JOptionPane.showConfirmDialog(jf2, "是否修改罚单信息", "修改罚单", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    PoliceController policeController = new PoliceController();

                    Ticket ticket = new Ticket(ticketId.getText().trim(),Integer.valueOf(driverId.getText().trim()),
                            carId.getText().trim(),policeId.getText().trim(),vioTime.getText().trim(),VioAddress.getText().trim(),
                            Integer.valueOf(fine.getText().trim()),Integer.valueOf(payStatus.getText().trim()));

                    if (policeController.updateTicket(ticket)) {
                        jf2.dispose();
                    }
                }
                if (result == JOptionPane.CANCEL_OPTION) {

                }
            }
        });

        JButton button2 = new JButton("取消");
        buttonPanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf2.dispose();
            }
        });
        c.add(buttonPanel, "South");


        jf2.setResizable(false);
        jf2.setVisible(true);
    }
}


