package com.tw.bootcamp;

import com.tw.bootcamp.model.Car;
import com.tw.bootcamp.model.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    @Test
    void shouldParkVehicle(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car("001");
        assertTrue(parkingLot.parkVehicle(car1));
    }

    @Test
    void shouldParkMultipleVehicles(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car("001");
        Car car2 = new Car("002");
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
    }

    @Test
    void shouldNotParkVehicleWhenCapacityFull(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car("001");
        Car car2 = new Car("002");
        parkingLot.parkVehicle(car1);
        assertThrows(IllegalStateException.class, () -> parkingLot.parkVehicle(car2));
    }

    @Test
    void shouldUnparkVehicle() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car("001");
        parkingLot.parkVehicle(car1);
        assertTrue(parkingLot.unparkVehicle(car1));

    }

}
