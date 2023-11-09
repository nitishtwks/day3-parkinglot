package com.tw.bootcamp.model;

import com.tw.bootcamp.exception.AllParkingLotsFullException;
import com.tw.bootcamp.exception.ParkingLotFullException;
import com.tw.bootcamp.exception.VehicleNotFoundException;

import java.util.List;
import java.util.Optional;

public class Valet {

    private final List<ParkingLot> parkingLotList;

    public Valet(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public boolean parkVehicle(Vehicle vehicle) throws AllParkingLotsFullException, ParkingLotFullException {
        ParkingLot parkingLot = getParkingLotWithEmptySpots();
        boolean isParked = parkingLot.parkVehicle(vehicle);
        return isParked;
    }

    private ParkingLot getParkingLotWithEmptySpots() throws AllParkingLotsFullException {
        Optional<ParkingLot> optParkingLot = parkingLotList.stream().filter(pl -> pl.areEmptySpotsAvailable()).findFirst();
        if(optParkingLot.isEmpty()){
            throw new AllParkingLotsFullException("All Parking lots are full");
        }
        return optParkingLot.get();
    }

    public boolean unparkVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        Optional<ParkingLot> optParkingLot = parkingLotList.stream()
                .filter(pl -> pl.isVehiclePresentInParkingLot(vehicle)).findFirst();
        if (optParkingLot.isEmpty()){
            throw new VehicleNotFoundException("Vehicle could not be found");
        }
        return optParkingLot.get().unparkVehicle(vehicle);
    }
}
