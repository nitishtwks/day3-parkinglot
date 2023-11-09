package com.tw.bootcamp;

import com.tw.bootcamp.exception.AllParkingLotsFullException;
import com.tw.bootcamp.exception.ParkingLotFullException;
import com.tw.bootcamp.exception.VehicleNotFoundException;
import com.tw.bootcamp.model.ParkingLot;
import com.tw.bootcamp.model.Valet;
import com.tw.bootcamp.model.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValetTest {

    @Test
    void shouldParkVehicle() throws ParkingLotFullException, AllParkingLotsFullException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot1, parkingLot2);
        Valet valet = new Valet(parkingLotList);

        Vehicle vehicle1 = new Vehicle("001");
        assertTrue(valet.parkVehicle(vehicle1));
    }

    @Test
    void shouldNotParkVehicleWhenCapacityFull() throws ParkingLotFullException, AllParkingLotsFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot);
        Vehicle vehicle1 = new Vehicle("001");
        Vehicle vehicle2 = new Vehicle("002");
        Valet valet = new Valet(parkingLotList);
        valet.parkVehicle(vehicle1);
        assertThrows(AllParkingLotsFullException.class, () -> valet.parkVehicle(vehicle2));
    }

    @Test
    void shouldUnparkVehicle() throws ParkingLotFullException, VehicleNotFoundException, AllParkingLotsFullException {
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot);
        Vehicle vehicle1 = new Vehicle("001");
        Valet valet = new Valet(parkingLotList);
        valet.parkVehicle(vehicle1);
        assertTrue(valet.unparkVehicle(vehicle1));
    }
}
