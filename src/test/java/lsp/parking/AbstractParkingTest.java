package lsp.parking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractParkingTest {
    private AbstractParking abstractParking;

    @BeforeEach
    void setUp() {
        abstractParking = new AbstractParking() {
            {
                passengerCars = new ArrayList<>(Collections.nCopies(3, null));
                truckCars = new ArrayList<>(Collections.nCopies(2, null));
            }
        };
    }

    @Test
    public void whenPassengerCarIsAccepted() {
        Car car = new Car("Audi", "passengerCar", 1);
        Car car1 = new Car("BMW", "passengerCar", 1);
        Car car2 = new Car("Toyota", "passengerCar", 1);
        abstractParking.add(car);
        abstractParking.add(car1);
        abstractParking.add(car2);
        assertTrue(abstractParking.findAll().contains(car));
        assertTrue(abstractParking.findAll().contains(car1));
        assertTrue(abstractParking.findAll().contains(car2));
    }

    @Test
    public void whenPassengerCarIsNotAccepted() {
        Car car = new Car("Audi", "passengerCar", 1);
        Car car1 = new Car("BMW", "passengerCar", 1);
        Car car2 = new Car("Toyota", "passengerCar", 1);
        Car car3 = new Car("Fiat", "passengerCar", 1);
        abstractParking.add(car);
        abstractParking.add(car1);
        abstractParking.add(car2);
        assertTrue(abstractParking.findAll().contains(car));
        assertTrue(abstractParking.findAll().contains(car1));
        assertTrue(abstractParking.findAll().contains(car2));
        assertFalse(abstractParking.findAll().contains(car3));
    }

    @Test
    public void whenTruckCarIsAccepted() {
        Car car = new Car("Kamaz", "truckCar", 2);
        abstractParking.add(car);
        assertTrue(abstractParking.findAll().contains(car));
    }

    @Test
    public void whenTruckCarIsNotAccepted() {
        Car car = new Car("Audi", "passengerCar", 1);
        Car car1 = new Car("BMW", "passengerCar", 1);
        Car car2 = new Car("Toyota", "passengerCar", 1);
        Car car3 = new Car("Kamaz", "truckCar", 2);
        Car car4 = new Car("Maz", "truckCar", 2);
        assertTrue(abstractParking.findAll().contains(car));
        assertTrue(abstractParking.findAll().contains(car1));
        assertTrue(abstractParking.findAll().contains(car2));
        assertTrue(abstractParking.findAll().contains(car3));
        assertFalse(abstractParking.findAll().contains(car4));
    }

    @Test
    public void whenTruckCarIsAcceptedOnThePassengerCarsParking() {
        Car car = new Car("Audi", "passengerCar", 1);
        Car car1 = new Car("Kamaz", "truckCar", 2);
        Car car2 = new Car("Maz", "truckCar", 2);
        assertTrue(abstractParking.findAll().contains(car));
        assertTrue(abstractParking.findAll().contains(car1));
        assertTrue(abstractParking.findAll().contains(car2));
    }
}