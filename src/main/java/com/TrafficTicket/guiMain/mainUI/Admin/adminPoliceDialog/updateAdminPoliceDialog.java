package com.TrafficTicket.guiMain.mainUI.Admin.adminPoliceDialog;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.entity.Police;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateAdminPoliceDialog {
    private JTextField idNum;
    private JTextField name;
    private JTextField age;
    private JTextField policeStation;
    private JTextField password;
    private JLabel usename;
    private JRadioButton male;
    private JRadioButton female;


    public void init(String ID, String NAME, String SEX, String AGE, String POLICESTATION, String USERNAME, String PASSWORD) {
        //创建窗口
        JFrame jf2 = new JFrame("修改交警信息");
        jf2.setBounds(600, 200, 350, 450);
        jf2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Container c = jf2.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("修改交警信息"));
        c.add(titlePanel, "North");
        //输入信息左边部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jUsename = new JLabel("账号");
        JLabel jName = new JLabel("姓名");
        JLabel jSex = new JLabel("性别");
        JLabel jIdNum = new JLabel("警察编号");
        JLabel jAge = new JLabel("年龄");
        JLabel jpoliceStation = new JLabel("所属分局");
        JLabel jPassword = new JLabel("修改密码");
        jUsename.setBounds(30, 20, 50, 20);
        jName.setBounds(30, 60, 50, 20);
        jSex.setBounds(30, 100, 50, 20);
        jIdNum.setBounds(30, 140, 50, 20);
        jAge.setBounds(30, 180, 80, 20);
        jpoliceStation.setBounds(30, 220, 80, 20);
        jPassword.setBounds(30, 260, 80, 20);
        //添加标签
        filedPanel.add(jUsename);
        filedPanel.add(jName);
        filedPanel.add(jSex);
        filedPanel.add(jIdNum);
        filedPanel.add(jAge);
        filedPanel.add(jpoliceStation);
        filedPanel.add(jPassword);

        //文本框部分
        usename = new JLabel(USERNAME);
        name = new JTextField(NAME);
        //选择性别
        if (SEX.equals("男")) {
            male = new JRadioButton("男", true);
            female = new JRadioButton("女", false);
        } else if (SEX.equals("女")) {
            male = new JRadioButton("男", false);
            female = new JRadioButton("女", true);
        }


        //实现单选效果
        ButtonGroup sex = new ButtonGroup();
        sex.add(male);
        sex.add(female);
        //文本框部分
        idNum = new JTextField(ID);
        age = new JTextField(AGE);
        policeStation = new JTextField(POLICESTATION);
        password = new JTextField("请重新输入密码");

        usename.setBounds(110, 20, 140, 20);
        name.setBounds(110, 60, 140, 20);
        male.setBounds(110, 100, 50, 20);
        female.setBounds(165, 100, 140, 20);
        idNum.setBounds(110, 140, 140, 20);
        age.setBounds(110, 180, 140, 20);
        policeStation.setBounds(110, 220, 140, 20);
        password.setBounds(110, 260, 140, 20);

        //添加文本框
        filedPanel.add(usename);
        filedPanel.add(name);
        filedPanel.add(male);
        filedPanel.add(female);
        filedPanel.add(idNum);
        filedPanel.add(age);
        filedPanel.add(policeStation);
        filedPanel.add(password);

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
                int result = JOptionPane.showConfirmDialog(jf2, "是否修改信息", "修改信息", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    AdminController adminController = new AdminController();

                    String idNumText = idNum.getText().trim();
                    String nameText = name.getText().trim();
                    String policeStationText = policeStation.getText().trim();
                    String usenameText = usename.getText().trim();
                    String passwordText = password.getText().trim();
                    String sexText = sex.isSelected(male.getModel()) ? male.getText() : female.getText();
                    String ageText = age.getText().trim();

                    Police police = new Police(idNumText, nameText, sexText, Integer.valueOf(ageText), policeStationText, usenameText, passwordText);
                    if (adminController.updatePolice(police,Integer.valueOf(ageText))) {
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
