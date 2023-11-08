package com.tw.bootcamp.model;

public class ParkingSpot {
    private boolean occupied;

    private Car parkedCar;

    public boolean isEmpty(){
        return !occupied;
    }

    public Car getParkedCar(){
        return parkedCar;
    }

    public boolean parkVehicle(Car car){
        if(occupied){
            throw new IllegalStateException("Parking spot is not empty");
        }
        occupied = true;
        this.parkedCar = car;
        return true;
    }
    public boolean unparkVehicle(){
        if(!occupied){
            throw new IllegalStateException("Parking spot is empty");
        }
        occupied = false;
        this.parkedCar = null;
        return true;
    }
}
