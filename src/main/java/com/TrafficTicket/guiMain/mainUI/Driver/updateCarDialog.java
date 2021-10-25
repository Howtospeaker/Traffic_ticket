package com.TrafficTicket.guiMain.mainUI.Driver;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.entity.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class updateCarDialog {
    private JTextField CarId;
    private JLabel DriverId;
    private JTextField LicenseNum;


    public void init(String CARID, String DRIVERID, String LICENSENUM) {
        JFrame jf2 = new JFrame("修改车辆信息");
        jf2.setBounds(600, 300, 350, 250);
        jf2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Container c = jf2.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("修 改 车 辆 信 息"));
        c.add(titlePanel, "North");
        //输入信息左边部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jCarId = new JLabel("车牌号");
        JLabel jDriverId = new JLabel("身份证号");
        JLabel jLicenseNum = new JLabel("行驶证号");

        jCarId.setBounds(30, 20, 50, 20);
        jDriverId.setBounds(30, 60, 50, 20);
        jLicenseNum.setBounds(30, 100, 50, 20);

        //左边标签添加
        filedPanel.add(jCarId);
        filedPanel.add(jDriverId);
        filedPanel.add(jLicenseNum);


        //输入信息部分
        CarId = new JTextField(CARID);
        DriverId = new JLabel(DRIVERID);
        LicenseNum = new JTextField(LICENSENUM);
        //输入信息部分
        CarId.setBounds(110, 20, 140, 20);
        DriverId.setBounds(110, 60, 140, 20);
        LicenseNum.setBounds(110, 100, 140, 20);

        //文本框添加
        filedPanel.add(CarId);
        filedPanel.add(DriverId);
        filedPanel.add(LicenseNum);


        c.add(filedPanel, "Center");
        //按钮设置
        JPanel buttonPanel = new JPanel();
        //修改时间
        JButton button1 = new JButton("修改");
        buttonPanel.add(button1);
        //修改行为
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AdminController adminController = new AdminController();
                String carIdText = CarId.getText().trim();
                Integer driverIdText = Integer.valueOf(DriverId.getText().trim());
                Integer licenseNumText = Integer.valueOf(LicenseNum.getText().trim());

                Car car = new Car(carIdText,driverIdText,licenseNumText);
                if (adminController.updateCarInfo(car)) {
                    jf2.dispose();
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


