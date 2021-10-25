package com.TrafficTicket.guiMain.Login.Police;

import com.TrafficTicket.controller.PoliceController;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.guiMain.Login.Driver.dLoginInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pRegistrationInterface {
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
        c.add(titlePanel, "North");
        //输入信息部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jUsename = new JLabel("账号");
        JLabel jName = new JLabel("姓名");
        JLabel jSex = new JLabel("性别");
        JLabel jIdNum = new JLabel("警察编号");
        JLabel jAge = new JLabel("年龄");
        JLabel jpoliceStation = new JLabel("所属分局");
        JLabel jPassword = new JLabel("密码");
        JLabel jPasswordAgain = new JLabel("再次输入密码");
        jUsename.setBounds(30, 20, 50, 20);
        jName.setBounds(30, 60, 50, 20);
        jSex.setBounds(30, 100, 50, 20);
        jIdNum.setBounds(30, 140, 50, 20);
        jAge.setBounds(30, 180, 80, 20);
        jpoliceStation.setBounds(30, 220, 80, 20);
        jPassword.setBounds(30, 260, 80, 20);
        jPasswordAgain.setBounds(30, 300, 80, 20);
        filedPanel.add(jUsename);
        filedPanel.add(jName);
        filedPanel.add(jSex);
        filedPanel.add(jIdNum);
        filedPanel.add(jAge);
        filedPanel.add(jpoliceStation);
        filedPanel.add(jPassword);
        filedPanel.add(jPasswordAgain);


        JTextField usename = new JTextField();
        JTextField name = new JTextField();

        JRadioButton male = new JRadioButton("男", true);
        JRadioButton female = new JRadioButton("女", false);
        //实现单选效果
        ButtonGroup sex = new ButtonGroup();
        sex.add(male);
        sex.add(female);

        JTextField idNum = new JTextField();
        JTextField age = new JTextField();
        JTextField policeStation = new JTextField();
        JTextField password = new JTextField();
        JTextField passwordAgain = new JTextField();

        usename.setBounds(110, 20, 140, 20);
        name.setBounds(110, 60, 140, 20);
        male.setBounds(110, 100, 50, 20);
        female.setBounds(165, 100, 140, 20);
        idNum.setBounds(110, 140, 140, 20);
        age.setBounds(110, 180, 140, 20);
        policeStation.setBounds(110, 220, 140, 20);
        password.setBounds(110, 260, 140, 20);
        passwordAgain.setBounds(110, 300, 140, 20);
        filedPanel.add(usename);
        filedPanel.add(name);
        filedPanel.add(male);
        filedPanel.add(female);
        filedPanel.add(idNum);
        filedPanel.add(age);
        filedPanel.add(policeStation);
        filedPanel.add(password);
        filedPanel.add(passwordAgain);
        c.add(filedPanel, "Center");
        //按钮设置
        JPanel buttonPanel = new JPanel();

        JButton button1 = new JButton("注册");
        buttonPanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                PoliceController policeController = new PoliceController();

                String usenameText = usename.getText().trim();
                String nameText = name.getText().trim();
                String sexText = sex.isSelected(male.getModel()) ? male.getText() : female.getText();
                String idNumText = idNum.getText().trim();
                String ageText = age.getText().trim();
                String policeStationText = policeStation.getText().trim();
                String passwordText = password.getText().trim();
                String passwordAgainText = passwordAgain.getText().trim();
                if(passwordText.equals(passwordAgainText)){
                    Police police = new Police(idNumText, nameText, sexText, Integer.valueOf(ageText), policeStationText, usenameText, passwordText);
                    if (policeController.register(police,Integer.valueOf(ageText))) {
                        new pLoginInterface().init();
                        jf2.dispose();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "两次输入的密码不相同", "注册失败", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton button2 = new JButton("取消");
        buttonPanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf2.dispose();
                new pLoginInterface().init();
            }
        });

        c.add(buttonPanel, "South");
        jf2.setResizable(false);
        jf2.setVisible(true);
    }
}
