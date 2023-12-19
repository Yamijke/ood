package lsp.foodwarehouse;

import lsp.foodwarehouse.store.AbstractStore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlQuality {
    private AbstractStore warehouse;
    private AbstractStore shop;
    private AbstractStore trash;

    public ControlQuality(AbstractStore warehouse, AbstractStore shop, AbstractStore trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void chosePlace(Food food) {
        long totalLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long remainTime = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        if (remainTime > totalLife * 0.75) {
            warehouse.add(food);
        } else if (remainTime >= 0 && remainTime <= totalLife * 0.75) {
            shop.add(food);
        } else {
            trash.add(food);
        }
    }
}
