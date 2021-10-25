package com.TrafficTicket.guiMain.mainUI.Police;


import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.controller.PoliceController;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.Police;
import com.TrafficTicket.guiMain.mainUI.Driver.ticketPayDialog;
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


//分割板右边组件
public class policeTicketRightSplitPane extends Box {
    private JTable jTable;
    private MyTableModel myTableModel;
    private Object[][] data = {{"无", "无", "无", "无", "无", "无", "无", "无"}};
    private String policeId;

    //创建一维数组
    Object[] titles = {"罚单编号", "被罚车主身份证号", "车牌号", "交警代号", "违章时间", "违章地点", "罚款金额", "缴费状态"};
    //创建二维数组
    PoliceController policeController = new PoliceController();
    ReflectPutInForm reflect = new ReflectPutInForm();
    @Autowired
    List<Object> list;

    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据

    public policeTicketRightSplitPane(String policeId, Police police, Frame jf) throws Exception {
        //垂直布局
        super(BoxLayout.Y_AXIS);

        System.out.println(policeId);
        this.policeId = policeId;
        list = policeController.selectOwnTicket(policeId);
        if (list.size() == 0) {
            UIdataUtils.UIdataClear(data, dataV);
        } else {
            list.forEach(lst -> System.out.println(lst));
            data = reflect.ReflectInit(list);
        }

        //组装视图
        JLabel welcome = new JLabel("欢迎"+police.getName()+"警官，使用罚单管理系统！                       ");
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


        JButton add = new JButton("增加");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new addTicketDialog().init(policeId);
            }
        });


        JButton pay = new JButton("修改");
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1) {
                } else {
                    String TICKETID = jTable.getValueAt(selectedRow, 0).toString();
                    Integer DRIVERID = Integer.valueOf(jTable.getValueAt(selectedRow, 1).toString());
                    String CARID = jTable.getValueAt(selectedRow, 2).toString();
                    String POLICEID = jTable.getValueAt(selectedRow, 3).toString();
                    String VIOTIME = jTable.getValueAt(selectedRow, 4).toString();
                    String VIOADDRESS = jTable.getValueAt(selectedRow, 5).toString();
                    Integer FINE = Integer.valueOf(jTable.getValueAt(selectedRow, 6).toString());
                    Integer PAYSTATUS = Integer.valueOf(jTable.getValueAt(selectedRow, 7).toString());
                    if (PAYSTATUS.equals("无") || PAYSTATUS.equals("1")) {
                        JOptionPane.showMessageDialog(null, "此罚单不需要修改", "修改失败", JOptionPane.WARNING_MESSAGE);
                    } else {
                        new updateTicketDialog().init(TICKETID, DRIVERID, CARID, POLICEID, VIOTIME, VIOADDRESS, FINE, PAYSTATUS);
                    }
                }
            }
        });

        JButton delete = new JButton("删除");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请删除修改条目", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    int result = JOptionPane.showConfirmDialog(jf, "是否修改罚单信息", "修改罚单", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        String TicketId = jTable.getValueAt(selectedRow, 0).toString();
                        if (new PoliceController().deleteTicket(TicketId)) {
                            JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    if (result == JOptionPane.CANCEL_OPTION) {
                    }
                }
            }
        });

        //刷新事件
        JButton refresh = new JButton("刷新");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UIdataUtils.UIdataClear(data, dataV);
                myTableModel.fireTableDataChanged();//刷新表
                list.clear();
                list = policeController.selectOwnTicket(policeId);
                if (list.size() == 0) {
                    UIdataUtils.UIdataClear(data, dataV);
                } else {
                    list.forEach(lst -> System.out.println(lst));
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
        btnPanel.add(pay);
        btnPanel.add(delete);
        btnPanel.add(refresh);

        sumPanel.add(selectPanel);
        sumPanel.add(btnPanel);
        sumPanel.setPreferredSize(new Dimension(1920, 40));

        this.add(sumPanel);
        //组装表格
        for (
                int i = 0;
                i < titles.length; i++) {
            titlesV.add(titles[i]);
        }
        UIdataUtils.UIdataRefresh(data, dataV);
        //定义表格
        myTableModel = new MyTableModel();

        jTable = new JTable(myTableModel);

        JPanel tablePanel = new JPanel();tablePanel.setPreferredSize(new Dimension(1920, 1080));
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
