package com.TrafficTicket;

import com.TrafficTicket.controller.DriverController;
import com.TrafficTicket.controller.PoliceController;
import com.TrafficTicket.entity.Driver;
import com.TrafficTicket.entity.Police;
import org.junit.Test;

public class AppTest {
    @Test
    public void DriverRegisterTest(){
//        DriverController driverController = new DriverController();
        PoliceController policeController = new PoliceController();
        if (policeController.register(new Police("F8254","哈利","佛山分局","123","123")))
            System.out.println("注册成功");
        else System.out.println("注册失败");
    }
}
