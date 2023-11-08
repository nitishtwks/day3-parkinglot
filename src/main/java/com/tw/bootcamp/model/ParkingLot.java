package com.tw.bootcamp.model;

public class ParkingLot {

    public boolean parkVehicle(){
        ParkingSpot spot = getEmptyParkingSpot();
        return spot.parkVehicle();
    }

    private ParkingSpot getEmptyParkingSpot() {
        return new ParkingSpot();
    }
}
