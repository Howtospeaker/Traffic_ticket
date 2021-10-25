package com.TrafficTicket.guiMain.mainUI.Driver;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.util.ReflectPutInForm;
import com.TrafficTicket.util.UIdataUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;


public class driverCarRightSplitPane extends Box {
    private JTable jtable;
    private MyTableModel myTableModel;
    private Object[][] data={{"无车牌号","无驾驶证号","无行驶证号"}};
    private Integer driverId;

    //创建一维数组
    Object[] titles = {"车牌号", "驾驶证号", "行驶证号"};
    //创建二维数组
    AdminController adminController = new AdminController();
    ReflectPutInForm reflect = new ReflectPutInForm();
    @Autowired
    List<Object> list;

    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据

    public driverCarRightSplitPane(Integer driverId, Driver driver) throws Exception {
        //垂直布局
        super(BoxLayout.Y_AXIS);

        System.out.println(driverId);
        this.driverId=driverId;
        list = adminController.selectOwnCarInfo(driverId);
        if (list.size()==0){
            UIdataUtils.UIdataClear(data,dataV);
        } else {
            list.forEach(lst-> System.out.println(lst));
            data = reflect.ReflectInit(list);
        }

        //组装视图
        JLabel welcome = new JLabel("欢迎"+driver.getName()+"用户，使用罚单管理系统！                            ");
        welcome.setPreferredSize(new Dimension(763, 150));
        welcome.setFont(new Font("宋体", Font.BOLD, 20));
        this.add(welcome);

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
        //增加事件
        JButton add = new JButton("增加");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new addCarDialog().init(driver.getDriverId());
            }
        });
        //修改事件
        JButton update = new JButton("修改");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int selectedRow = jtable.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择修改条目", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    String CARID = jtable.getValueAt(selectedRow, 0).toString();
                    String DRIVERID = jtable.getValueAt(selectedRow, 1).toString();
                    String LICENSENUM = jtable.getValueAt(selectedRow, 2).toString();
                    new updateCarDialog().init(CARID,DRIVERID,LICENSENUM);
                }
            }
        });

        //删除事件
        JButton delete = new JButton("删除");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = jtable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择删除条目", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    String CARID = jtable.getValueAt(selectedRow, 0).toString();
                    if (new AdminController().deleteCarInfo(CARID)) {
                        JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        //刷新事件
        JButton refresh = new JButton("刷新");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UIdataUtils.UIdataClear(data,dataV);
                myTableModel.fireTableDataChanged();//刷新表

                list.clear();
                list = adminController.selectOwnCarInfo(driverId);
                if (list.size()==0){
                    UIdataUtils.UIdataClear(data,dataV);
                } else {
                    list.forEach(lst-> System.out.println(lst));
                    try {
                        data = reflect.ReflectInit(list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                UIdataUtils.UIdataRefresh(data, dataV);
            }
        });

        btnPanel.add(add);
        btnPanel.add(update);
        btnPanel.add(delete);
        btnPanel.add(refresh);

        sumPanel.add(selectPanel);
        sumPanel.add(btnPanel);
        sumPanel.setPreferredSize(new Dimension(763, 40));

        this.add(sumPanel);
        //给表格装信息
        for (int i = 0; i < titles.length; i++) {
            titlesV.add(titles[i]);
        }
        UIdataUtils.UIdataRefresh(data,dataV);
        //定义表格
        myTableModel = new MyTableModel();
        jtable = new JTable(myTableModel);
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(763, 1080));
        tablePanel.setLayout(new GridLayout(1, 1));
        JScrollPane jScrollPane = new JScrollPane(jtable);
        tablePanel.add(jScrollPane);
        this.add(tablePanel);
        //设置选择模式
        jtable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    private class MyTableModel extends AbstractTableModel {

        //行的大小
        @Override
        public int getRowCount() {
            return dataV.size();
        }

        //列的数量
        @Override
        public int getColumnCount() {
            return titlesV.size();
        }

        //返回某个单元格的内容
        @Override
        public Object getValueAt(int i, int i1) {
            return dataV.get(i).get(i1);
        }

        //获取列的名称
        @Override
        public String getColumnName(int column) {
            return (String) titlesV.get(column);
        }

        //指定单元格是否可编辑
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public void fireTableDataChanged() {
            super.fireTableDataChanged();
        }
    }
}

