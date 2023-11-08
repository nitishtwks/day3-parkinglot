package com.tw.bootcamp.exception;

public class ParkingSpotEmptyException extends RuntimeException {
    public ParkingSpotEmptyException(String message) {
        super(message);
    }
}
