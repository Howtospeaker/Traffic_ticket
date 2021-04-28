package com.TrafficTicket.guiMain.mainUI.Admin.adminRightSplitPane;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.Vector;


//分割板右边组件
public class adminTicketRightSplitPane extends Box {

    //创建一维数组
    Object[] titles = {"罚单编号", "身份证号", "车牌号", "交警代号", "违章地点", "违章时间", "罚款金额", "缴费状态"};
    //创建二维数组
    Object[][] data = {
            {"李清照", 29, "女", "1", "1", "1", "1", "1"},
            {"李某", 56, "女", "1", "1", "1", "1", "1"},
            {"李白", 35, "男", "1", "1", "1", "1", "1"},
            {"李逵", 99, "男", "1", "1", "1", "1", "1"},
            {"李人", 29, "女", "1", "1", "1", "1", "1"},
            {"李人", 29, "女", "1", "1", "1", "1", "1"},
            {"李人", 29, "女", "1", "1", "1", "1", "1"}
    };

    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据

    public adminTicketRightSplitPane() {
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

        JButton select = new JButton("查询");
        JTextField inquireText = new JTextField();
        inquireText.setPreferredSize(new Dimension(160, 20));

        selectPanel.add(select);
        selectPanel.add(inquireText);


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
        MyTableModel myTableModel = new MyTableModel();
        JTable jTable = new JTable(myTableModel);
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(1920, 1080));
        tablePanel.setLayout(new GridLayout(1, 1));
        JScrollPane jScrollPane = new JScrollPane(jTable);
        tablePanel.add(jScrollPane);
        this.add(tablePanel);

        //设置选择模式
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JButton jbtn = new JButton("获取选中行数据");
//        jbtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                int selectedColumn = jTable.getSelectedColumn();
//                int selectedRow = jTable.getSelectedRow();
//                System.out.println("当前选中的行的索引" + selectedRow);
//                System.out.println("当前选中列的索引" + selectedColumn);
//
//                Object value = myTableModel.getValueAt(selectedRow, selectedColumn);
//                System.out.println("当前第一格的内容" + value);
//            }
//        });
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
