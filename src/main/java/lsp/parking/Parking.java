package lsp.parking;

import java.util.List;

public interface Parking {

    void add(Car car);

    void remove(Car car);

    List<Car> findAll();
}
