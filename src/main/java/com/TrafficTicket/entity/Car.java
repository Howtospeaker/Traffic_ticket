package com.TrafficTicket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;



public class Car {
    private String carId;
    private Integer driverId;
    private Integer licenseNum;

    public Car(String carId, Integer driverId, Integer licenseNum) {
        this.carId = carId;
        this.driverId = driverId;
        this.licenseNum = licenseNum;
    }
    public Car(){

    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(Integer licenseNum) {
        this.licenseNum = licenseNum;
    }
}
