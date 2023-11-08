package com.tw.bootcamp.model;

public class ParkingSpot {
    private boolean occupied;

    public boolean parkVehicle(){
        if(occupied){
            return false;
        }
        occupied = true;
        return true;
    }

    public boolean removeVehicle(){
        if(!occupied){
            throw new IllegalStateException();
        }
        occupied = false;
        return true;
    }
}
