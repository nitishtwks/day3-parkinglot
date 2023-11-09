package com.tw.bootcamp;

import com.tw.bootcamp.exception.ParkingLotFullException;
import com.tw.bootcamp.exception.VehicleNotFoundException;
import com.tw.bootcamp.model.ActorOwner;
import com.tw.bootcamp.model.ActorTrafficCop;
import com.tw.bootcamp.model.Vehicle;
import com.tw.bootcamp.model.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    @Test
    void shouldParkVehicle() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle1 = new Vehicle("001");
        assertTrue(parkingLot.parkVehicle(vehicle1));
    }

    @Test
    void shouldParkMultipleVehicles() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle1 = new Vehicle("001");
        Vehicle vehicle2 = new Vehicle("002");
        parkingLot.parkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);
    }

    @Test
    void shouldUnparkVehicle() throws ParkingLotFullException, VehicleNotFoundException {
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle1 = new Vehicle("001");
        parkingLot.parkVehicle(vehicle1);
        assertTrue(parkingLot.unparkVehicle(vehicle1));
    }

    @Test
    void shouldNotParkVehicleWhenCapacityFull() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle1 = new Vehicle("001");
        Vehicle vehicle2 = new Vehicle("002");
        parkingLot.parkVehicle(vehicle1);
        assertThrows(ParkingLotFullException.class, () -> parkingLot.parkVehicle(vehicle2));
    }

    @Test
    void shouldNotifyWhenCapacityFull() throws ParkingLotFullException {
        ActorOwner actorOwner = new ActorOwner();
        ActorTrafficCop actorTrafficCop = new ActorTrafficCop();

        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.addSubscriberForNotifications(actorOwner);
        parkingLot.addSubscriberForNotifications(actorTrafficCop);

        Vehicle vehicle1 = new Vehicle("001");
        Vehicle vehicle2 = new Vehicle("002");
        parkingLot.parkVehicle(vehicle1);
        assertThrows(ParkingLotFullException.class, () -> parkingLot.parkVehicle(vehicle2));
    }

    @Test
    void shouldNotifyWhenParkingSlotAvailableAgain() throws ParkingLotFullException, VehicleNotFoundException {
        ActorOwner actorOwner = new ActorOwner();
        ActorTrafficCop actorTrafficCop = new ActorTrafficCop();

        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.addSubscriberForNotifications(actorOwner);
        parkingLot.addSubscriberForNotifications(actorTrafficCop);

        Vehicle vehicle1 = new Vehicle("001");
        Vehicle vehicle2 = new Vehicle("002");
        parkingLot.parkVehicle(vehicle1);
        assertThrows(ParkingLotFullException.class, () -> parkingLot.parkVehicle(vehicle2));
        parkingLot.unparkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);
    }
}
