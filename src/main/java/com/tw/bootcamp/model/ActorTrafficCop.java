package com.tw.bootcamp.model;

public class ActorOwner implements ParkingNotificationSubscriber{
    @Override
    public void notify(String message) {
        System.out.println("Owner notified. Msg: "+message);
    }
}
