package com.tw.bootcamp.exception;

public class ParkingSpotOccupiedException extends RuntimeException {
    public ParkingSpotOccupiedException(String message) {
        super(message);
    }
}
