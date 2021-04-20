package com.TrafficTicket;

import com.TrafficTicket.controller.AdminController;
import com.TrafficTicket.entity.AdminTicketView;
import com.TrafficTicket.entity.Car;
import com.TrafficTicket.entity.Police;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


@Component
public class test {
    //管理员菜单界面
    public static void AdminControllerTest() {
        AdminController adminController = new AdminController();
//        AdminController adminController = (AdminController) new ClassPathXmlApplicationContext("conf/applicationContext.xml").getBean("adminController");
        int flag = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("管理员操作界面");
            System.out.println("请选择需要服务");
            System.out.println("1. 车辆信息管理  2.交警信息管理  3.罚单查询  4.退出系统");
            flag = scan.nextInt();
            switch (flag){
                case 1:{
                    while (true) {
                        System.out.println("下面是对车辆信息的操作");
                        System.out.println("1.录入 2.更新 3.删除 4.查询 5.退出");
                        flag = scan.nextInt();
                        switch (flag) {
                            case 1: {
                                System.out.println("请输入你要录入的车辆信息");
                                Car car = new Car("北A-666666", 4408251, 333333);
                                System.out.println(adminController.addCarInfo(car));
                                break;
                            }
                            case 2: {
                                System.out.println("请输入你要更新的车辆信息");
                                Car car = new Car("北A-666666", 4408252, 444444);
                                System.out.println(adminController.updateCarInfo(car));
                                break;
                            }
                            case 3: {
                                System.out.println("请输入你要删除的车辆信息");
                                System.out.println(adminController.deleteCarInfo("北A-666888"));
                                break;
                            }
                            case 4: {
                                List<Car> list = adminController.selectAllCarInfo();
                                list.forEach(car -> System.out.println(car));
                                break;
                            }
                            case 5: {
                                System.out.println("退出成功");
                                AdminControllerTest();
                            }
                            default: {
                                System.out.println("输入错误,请重新输入");
                                break;
                            }
                        }
                        continue;
                    }
                }
                case 2:{
                    while (true){
                        System.out.println("下面是对交警信息的操作");
                        System.out.println("1.录入 2.更新 3.删除 4.查询 5.退出 ");
                        flag = scan.nextInt();
                        switch (flag) {
                            case 1: {
                                System.out.println("请输入你要录入的交警信息");
                                Police police = new Police("C2221","李云龙","意大利炮分局","123","123");
                                System.out.println(adminController.addPolice(police));
                                break;
                            }
                            case 2: {
                                System.out.println("请输入你要更新的交警信息");
                                Police police = new Police("C2221","李云龙","意大利炮总局","123","123");
                                System.out.println(adminController.updatePolice(police));
                                break;
                            }
                            case 3: {
                                System.out.println("请输入你要删除的交警信息");
                                System.out.println(adminController.deletePolice("C2222"));
                                break;
                            }
                            case 4: {
                                List<Police> list = adminController.selectAllPolice();
                                list.forEach(police -> System.out.println(police));
                                break;
                            }
                            case 5: {
                                System.out.println("退出成功");
                                AdminControllerTest();
                                break;
                            }
                            default: {
                                System.out.println("输入错误,请重新输入");
                                break;
                            }
                        }
                    }
                }
                case 3:{
                    System.out.println("罚单查询");
                    List<AdminTicketView> list = adminController.AdminSelectTicketView();
                    list.forEach(adminTicketView -> System.out.println(adminTicketView));
                    continue;
                }
                case 4:{
                    System.out.println("退出成功");
                    System.exit(1);
                    continue;
                }
                default: {
                    System.out.println("输入错误,请重新输入");
                    continue;
                }
            }
        }
    }
    //交警菜单界面
    public static void PoliceControllerTest(){

    }
    //驾驶员菜单界面
    public static void DriverControllerTest(){}
    //主方法
    public static void main(String[] args) {
        while (true){
            System.out.println("欢迎来到交通罚单管理系统");

            System.out.println("请确认你的身份");
            System.out.println("1.管理员 2.交警 3.驾驶员 4.退出系统");

            Scanner scan = new Scanner(System.in);
            int flag = scan.nextInt();
            switch (flag){
                case 1:{
                    System.out.println("请管理员先进行登录");
                    AdminControllerTest();
                    break;
                }
                case 2:{
                    System.out.println("请交警先进行登录");
                    PoliceControllerTest();
                    break;
                }
                case 3:{
                    System.out.println("请驾驶员先进行登录");
                    DriverControllerTest();
                    break;
                }
                case 4:{
                    System.out.println("退出成功");
                    System.exit(1);
                    break;
                }
                default:{
                    System.out.println("输入错误,请重新输入");
                    break;
                }
            }
        }
    }
}
