package com.TrafficTicket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private String ticketId;
    private Integer driverId;
    private String carId;
    private String policeId;
    private String vioTime;
    private String vioAddress;
    private Integer fine;
    private Integer payStatus;
}
