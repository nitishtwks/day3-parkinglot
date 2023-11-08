package com.tw.bootcamp;

import com.tw.bootcamp.model.ParkingLot;
import com.tw.bootcamp.model.ParkingSpot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void shouldParkVehicle(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingSpot spot = parkingLot.getEmptyParkingSpot();
        assertTrue(spot.parkVehicle());
    }

    @Test
    void shouldThrowExeptionIfVehicleParkedInOccupiedSpot(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingSpot spot = parkingLot.getEmptyParkingSpot();
        spot.parkVehicle();
        assertThrows(IllegalStateException.class, () -> spot.parkVehicle());
    }

    @Test
    void shouldRemoveVehicle(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingSpot spot = parkingLot.getEmptyParkingSpot();
        spot.parkVehicle();
        assertTrue(spot.removeVehicle());
    }

    @Test
    void shouldRemoveVehicleWhenEmpty(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingSpot spot = parkingLot.getEmptyParkingSpot();
        assertFalse(spot.removeVehicle());
    }
}
