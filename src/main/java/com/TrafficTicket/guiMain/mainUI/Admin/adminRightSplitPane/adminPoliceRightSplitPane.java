package com.TrafficTicket.guiMain.mainUI.Admin.adminRightSplitPane;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.guiMain.mainUI.Admin.adminPoliceDialog.*;
import com.TrafficTicket.util.ReflectPutInForm;
import com.TrafficTicket.util.UIdataUtils;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


//分割板右边组件
public class adminPoliceRightSplitPane extends Box {

    private JTable jtable;
    private JTextField inquireText;
    private MyTableModel myTableModel;
    //创建一维数组
    Object[] titles = {"交警编号", "交警名字", "性别", "年龄", "所属分局", "账号", "密码"};
    //创建二维数组
    AdminController adminController = new AdminController();
    List<Object> list = adminController.selectAllPolice();
    ReflectPutInForm reflect = new ReflectPutInForm();
    Object[][] data = reflect.ReflectInit(list);


    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据

    public adminPoliceRightSplitPane() throws Exception {
        //垂直布局
        super(BoxLayout.Y_AXIS);

        //组装视图
        JPanel picturePanel = new JPanel();
        picturePanel.setPreferredSize(new Dimension(1920, 150));
        picturePanel.setBackground(new Color(0xD31D28));

        this.add(picturePanel);

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

        //TODO 查询事件
        inquireText = new JTextField();
        JButton select = new JButton("查询");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AdminController adminController = new AdminController();
                String InquireText = inquireText.getText().trim();
                Police police = adminController.findPoliceById(InquireText);
                if (police != null) {
                    Map<Integer, Object> map = new HashMap<>();
                    map.put(1, police);
                } else {
                    JOptionPane.showMessageDialog(null, "查无此人", "查询失败", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        inquireText.setPreferredSize(new Dimension(160, 20));

        selectPanel.add(select);
        selectPanel.add(inquireText);
        //增加事件
        JButton add = new JButton("增加");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new addAdminPoliceDialog().init();
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
                    String ID = jtable.getValueAt(selectedRow, 0).toString();
                    String NAME = jtable.getValueAt(selectedRow, 1).toString();
                    String SEX = jtable.getValueAt(selectedRow, 2).toString();
                    String AGE = jtable.getValueAt(selectedRow, 3).toString();
                    String POLICESTATION = jtable.getValueAt(selectedRow, 4).toString();
                    String USERNAME = jtable.getValueAt(selectedRow, 5).toString();
                    String PASSWORD = jtable.getValueAt(selectedRow, 6).toString();
                    new updateAdminPoliceDialog().init(ID, NAME, SEX, AGE, POLICESTATION, USERNAME, PASSWORD);
                }
            }
        });
        //TODO 删除事件
        JButton delete = new JButton("删除");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        //刷新事件
        JButton refresh = new JButton("刷新");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UIdataUtils.UIdataClear(data, dataV);
                myTableModel.fireTableDataChanged();
                list.clear();
                list = adminController.selectAllPolice();
                Object[][] data = new Object[0][];
                try {
                    data = reflect.ReflectInit(list);
                } catch (Exception e) {
                    e.printStackTrace();
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
        sumPanel.setPreferredSize(new Dimension(1920, 40));

        this.add(sumPanel);

        //给表格装信息
        for (int i = 0; i < titles.length; i++) {
            titlesV.add(titles[i]);
        }
        UIdataUtils.UIdataRefresh(data, dataV);
        //定义表格
        myTableModel = new MyTableModel();
        jtable = new JTable(myTableModel);
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(1920, 1080));
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
        public Object getValueAt(int i, int j) {
            return dataV.get(i).get(j);
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
