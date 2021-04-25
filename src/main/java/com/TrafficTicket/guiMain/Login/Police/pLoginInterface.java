package com.TrafficTicket.guiMain.Login.Police;

import com.TrafficTicket.controller.PoliceController;
import com.TrafficTicket.entity.Ticket;
import com.TrafficTicket.guiMain.Login.Driver.dRegistrationInterface;
import com.TrafficTicket.guiMain.main.selectIdentity;
import com.TrafficTicket.guiMain.test.Example;
import com.TrafficTicket.util.UUIDUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public class pLoginInterface {
    public void init(){
        //窗口设置
        JFrame jf = new JFrame("交警登录");
        jf.setBounds(600,300,300,220);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c = jf.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        JPanel titlePanel1 = new JPanel();
        titlePanel1.setLayout(new FlowLayout());
        JPanel titlePanel2 = new JPanel();
        titlePanel2.setLayout(new FlowLayout());

        titlePanel1.add(new JLabel("交通罚单查询系统"));
        titlePanel2.add(new JLabel("交警登录"));
        titlePanel.add(titlePanel1,"North");
        titlePanel.add(titlePanel2,"South");
        c.add(titlePanel,"North");
        //输入账号密码部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);

        JLabel label1 = new JLabel("账号");
        JLabel label2 = new JLabel("密码");
        label1.setBounds(50,20,50,20);
        label2.setBounds(50,60,50,20);
        filedPanel.add(label1);
        filedPanel.add(label2);

        JTextField usename = new JTextField();
        JPasswordField password = new JPasswordField();
        usename.setBounds(110,20,120,20);
        password.setBounds(110,60,120,20);
        filedPanel.add(usename);
        filedPanel.add(password);
        c.add(filedPanel,"Center");
        //按钮设置
        JPanel buttonPanel = new JPanel();

        JButton button1 = new JButton("登录");
        buttonPanel.add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获取用户输入的数据
                String userNameText = usename.getText().trim();
                String passwordText = String.copyValueOf(password.getPassword());
                PoliceController policeController = new PoliceController();
                if(policeController.login(userNameText,passwordText)) {
                    new Example().init();
                    //接入主界面
                    jf.dispose();
                }
            }
        });

        JButton button2 = new JButton("注册");
        buttonPanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
                new pRegistrationInterface().init();
            }
        });

        JButton button3 = new JButton("返回");
        buttonPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
                new selectIdentity().init();
            }
        });
        c.add(buttonPanel,"South");

        jf.setResizable(false);
        jf.setVisible(true);
    }
}
