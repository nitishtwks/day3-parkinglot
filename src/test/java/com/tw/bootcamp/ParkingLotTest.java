package com.tw.bootcamp;

import com.tw.bootcamp.model.ParkingLot;
import com.tw.bootcamp.model.ParkingSpot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    @Test
    void shouldParkVehicle(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingSpot spot = parkingLot.getEmptyParkingSpot();
        assertTrue(spot.parkVehicle());
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
        assertThrows(IllegalStateException.class, () -> spot.removeVehicle());
    }
}
