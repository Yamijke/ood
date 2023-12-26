package lsp.foodwarehouse;

import lsp.foodwarehouse.store.ExpirationStrategy;
import lsp.foodwarehouse.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private ExpirationStrategy expirationStrategy;
    private List<Store> storeList;

    public ControlQuality(ExpirationStrategy expirationStrategy, List<Store> storeList) {
        this.expirationStrategy = expirationStrategy;
        this.storeList = storeList;
    }

    public void chosePlace(Food food) {
        expirationStrategy.choose(food);
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : storeList) {
            foods.addAll(store.findAll());
            store.removeAll();
        }
        for (Food foodToPlace : foods) {
            chosePlace(foodToPlace);
        }
    }
}
