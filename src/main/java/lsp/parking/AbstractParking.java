package lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class AbstractParking implements Parking {
    protected ArrayList<Car> passengerCars;
    protected ArrayList<Car> truckCars;

    @Override
    public void add(Car car) {

    }

    @Override
    public void remove(Car car) {

    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public boolean acceptParkingPassengerCar(String status) {
        return false;
    }

    @Override
    public boolean acceptParkingTruckCar(String status) {
        return false;
    }
}
