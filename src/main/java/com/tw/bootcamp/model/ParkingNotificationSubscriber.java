package com.tw.bootcamp.model;

public interface ParkingNotificationSubscriber {
    String NOTFN_PARKING_LOT_FULL = "Parking lot is full";
    String NOTFN_PARKING_AVAILABLE = "Parking lot is available";
    void notify(ParkingLot fromParkingLot, String message);
}
