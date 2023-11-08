package com.tw.bootcamp.model;

public class ActorTrafficCop implements ParkingNotificationSubscriber{
    @Override
    public void notify(String message) {
        System.out.println("**** Traffic Cop notified. Msg: "+message);
    }
}
