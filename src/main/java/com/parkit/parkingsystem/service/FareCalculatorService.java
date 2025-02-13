package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

    public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

        double inHour = ticket.getInTime().getTime()/(3600000d);
        double outHour = ticket.getOutTime().getTime()/(3600000d);

        double duration = outHour - inHour;
        duration = duration <= 0.5 ? 0 : duration;
        double discountedRate = ticket.isRecurring() ? 0.95 : 1;
        
        System.out.println("in="+inHour+", out="+outHour+", duration="+duration);
        switch (ticket.getParkingSpot().getParkingType()){
            case CAR: {
                ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR * discountedRate);
                break;
            }
            case BIKE: {
                ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR * discountedRate);
                break;
            }
            default: throw new IllegalArgumentException("Unkown Parking Type");
        }
    }
}