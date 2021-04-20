package com.TrafficTicket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String carId;
    private Integer driverId;
    private Integer licenseNum;
}
