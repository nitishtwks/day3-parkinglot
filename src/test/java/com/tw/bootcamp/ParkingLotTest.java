package com.tw.bootcamp;

import com.tw.bootcamp.model.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    @Test
    void shouldParkVehicle(){
        ParkingLot parkingLot = new ParkingLot();
        assertTrue(parkingLot.parkVehicle());
    }

/*    @Test
    void shouldThrowExeptionIfVehicleParkedInOccupiedSpot(){
        ParkingLot parkingLot = new ParkingLot();
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
    }*/
}
