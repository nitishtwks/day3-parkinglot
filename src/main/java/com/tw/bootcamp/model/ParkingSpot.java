package com.tw.bootcamp.model;

public class ParkingSpot {
    private boolean occupied;

    public boolean parkVehicle(){
        if(occupied){
            throw new IllegalStateException("Parking spot is not empty");
        }
        occupied = true;
        return true;
    }

    public boolean removeVehicle(){
        if(!occupied){
            return false;
        }
        occupied = false;
        return true;
    }
}
