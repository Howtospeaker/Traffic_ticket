package com.TrafficTicket.guiMain.mainUI.Admin;


import javax.swing.*;
import java.awt.*;

public class adminUI {
    public void ui() {
        JFrame jf = new JFrame("管理员操作界面");
        jf.setBounds(0,0,1920,1080);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //创建文本
        JTextArea jText = new JTextArea();
        jText.setLineWrap(true);
        jText.setFont(new Font("楷体",1,16));
        jText.setForeground(Color.BLUE);

        //创建滚动板，指定显示组件
        JScrollPane jScrollPane = new JScrollPane(jText

        );

        jf.setVisible(true);
    }
}
