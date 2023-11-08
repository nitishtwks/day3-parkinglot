package com.tw.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final int capacity;

    private final List<ParkingSpot> parkingSpotList;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpotList = new ArrayList<>();
    }

    public boolean parkVehicle(Car car){
        ParkingSpot spot = getEmptyParkingSpot();
        return spot.parkVehicle(car);
    }

    private ParkingSpot getEmptyParkingSpot() {
        if(parkingSpotList.size()==capacity){
            throw new IllegalStateException("No empty slot available");
        }
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpotList.add(parkingSpot);
        return parkingSpot;
    }
}
