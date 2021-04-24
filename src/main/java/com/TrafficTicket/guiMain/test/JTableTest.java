package com.TrafficTicket.guiMain.test;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class JTableTest {
    JFrame jf = new JFrame("简单表格");

    //创建一维数组
    Object[] titles = {"姓名", "年龄", "性别"};

    //创建二维数组
    Object[][] data = {
            {"李清照", 29, "女"},
            {"李某", 56, "女"},
            {"李白", 35, "男"},
            {"李逵", 99, "男"},
            {"李人", 29, "女"}
    };

    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据

    public void init() {

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

        MyTableModel myTableModel = new MyTableModel();
        JTable jTable = new JTable(myTableModel);
        jf.add(new JScrollPane(jTable));

        //设置选择模式
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //设置列宽
//        TableColumn column1 = jTable.getColumn(titles[0]);
//        column1.setMinWidth(40);
//        TableColumn column3 = jTable.getColumn(titles[2]);
//        column3.setMaxWidth(50);

        JButton jbtn = new JButton("获取选中行数据");
        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedColumn = jTable.getSelectedColumn();
                int selectedRow = jTable.getSelectedRow();
                System.out.println("当前选中的行的索引" + selectedRow);
                System.out.println("当前选中列的索引" + selectedColumn);

                Object value = myTableModel.getValueAt(selectedRow, selectedColumn);
                System.out.println("当前第一格的内容" + value);
            }
        });

        jf.add(jbtn, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
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

