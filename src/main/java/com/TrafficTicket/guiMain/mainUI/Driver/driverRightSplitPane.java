package com.TrafficTicket.guiMain.mainUI.Driver;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.guiMain.mainUI.Admin.adminDriverDialog.addAdminDriverDialog;
import com.TrafficTicket.guiMain.mainUI.Admin.adminDriverDialog.updateAdminDriverDialog;
import com.TrafficTicket.guiMain.mainUI.Admin.adminRightSplitPane.adminDriverRightSplitPane;
import com.TrafficTicket.util.ReflectPutInForm;
import com.TrafficTicket.util.UIdataUtils;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;


//分割板右边组件
public class driverRightSplitPane extends Box {
    private JLabel userNameField;
    private JLabel nameField;
    private JLabel sexField;
    private JLabel ageField;
    private JLabel driverIdField;
    private JLabel driverNumField;

    public driverRightSplitPane(Driver driver,JFrame jf,String password) throws Exception {
        //垂直布局
        super(BoxLayout.Y_AXIS);
        Color colorTypeFace = new Color(211, 29, 40);

        //顶上标签
        JLabel welcome = new JLabel("欢迎"+driver.getName()+"用户，使用罚单管理系统！");
        welcome.setPreferredSize(new Dimension(763, 150));
        welcome.setFont(new Font("宋体", Font.BOLD, 20));
        this.add(welcome);
        //组装二层面板
        JPanel sumPanel = new JPanel();
        sumPanel.setLayout(new GridLayout(1, 2));
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Color color = new Color(0xCAD3C9);
        btnPanel.setBackground(color);
        sumPanel.setBackground(color);
        selectPanel.setBackground(color);

        //修改事件
        JButton update = new JButton("修改");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ID = driverIdField.getText().trim();
                String NAME = nameField.getText().trim();
                String SEX = sexField.getText().trim();
                String AGE = ageField.getText().trim();
                String DNUM = driverNumField.getText().trim();
                String USERNAME = userNameField.getText().trim();
                new updateDriverDialog().init(ID, NAME, SEX, AGE, DNUM, USERNAME,password);
            }
        });
        //刷新事件
        JButton refresh = new JButton("刷新");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AdminController adminController = new AdminController();
                Driver driver = adminController.findDriverById(Integer.valueOf(driverIdField.getText().trim()));
                try {
                    new driverUI().init(driver,password);
                    jf.dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnPanel.add(update);
        btnPanel.add(refresh);
        sumPanel.add(selectPanel);
        sumPanel.add(btnPanel);
        sumPanel.setPreferredSize(new Dimension(763, 40));
        this.add(sumPanel);

        //显示个人信息表格
        Font font = new Font("宋体", Font.BOLD, 20);
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(763, 1080));
        tablePanel.setLayout(null);


        JLabel userName = new JLabel("账   号:");
        userNameField = new JLabel(driver.getLoginAct());
        userNameField.setForeground(colorTypeFace);
        userName.setFont(font);
        userNameField.setFont(font);
        userName.setBounds(50, 20, 100, 40);
        userNameField.setBounds(150, 25, 140, 30);
        tablePanel.add(userName);
        tablePanel.add(userNameField);

        JLabel name = new JLabel("姓   名:");
        nameField = new JLabel(driver.getName());
        nameField.setForeground(colorTypeFace);
        name.setFont(font);
        nameField.setFont(font);
        name.setBounds(420, 20, 100, 40);
        nameField.setBounds(520, 25, 140, 30);
        tablePanel.add(name);
        tablePanel.add(nameField);

        JLabel sex = new JLabel("性   别:");
        sexField = new JLabel(driver.getSex());
        sexField.setForeground(colorTypeFace);
        sex.setFont(font);
        sexField.setFont(font);
        sex.setBounds(50, 100, 100, 40);
        sexField.setBounds(150, 105, 140, 30);
        tablePanel.add(sex);
        tablePanel.add(sexField);

        JLabel age = new JLabel("年   龄:");
        ageField = new JLabel(driver.getAge().toString());
        ageField.setForeground(colorTypeFace);
        age.setFont(font);
        ageField.setFont(font);
        age.setBounds(420, 100, 100, 40);
        ageField.setBounds(520, 105, 140, 30);
        tablePanel.add(age);
        tablePanel.add(ageField);

        JLabel driverId = new JLabel("身份证号:");
        driverIdField = new JLabel(driver.getDriverId().toString());
        driverIdField.setForeground(colorTypeFace);
        driverId.setFont(font);
        driverIdField.setFont(font);
        driverId.setBounds(50, 180, 100, 40);
        driverIdField.setBounds(150, 185, 140, 30);
        tablePanel.add(driverId);
        tablePanel.add(driverIdField);

        JLabel driverNum = new JLabel("驾驶证号:");
        driverNumField = new JLabel(driver.getDriverNum().toString());
        driverNumField.setForeground(colorTypeFace);
        driverNum.setFont(font);
        driverNumField.setFont(font);
        driverNum.setBounds(420, 180, 100, 40);
        driverNumField.setBounds(520, 185, 140, 30);
        tablePanel.add(driverNum);
        tablePanel.add(driverNumField);

        this.add(tablePanel);
    }

}
