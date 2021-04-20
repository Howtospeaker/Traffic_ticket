package com.TrafficTicket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminTicketView {
    private Integer driverId;
    private String carId;
    private String policeId;
}
