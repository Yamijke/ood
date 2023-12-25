package lsp.foodwarehouse;

import lsp.foodwarehouse.store.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {

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
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2024, 12, 21),
                100,
                20);
        cheese2 = new Food("Cheese2",
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 21),
                100,
                20);
        fish = new Food("Fish",
                LocalDate.of(2023, 11, 30),
                LocalDate.of(2023, 12, 6),
                100,
                20);
        controlQuality.chosePlace(cheese);
        controlQuality.chosePlace(cheese2);
        controlQuality.chosePlace(fish);
    }

    @Test
    @Disabled
    public void whenAllFoodsIsGoingToTheirPlace() {
        assertTrue(warehouse.findAll().contains(cheese));
        assertTrue(shop.findAll().contains(cheese2));
        assertTrue(trash.findAll().contains(fish));
    }
}