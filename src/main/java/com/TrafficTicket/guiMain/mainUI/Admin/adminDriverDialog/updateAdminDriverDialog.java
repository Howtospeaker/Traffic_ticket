package com.TrafficTicket.guiMain.mainUI.Admin.adminDriverDialog;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.guiMain.main.selectIdentity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class updateAdminDriverDialog {
    private JTextField idNum;
    private JTextField driverNum;
    private JTextField age;
    private JTextField password;
    private JLabel usename;
    private JTextField name;
    private JRadioButton male;
    private JRadioButton female;


    public void init(String ID, String NAME, String SEX, String AGE, String DNUM, String USERNAME, String PASSWORD) {
        JFrame jf2 = new JFrame("修改驾驶员信息");
        jf2.setBounds(600, 200, 350, 450);
        jf2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Container c = jf2.getContentPane();
        c.setLayout(new BorderLayout());
        //标题设置
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("修 改 驾 驶 员 信 息"));
        c.add(titlePanel, "North");
        //输入信息左边部分
        JPanel filedPanel = new JPanel();
        filedPanel.setLayout(null);
        JLabel jUsename = new JLabel("账号");
        JLabel jName = new JLabel("姓名");
        JLabel jSex = new JLabel("性别");
        JLabel jIdNum = new JLabel("身份证号");
        JLabel jDriverNum = new JLabel("驾驶证号");
        JLabel jAge = new JLabel("年龄");
        JLabel jPassword = new JLabel("更改密码");
        jUsename.setBounds(30, 20, 50, 20);
        jName.setBounds(30, 60, 50, 20);
        jSex.setBounds(30, 100, 50, 20);
        jIdNum.setBounds(30, 140, 50, 20);
        jDriverNum.setBounds(30, 180, 80, 20);
        jAge.setBounds(30, 220, 80, 20);
        jPassword.setBounds(30, 260, 80, 20);
        //左边标签添加
        filedPanel.add(jUsename);
        filedPanel.add(jName);
        filedPanel.add(jSex);
        filedPanel.add(jIdNum);
        filedPanel.add(jDriverNum);
        filedPanel.add(jAge);
        filedPanel.add(jPassword);


        //输入信息部分
        idNum = new JTextField(ID);
        driverNum = new JTextField(DNUM);
        age = new JTextField(AGE);
        password = new JTextField("请重新输入密码");
        usename = new JLabel(USERNAME);
        name = new JTextField(NAME);
        //选择男女性别
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
        //输入信息部分
        usename.setBounds(110, 20, 140, 20);
        name.setBounds(110, 60, 140, 20);
        male.setBounds(110, 100, 50, 20);
        female.setBounds(165, 100, 140, 20);
        idNum.setBounds(110, 140, 140, 20);
        driverNum.setBounds(110, 180, 140, 20);
        age.setBounds(110, 220, 140, 20);
        password.setBounds(110, 260, 140, 20);
        //文本框添加
        filedPanel.add(usename);
        filedPanel.add(name);
        filedPanel.add(male);
        filedPanel.add(female);
        filedPanel.add(idNum);
        filedPanel.add(driverNum);
        filedPanel.add(age);
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

                    String usenameText = usename.getText().trim();
                    String nameText = name.getText().trim();
                    String sexText = sex.isSelected(male.getModel()) ? male.getText() : female.getText();
                    String idNumText = idNum.getText().trim();
                    String driverNumText = driverNum.getText().trim();
                    String ageText = age.getText().trim();
                    String passwordText = password.getText().trim();

                    Driver driver = new Driver(Integer.parseInt(idNumText), nameText, sexText, Integer.parseInt(ageText), Integer.valueOf(driverNumText), usenameText, passwordText);
                    if (adminController.updateDriver(driver)) {
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


