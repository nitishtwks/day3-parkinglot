package com.tw.bootcamp.model;

public class ActorTrafficCop implements ParkingNotificationSubscriber{

    @Override
    public void notify(ParkingLot fromParkingLot, String message) {
        System.out.println("**** Traffic Cop notified. Msg: "+message);
    }
}
