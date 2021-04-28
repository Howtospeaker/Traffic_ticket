package com.TrafficTicket.entity;


public class Ticket {
    private String ticketId;
    private Integer driverId;
    private String carId;
    private String policeId;
    private String vioTime;
    private String vioAddress;
    private Integer fine;
    private Integer payStatus;

    public Ticket(String ticketId, Integer driverId, String carId, String policeId, String vioTime, String vioAddress, Integer fine, Integer payStatus) {
        this.ticketId = ticketId;
        this.driverId = driverId;
        this.carId = carId;
        this.policeId = policeId;
        this.vioTime = vioTime;
        this.vioAddress = vioAddress;
        this.fine = fine;
        this.payStatus = payStatus;
    }

    public Ticket() {
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getVioTime() {
        return vioTime;
    }

    public void setVioTime(String vioTime) {
        this.vioTime = vioTime;
    }

    public String getVioAddress() {
        return vioAddress;
    }

    public void setVioAddress(String vioAddress) {
        this.vioAddress = vioAddress;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
}
