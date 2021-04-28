package com.TrafficTicket.entity;


public class DriverTicketView {
    private Integer driverId;
    private String carID;

    public DriverTicketView(Integer driverId, String carID) {
        this.driverId = driverId;
        this.carID = carID;
    }

    public DriverTicketView() {
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }
}
