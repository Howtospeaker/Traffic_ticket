package com.TrafficTicket.entity;




public class AdminTicketView {
    private Integer driverId;
    private String carId;
    private String policeId;

    public AdminTicketView(Integer driverId, String carId, String policeId) {
        this.driverId = driverId;
        this.carId = carId;
        this.policeId = policeId;
    }

    public AdminTicketView() {
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
}
