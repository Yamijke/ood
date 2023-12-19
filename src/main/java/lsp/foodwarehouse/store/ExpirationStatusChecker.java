package lsp.foodwarehouse.store;

import lsp.foodwarehouse.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ExpirationStatusChecker {
    public String checkStatusOfExpirationDate(Food food) {
        String rsl;
        long totalLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long remainTime = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        if (remainTime > totalLife * 0.75) {
            rsl = "Fresh";
        } else if (remainTime >= 0 && remainTime <= totalLife * 0.75) {
            rsl = "Middle";
        } else {
            rsl = "Old";
        }
        return rsl;
    }
}
