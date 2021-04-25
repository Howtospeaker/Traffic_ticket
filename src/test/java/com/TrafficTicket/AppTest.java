package com.TrafficTicket;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.controller.PoliceController;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.Police;
import org.junit.Test;

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
}
