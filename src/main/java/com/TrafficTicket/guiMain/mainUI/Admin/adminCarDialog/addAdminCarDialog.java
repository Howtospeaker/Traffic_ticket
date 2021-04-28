package com.TrafficTicket.guiMain.mainUI.Admin.adminCarDialog;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addAdminCarDialog {
    public void init() {
        JFrame jf2 = new JFrame("增加新驾车辆信息");
        jf2.setBounds(600, 300, 350, 250);
        jf2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Container c = jf2.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("添 加 新 车 辆"));
        c.add(titlePanel, "North");
        //输入信息左边部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jCarId = new JLabel("车牌号");
        JLabel jDriverId = new JLabel("驾驶证号");
        JLabel jLicenseNum = new JLabel("行驶证号");

        jCarId.setBounds(30, 20, 50, 20);
        jDriverId.setBounds(30, 60, 50, 20);
        jLicenseNum.setBounds(30, 100, 50, 20);

        //左边标签添加
        filedPanel.add(jCarId);
        filedPanel.add(jDriverId);
        filedPanel.add(jLicenseNum);
        //输入信息部分
        JTextField CarId = new JTextField();
        JTextField DriverId = new JTextField();
        JTextField LicenseNum = new JTextField();

        CarId.setBounds(110, 20, 140, 20);
        DriverId.setBounds(110, 60, 140, 20);
        LicenseNum.setBounds(165, 100, 140, 20);

        //文本框添加
        filedPanel.add(CarId);
        filedPanel.add(DriverId);
        filedPanel.add(LicenseNum);

        c.add(filedPanel, "Center");
        //按钮设置
        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("添加");
        buttonPanel.add(button1);
        //添加行为
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                DriverController driverController = new DriverController();

                String CarIdText = CarId.getText().trim();
                String DriverIdText = DriverId.getText().trim();
                String LicenseNumText = LicenseNum.getText().trim();

                Car car = new Car(CarIdText, Integer.parseInt(DriverIdText), Integer.parseInt(LicenseNumText));
                if (new AdminController().addCarInfo(car)) {
                    JOptionPane.showMessageDialog(null, "添加成功", "添加失败", JOptionPane.WARNING_MESSAGE);
                    jf2.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "添加失败", "添加失败", JOptionPane.WARNING_MESSAGE);
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
