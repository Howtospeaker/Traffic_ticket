package com.TrafficTicket.guiMain.mainUI.Admin.adminRightSplitPane;

import com.TrafficTicket.controller.AdminController;
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
public class adminTicketRightSplitPane extends Box {
    private MyTableModel myTableModel;

    //创建一维数组
    Object[] titles = {"罚单编号", "身份证号", "车牌号", "交警代号", "违章时间", "违章地点", "罚款金额", "缴费状态"};
    //创建二维数组
    AdminController adminController = new AdminController();
    List<Object> list = adminController.selectTicketView();
    ReflectPutInForm reflect = new ReflectPutInForm();
    Object[][] data = reflect.ReflectInit(list);

    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据

    public adminTicketRightSplitPane() throws Exception {
        //垂直布局
        super(BoxLayout.Y_AXIS);

        //组装视图
        JLabel welcome = new JLabel("          欢迎管理员，使用罚单管理系统！");
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
        //查询事件
        JButton select = new JButton("查询");
        JTextField inquireText = new JTextField();
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String carID = inquireText.getText().trim();
                UIdataUtils.UIdataClear(data, dataV);
                myTableModel.fireTableDataChanged();

                list.clear();
                list = adminController.findTicketByCarId(carID);
                Object[][] data = new Object[0][];
                try {
                    data = reflect.ReflectInit(list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                UIdataUtils.UIdataRefresh(data, dataV);
            }
        });
        inquireText.setPreferredSize(new Dimension(160, 20));

        selectPanel.add(select);
        selectPanel.add(inquireText);
        //刷新事件
        JButton refresh = new JButton("刷新");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UIdataUtils.UIdataClear(data, dataV);
                myTableModel.fireTableDataChanged();//刷新表
                list.clear();
                list = adminController.selectTicketView();
                Object[][] data = new Object[0][];
                try {
                    data = reflect.ReflectInit(list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                UIdataUtils.UIdataRefresh(data, dataV);
            }
        });
        btnPanel.add(refresh);
        sumPanel.add(selectPanel);
        sumPanel.add(btnPanel);
        sumPanel.setPreferredSize(new Dimension(1920, 40));

        this.add(sumPanel);

        //给表格装信息
        for (int i = 0; i < titles.length; i++) {
            titlesV.add(titles[i]);
        }
        for (int i = 0; i < data.length; i++) {
            Vector t = new Vector<>();
            for (int j = 0; j < data[i].length; j++) {
                t.add(data[i][j]);
            }
            dataV.add(t);
        }
        //定义表格
        myTableModel = new MyTableModel();
        JTable jTable = new JTable(myTableModel);
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(1920, 1080));
        tablePanel.setLayout(new GridLayout(1, 1));
        JScrollPane jScrollPane = new JScrollPane(jTable);
        tablePanel.add(jScrollPane);
        this.add(tablePanel);

        //设置选择模式
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
    }

}
