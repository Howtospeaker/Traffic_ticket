package com.TrafficTicket.entity;

import lombok.Data;

@Data
public class Car {
    private String carId;
    private Integer driverId;
    private Integer licenseNum;
}
