package com.TrafficTicket.guiMain.mainUI.Admin.adminDriverDialog;

import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.entity.Driver;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addAdminDriverDialog {
    public void init() {
        JFrame jf2 = new JFrame("增加新驾驶员");
        jf2.setBounds(600, 200, 350, 450);
        jf2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Container c = jf2.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("添加新驾驶员"));
        c.add(titlePanel, "North");
        //输入信息左边部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jUsename = new JLabel("账号");
        JLabel jName = new JLabel("姓名");
        JLabel jSex = new JLabel("性别");
        JLabel jIdNum = new JLabel("身份证号");
        JLabel jDriverNum = new JLabel("驾驶证号");
        JLabel jLicenseNum = new JLabel("行驶证号");
        JLabel jAge = new JLabel("年龄");
        JLabel jPassword = new JLabel("初始密码");
        jUsename.setBounds(30, 20, 50, 20);
        jName.setBounds(30, 60, 50, 20);
        jSex.setBounds(30, 100, 50, 20);
        jIdNum.setBounds(30, 140, 50, 20);
        jDriverNum.setBounds(30, 180, 80, 20);
        jLicenseNum.setBounds(30, 220, 80, 20);
        jAge.setBounds(30, 260, 80, 20);
        jPassword.setBounds(30, 300, 80, 20);
        //左边标签添加
        filedPanel.add(jUsename);
        filedPanel.add(jName);
        filedPanel.add(jSex);
        filedPanel.add(jIdNum);
        filedPanel.add(jDriverNum);
        filedPanel.add(jLicenseNum);
        filedPanel.add(jAge);
        filedPanel.add(jPassword);

        //输入信息部分
        JTextField usename = new JTextField();
        JTextField name = new JTextField();
        //选择男女性别
        JRadioButton male = new JRadioButton("男", true);
        JRadioButton female = new JRadioButton("女", false);
        //实现单选效果
        ButtonGroup sex = new ButtonGroup();
        sex.add(male);
        sex.add(female);
        //输入信息部分
        JTextField idNum = new JTextField();
        JTextField driverNum = new JTextField();
        JTextField licenseNum = new JTextField();
        JTextField age = new JTextField();
        JTextField password = new JTextField("123456");
        usename.setBounds(110, 20, 140, 20);
        name.setBounds(110, 60, 140, 20);
        male.setBounds(110, 100, 50, 20);
        female.setBounds(165, 100, 140, 20);
        idNum.setBounds(110, 140, 140, 20);
        driverNum.setBounds(110, 180, 140, 20);
        licenseNum.setBounds(110, 220, 140, 20);
        age.setBounds(110, 260, 140, 20);
        password.setBounds(110, 300, 140, 20);
        //文本框添加
        filedPanel.add(usename);
        filedPanel.add(name);
        filedPanel.add(male);
        filedPanel.add(female);
        filedPanel.add(idNum);
        filedPanel.add(driverNum);
        filedPanel.add(licenseNum);
        filedPanel.add(age);
        filedPanel.add(password);

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

                String usenameText = usename.getText().trim();
                String nameText = name.getText().trim();
                String sexText = sex.isSelected(male.getModel()) ? male.getText() : female.getText();
                String idNumText = idNum.getText().trim();
                String driverNumText = driverNum.getText().trim();
                String ageText = age.getText().trim();
                String passwordText = password.getText().trim();

                Driver driver = new Driver(Integer.parseInt(idNumText), nameText, sexText, Integer.parseInt(ageText), Integer.valueOf(driverNumText), usenameText, passwordText);

                if (driverController.register(driver)) {
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
