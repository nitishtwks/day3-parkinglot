package com.tw.bootcamp.model;

import com.tw.bootcamp.exception.ParkingSpotEmptyException;
import com.tw.bootcamp.exception.ParkingSpotOccupiedException;

public class ParkingSpot {
    private boolean occupied;

    private Vehicle parkedVehicle;

    public boolean isEmpty(){
        return !occupied;
    }

    public Vehicle getParkedCar(){
        return parkedVehicle;
    }

    public boolean parkVehicle(Vehicle vehicle) throws ParkingSpotOccupiedException {
        if(occupied){
            throw new ParkingSpotOccupiedException("Parking spot is not empty");
        }
        occupied = true;
        this.parkedVehicle = vehicle;
        return true;
    }
    public boolean unparkVehicle() throws ParkingSpotEmptyException {
        if(!occupied){
            throw new ParkingSpotEmptyException("Parking spot is empty");
        }
        occupied = false;
        this.parkedVehicle = null;
        return true;
    }
}
