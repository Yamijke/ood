package lsp.foodwarehouse.store;

import lsp.foodwarehouse.ControlQuality;
import lsp.foodwarehouse.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private AbstractStore warehouse;
    private AbstractStore shop;
    private AbstractStore trash;
    private ControlQuality controlQuality;
    private Food cheese;
    private Food cheese2;
    private Food fish;
    List<Store> list = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        list.add(warehouse);
        list.add(shop);
        list.add(trash);
        controlQuality = new ControlQuality(list);
        cheese = new Food("Cheese",
                LocalDate.of(2023, 12, 15),
                LocalDate.of(2024, 2, 15),
                100,
                20);
        cheese2 = new Food("Cheese2",
                LocalDate.of(2023, 12, 15),
                LocalDate.of(2024, 3, 30),
                100,
                20);
        fish = new Food("Fish",
                LocalDate.of(2023, 11, 30),
                LocalDate.of(2023, 12, 23),
                100,
                50);
        controlQuality.chosePlace(cheese);
        controlQuality.chosePlace(cheese2);
        controlQuality.chosePlace(fish);
    }

    @Test
    public void whenCheeseIsGoingToWarehouse() {
        assertTrue(warehouse.findAll().contains(cheese));
        assertTrue(warehouse.findAll().contains(cheese2));
        assertFalse(warehouse.findAll().contains(fish));
    }
}