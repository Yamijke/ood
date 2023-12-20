package lsp.parking;

import java.util.List;

public interface Parking {

    void add(Car car);

    void remove(Car car);

    List<Car> findAll();

    boolean acceptParkingPassengerCar(String status);

    boolean acceptParkingTruckCar(String status);
}
