package com.TrafficTicket.guiMain.Login.Police;

import com.TrafficTicket.guiMain.Login.Driver.dLoginInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pRegistrationInterface {
    public void init() {
        JFrame jf2 = new JFrame("账号注册");
        jf2.setBounds(450, 200, 350, 550);
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
        JLabel label1 = new JLabel("账号");
        JLabel label2 = new JLabel("姓名");
        JLabel label3 = new JLabel("性别");
        JLabel label4 = new JLabel("密码");
        JLabel label5 = new JLabel("再次输入密码");
        JLabel label6 = new JLabel("身份证号");
        JLabel label7 = new JLabel("年龄");
        label1.setBounds(30,20,50,20);
        label2.setBounds(30,60,50,20);
        label3.setBounds(30,100,50,20);
        label4.setBounds(30,140,50,20);
        label5.setBounds(30,180,80,20);
        label6.setBounds(30,220,80,20);
        label7.setBounds(30,260,80,20);
        filedPanel.add(label1);
        filedPanel.add(label2);
        filedPanel.add(label6);
        filedPanel.add(label3);
        filedPanel.add(label7);
        filedPanel.add(label4);
        filedPanel.add(label5);

        JTextField usename = new JTextField();
        JTextField name = new JTextField();
        JTextField sex = new JTextField();
        JTextField password = new JTextField();
        JTextField passwordAgain = new JTextField();
        JTextField idNum = new JTextField();
        JTextField age = new JTextField();
        usename.setBounds(110,20,140,20);
        sex.setBounds(110,60,140,20);
        name.setBounds(110,100,140,20);
        password.setBounds(110,140,140,20);
        passwordAgain.setBounds(110,180,140,20);
        idNum.setBounds(110,220,140,20);
        age.setBounds(110,260,140,20);
        filedPanel.add(usename);
        filedPanel.add(name);
        filedPanel.add(idNum);
        filedPanel.add(sex);
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
                if(true){
//                    jf2.dispose();
                    JOptionPane.showMessageDialog(null, "账号重复或身份证号重复，请重新注册", "注册失败",JOptionPane.WARNING_MESSAGE);
                } else {
                    //JOptionPane.showMessageDialog(null, "账号重复或身份证号重复，请重新注册", "注册失败",JOptionPane.WARNING_MESSAGE);
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
