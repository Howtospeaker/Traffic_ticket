package com.TrafficTicket.guiMain.mainUI.Admin.adminRightSplitPane;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.guiMain.mainUI.Admin.adminDriverDialog.*;
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
public class adminDriverRightSplitPane extends Box {
    private JTable jTable;
    private MyTableModel myTableModel;
    //创建一维数组
    Object[] titles = {"身份证号", "姓名", "性别", "年龄", "驾驶证号", "账号", "密码"};
    //创建二维数组
    AdminController adminController = new AdminController();
    List<Object> list = adminController.selectAllDriver();
    ReflectPutInForm reflect = new ReflectPutInForm();
    Object[][] data = reflect.ReflectInit(list);

    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据

    public adminDriverRightSplitPane(JFrame jf) throws Exception {
        //垂直布局
        super(BoxLayout.Y_AXIS);

        //顶上标签
        JLabel welcome = new JLabel("欢迎管理员，使用罚单管理系统！                             ");
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

        //查询事件
        JButton select = new JButton("查询");
        JTextField inquireText = new JTextField();
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer ID = Integer.valueOf(inquireText.getText().trim());
                UIdataUtils.UIdataClear(data, dataV);
                myTableModel.fireTableDataChanged();

                list.clear();
                list.add(adminController.findDriverById(ID));
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

        //增加事件
        JButton add = new JButton("增加");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new addAdminDriverDialog().init();
            }
        });
        //修改事件
        JButton update = new JButton("修改");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获取当前表格选中的ID
                int selectedRow = jTable.getSelectedRow();
                System.out.println(selectedRow);
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择修改条目", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ID = jTable.getValueAt(selectedRow, 0).toString();
                    String NAME = jTable.getValueAt(selectedRow, 1).toString();
                    String SEX = jTable.getValueAt(selectedRow, 2).toString();
                    String AGE = jTable.getValueAt(selectedRow, 3).toString();
                    String DNUM = jTable.getValueAt(selectedRow, 4).toString();
                    String USERNAME = jTable.getValueAt(selectedRow, 5).toString();
                    String PASSWORD = jTable.getValueAt(selectedRow, 6).toString();
                    new updateAdminDriverDialog().init(ID, NAME, SEX, AGE, DNUM, USERNAME, PASSWORD);
                }
            }
        });
        //删除事件
        JButton delete = new JButton("删除");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请删除修改条目", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    int result = JOptionPane.showConfirmDialog(jf, "是否修改信息", "修改信息", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        Integer ID = Integer.valueOf(jTable.getValueAt(selectedRow, 0).toString());
                        if (new AdminController().deleteDriver(ID)) {
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
                list = adminController.selectAllDriver();
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

        //组装表格
        myTableModel = new MyTableModel();
        jTable = new JTable(myTableModel);
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(1920, 1080));
        tablePanel.setLayout(new GridLayout(1, 1));
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置只能选中一行
        JScrollPane jScrollPane = new JScrollPane(jTable);
        tablePanel.add(jScrollPane);
        this.add(tablePanel);
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

