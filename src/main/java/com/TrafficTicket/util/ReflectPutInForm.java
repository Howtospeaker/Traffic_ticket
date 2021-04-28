package com.TrafficTicket.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectPutInForm {
    public Object[][] ReflectInit(List<Object> list)throws Exception{
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        Object [][] listData = new Object[list.size()][fields.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0;j< fields.length;j++){
                Method method = list.get(i).getClass().getMethod("get"+fields[j].getName().substring(0,1).toUpperCase()+fields[j].getName().substring(1));
//              getClass().getMethod("get"+ fields[i].getName().substring(0,1).toUpperCase()+fields[i].getName().substring(1)).getName();
                listData[i][j]= method.invoke(list.get(i), new Object[]{});
            }
        }
        return listData;
    }
}
