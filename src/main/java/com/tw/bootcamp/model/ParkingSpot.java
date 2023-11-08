package com.tw.bootcamp.model;

public class ParkingSpot {
    private boolean occupied;

    private Car parkedCar;

    public boolean isEmpty(){
        return !occupied;
    }

    public boolean parkVehicle(Car car){
        if(occupied){
            throw new IllegalStateException("Parking spot is not empty");
        }
        occupied = true;
        this.parkedCar = car;
        return true;
    }
}
