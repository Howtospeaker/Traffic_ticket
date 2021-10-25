package com.TrafficTicket.guiMain.mainUI.Police;

import com.TrafficTicket.entity.Police;
import com.TrafficTicket.guiMain.selectIdentity.selectIdentity;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class policeUI {

    //组装视图
    public void init(Police police, String password) throws Exception {
        JFrame jf = new JFrame("交警操作界面");
        jf.setSize(1000,600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //菜单条
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("设置");
        JMenuItem m1 = new JMenuItem("切换账号");
        JMenuItem m2 = new JMenuItem("退出系统");
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int result = JOptionPane.showConfirmDialog(jf, "是否切换账号", "切换账号", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    jf.dispose();
                    new selectIdentity().init();
                }
                if (result == JOptionPane.CANCEL_OPTION) {

                }
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int result = JOptionPane.showConfirmDialog(jf, "是否退出系统", "退出系统", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
                if (result == JOptionPane.CANCEL_OPTION) {

                }
            }
        });

        jMenu.add(m1);
        jMenu.add(m2);
        jmb.add(jMenu);
        jf.setJMenuBar(jmb);

        //总分割面板//支持连续布局
        JSplitPane sp = new JSplitPane();
        sp.setContinuousLayout(true);
        sp.setDividerLocation(180);
        sp.setEnabled(false);
        sp.setDividerSize(7);

        //分隔板左侧
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();
        upPanel.setLayout(new GridLayout(2,1));

        JSplitPane spLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT,upPanel,downPanel);
        spLeft.setDividerLocation(230);
        spLeft.setDividerSize(7);
        spLeft.setEnabled(false);
        sp.setLeftComponent(spLeft);

        //树结点设置
        MyRenderer myRenderer = new MyRenderer();
        Color color = new Color(0xC7D0D3);
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));

        //信息管理树定义
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("信息管理");
        DefaultMutableTreeNode policeManage = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode driverManage = new DefaultMutableTreeNode("罚单管理");

        root.add(policeManage);
        root.add(driverManage);
        JTree tree = new JTree(root);
        tree.setCellRenderer(myRenderer);
        tree.setBackground(color);

        //设置信息管理树结点
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if(policeManage.equals(lastPathComponent)){
                    try {
                        sp.setRightComponent(new policeRightSplitPane(police,jf,password));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    sp.setDividerLocation(180);
                }else if (driverManage.equals(lastPathComponent)){
                    try {
                        sp.setRightComponent(new policeTicketRightSplitPane(police.getPoliceId(),police,jf));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    sp.setDividerLocation(180);
                }
            }
        });

        upPanel.add(tree);

        //设置树定义
        DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("设置");
        DefaultMutableTreeNode switchAccounts = new DefaultMutableTreeNode("切换账号");
        DefaultMutableTreeNode exit = new DefaultMutableTreeNode("退出系统");
        root2.add(switchAccounts);
        root2.add(exit);
        JTree tree2 = new JTree(root2);
        tree2.setCellRenderer(myRenderer);
        tree2.setBackground(color);

        //设置信息管理树结点
        tree2.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if (switchAccounts.equals(lastPathComponent)) {

                    int result = JOptionPane.showConfirmDialog(jf, "是否切换账号", "切换账号", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        jf.dispose();
                        new selectIdentity().init();
                    }
                    if (result == JOptionPane.CANCEL_OPTION) {

                    }

                } else if (exit.equals(lastPathComponent)) {
                    int result = JOptionPane.showConfirmDialog(jf, "是否退出系统", "退出系统", JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        System.exit(0);
                    }
                    if (result == JOptionPane.CANCEL_OPTION) {

                    }
                }

            }
        });

        upPanel.add(tree2);

        //默认打开界面为警察管理
        sp.setRightComponent(new policeRightSplitPane(police,jf,password));
        jf.add(sp);

        jf.setResizable(false);
        jf.setVisible(true);
    }

    //结点绘制器
    private class MyRenderer extends DefaultTreeCellRenderer{

        //当绘制树的每个结点时，都会调用
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            return this;
        }
    }
}

