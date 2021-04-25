package com.TrafficTicket.guiMain.Login.Driver;

import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.entity.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class dRegistrationInterface {
    public void init() {
        JFrame jf2 = new JFrame("账号注册");
        jf2.setBounds(600, 200, 350, 450);
        jf2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c = jf2.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("账号注册"));
        c.add(titlePanel,"North");
        //输入信息部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jUsename = new JLabel("账号");
        JLabel jName = new JLabel("姓名");
        JLabel jSex = new JLabel("性别");
        JLabel jIdNum = new JLabel("身份证号");
        JLabel jLicenseNum = new JLabel("驾驶证号");
        JLabel jAge = new JLabel("年龄");
        JLabel jPassword = new JLabel("密码");
        JLabel jPasswordAgain = new JLabel("再次输入密码");
        jUsename.setBounds(30,20,50,20);
        jName.setBounds(30,60,50,20);
        jSex.setBounds(30,100,50,20);
        jIdNum.setBounds(30,140,50,20);
        jLicenseNum.setBounds(30,180,80,20);
        jAge.setBounds(30,220,80,20);
        jPassword.setBounds(30,260,80,20);
        jPasswordAgain.setBounds(30,300,80,20);
        filedPanel.add(jUsename);
        filedPanel.add(jName);
        filedPanel.add(jSex);
        filedPanel.add(jIdNum);
        filedPanel.add(jLicenseNum);
        filedPanel.add(jAge);
        filedPanel.add(jPassword);
        filedPanel.add(jPasswordAgain);


        JTextField usename = new JTextField();
        JTextField name = new JTextField();
        JPanel JCom = new JPanel();
        JComboBox<String> sex = new JComboBox<String>();
        sex.addItem("男");
        sex.addItem("女");
        sex.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    //这里写你的任务 ，比如取到现在的值
                    String sexText =(String) sex.getSelectedItem();
                }
            }
        });
        JTextField idNum = new JTextField();
        JTextField licenseNum = new JTextField();
        JTextField age = new JTextField();
        JTextField password = new JTextField();
        JTextField passwordAgain = new JTextField();

        usename.setBounds(110,20,140,20);
        name.setBounds(110,60,140,20);
        sex.setBounds(110,100,140,20);
        idNum.setBounds(110,140,140,20);
        licenseNum.setBounds(110,180,140,20);
        age.setBounds(110,220,140,20);
        password.setBounds(110,260,140,20);
        passwordAgain.setBounds(110,300,140,20);
        filedPanel.add(usename);
        filedPanel.add(name);
        filedPanel.add(sex);
        filedPanel.add(idNum);
        filedPanel.add(licenseNum);
        filedPanel.add(age);
        filedPanel.add(password);
        filedPanel.add(passwordAgain);
        c.add(filedPanel,"Center");
        //按钮设置
        JPanel buttonPanel = new JPanel();

        JButton button1 = new JButton("注册");
        buttonPanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                DriverController driverController = new DriverController();

                String usenameText = usename.getText().trim();
                String nameText = name.getText().trim();
                String idNumText = idNum.getText().trim();
                String licenseNumText = licenseNum.getText().trim();
                String ageText = age.getText().trim();
                String passwordText = password.getText().trim();

                Driver driver = new Driver(Integer.parseInt(idNumText),nameText,sexText,Integer.parseInt(ageText),Integer.valueOf(licenseNumText),usenameText,passwordText);

                if(driverController.register(driver)){
                    new dLoginInterface().init();
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
                new dLoginInterface().init();
            }
        });

        c.add(buttonPanel,"South");
        jf2.setResizable(false);
        jf2.setVisible(true);
    }
}
