package com.TrafficTicket.entity;

import lombok.Data;

@Data
public class Ticket {
    private Integer driverId;
    private String carId;
    private String policeId;
    private String vioTime;
    private String vioAddress;
    private Integer fine;
    private Integer payStatus;
}
