package com.parkit.parkingsystem.model;

import java.util.Date;

public class Ticket {
    private int id;
    private ParkingSpot parkingSpot;
    private String vehicleRegNumber;
    private double price;
    private Date inTime;
    private Date outTime;
    private boolean recurring = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getInTime() {
    	if(inTime==null)return null;
    	
        return (Date)inTime.clone();
    }

    public void setInTime(Date inTime) {
    	if(inTime==null)return;
    	
        this.inTime = (Date)inTime.clone();
    }

    public Date getOutTime() {
    	if(outTime==null)return null;
    	
        return (Date)outTime.clone();
    }

    public void setOutTime(Date outTime) {
    	if(outTime==null)return;
    	
        this.outTime = (Date)outTime.clone();
    }

	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}
}
