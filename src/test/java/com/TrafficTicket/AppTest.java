package com.TrafficTicket;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.util.ReflectPutInForm;
import org.junit.Test;

import java.util.List;

public class AppTest {
    @Test
    public void DriverRegisterTest(){
//        DriverController driverController = new DriverController();
//        PoliceController policeController = new PoliceController();
//        if (policeController.register(new Police("F8254","哈利","佛山分局","123","123")))
//            System.out.println("注册成功");
//        else System.out.println("注册失败");
        AdminController adminController = new AdminController();
        System.out.println(adminController.addCarInfo(new Car("粤I-aa888",4408253,123)));    }

    AdminController adminController = new AdminController();

    @Test
    public void test() throws Exception{
        List<Object> list = adminController.selectAllPolice();
        ReflectPutInForm reflect = new ReflectPutInForm();
        Object[][] a = reflect.ReflectInit(list);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}
