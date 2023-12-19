package lsp.foodwarehouse.store;

import lsp.foodwarehouse.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Shop extends AbstractStore {
    @Override
    public void add(Food food) {
        long totalLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long remainTime = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        if (remainTime <= totalLife * 0.24) {
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount() / 100.0);
        }
        super.add(food);
    }

    @Override
    public boolean acceptFood(String status) {
        boolean rsl;
        rsl = "Middle".equals(status);
        return rsl;
    }
}
