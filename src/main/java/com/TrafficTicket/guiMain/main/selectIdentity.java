package com.TrafficTicket.guiMain.main;

import com.TrafficTicket.guiMain.Login.Admin.aLoginInterface;
import com.TrafficTicket.guiMain.Login.Driver.dLoginInterface;
import com.TrafficTicket.guiMain.Login.Police.pLoginInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectIdentity {
    public void init() {
        JFrame jf = new JFrame("登录");
        jf.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height,400,320);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //标题
        JLabel jLabel = new JLabel("交通罚单查询系统",JLabel.CENTER);
        jLabel.setFont(new Font("楷体",1,20));
        jf.add(jLabel);

        jf.setLayout(new GridLayout(4,1));

        JButton button1 = new JButton("交警登录");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
                new pLoginInterface().init();
            }
        });
        jf.add(button1);


        JButton button2 = new JButton("驾驶员登录");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
                new dLoginInterface().init();
            }
        });
        jf.add(button2);


        JButton button3 = new JButton("管理员登录");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
                new aLoginInterface().init();
            }
        });
        jf.add(button3);

        jf.setLocationRelativeTo(null);
        jf.setVisible(true);


        jf.setResizable(false);
        jf.setVisible(true);
    }
}
