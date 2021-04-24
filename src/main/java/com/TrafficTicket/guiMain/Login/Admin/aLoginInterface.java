package com.TrafficTicket.guiMain.Login.Admin;

import com.TrafficTicket.guiMain.main.selectIdentity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aLoginInterface {
    public void init(){
        //窗口设置
        JFrame jf = new JFrame("管理员登录");
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
        titlePanel2.add(new JLabel("管理员登录"));
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
                if(true) {
                    //接入主界面
                    jf.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "账号或密码输入错误，请检查！", "登录失败",JOptionPane.WARNING_MESSAGE);
                }
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