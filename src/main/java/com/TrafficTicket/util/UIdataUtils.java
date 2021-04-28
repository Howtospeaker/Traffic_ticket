package com.TrafficTicket.util;

import java.util.Vector;

public class UIdataUtils {
    public static void UIdataClear(Object[][] data, Vector dataV) {
        dataV.clear();
        for (int i = 0; i < data.length; i++) {
            Vector t = new Vector<>();
            for (int j = 0; j < data[i].length; j++) {
                t.add(data[i][j]);
            }
        }
    }

    public static void UIdataRefresh(Object[][] data, Vector dataV) {
        for (int i = 0; i < data.length; i++) {
            Vector t = new Vector<>();
            for (int j = 0; j < data[i].length; j++) {
                t.add(data[i][j]);
            }
            dataV.add(t);
        }
    }
}
