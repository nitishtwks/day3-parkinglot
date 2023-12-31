package com.tw.bootcamp.model;

import com.tw.bootcamp.exception.ParkingLotFullException;
import com.tw.bootcamp.exception.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {

    private final int capacity;

    private final List<ParkingSpot> parkingSpotList;

    private List<ParkingNotificationSubscriber> subscribers;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpotList = new ArrayList<>();
        for (int i=0;i<capacity;i++){
            this.parkingSpotList.add(new ParkingSpot());
        }
        this.subscribers = new ArrayList<>();
    }

    public boolean parkVehicle(Vehicle vehicle) throws ParkingLotFullException {
        ParkingSpot spot = getEmptyParkingSpot();
        boolean isParked = spot.parkVehicle(vehicle);
        if (getCountOfParkedCars() == capacity && isParked) {
            notifySubscribers(ParkingNotificationSubscriber.NOTFN_PARKING_LOT_FULL);
        }
        return isParked;
    }

    private ParkingSpot getEmptyParkingSpot() throws ParkingLotFullException {
        Optional<ParkingSpot> optParkingSpot = parkingSpotList.stream().filter(s->s.isEmpty()).findFirst();
        if(optParkingSpot.isEmpty()){
            throw new ParkingLotFullException("No empty slot available. Parking lot is Full");
        }
        return optParkingSpot.get();
    }

    public boolean unparkVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        ParkingSpot parkingSpot = getVehicleParkingSpotFromParkingLot(vehicle);
        boolean isUnParked = parkingSpot.unparkVehicle();
        if (getCountOfParkedCars() == capacity-1 && isUnParked) {
            notifySubscribers(ParkingNotificationSubscriber.NOTFN_PARKING_AVAILABLE);
        }
        return isUnParked;
    }

    public void addSubscriberForNotifications(ParkingNotificationSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    private void notifySubscribers(String message){
        subscribers.stream().forEach(s -> s.notify(this, message));
    }

    private long getCountOfParkedCars() {
        return parkingSpotList.stream().filter(s->!s.isEmpty()).count();
    }

    private ParkingSpot getVehicleParkingSpotFromParkingLot(Vehicle vehicle) throws VehicleNotFoundException {
        Optional<ParkingSpot> optParkingSpot = parkingSpotList.stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> s.getParkedCar().equals(vehicle))
                .findFirst();
        if (optParkingSpot.isEmpty()) {
            throw new VehicleNotFoundException("Car could not be located in the Parking spots");
        }
        return optParkingSpot.get();
    }

    public boolean isVehiclePresentInParkingLot(Vehicle vehicle){
        try {
            getVehicleParkingSpotFromParkingLot(vehicle);
            return true;
        } catch (VehicleNotFoundException e) {
            return false;
        }
    }
}
