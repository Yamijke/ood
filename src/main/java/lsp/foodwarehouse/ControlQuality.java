package lsp.foodwarehouse;

import lsp.foodwarehouse.store.ExpirationStatusChecker;
import lsp.foodwarehouse.store.Store;
import java.util.List;

public class ControlQuality {
    ExpirationStatusChecker statusChecker = new ExpirationStatusChecker();
    private List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void chosePlace(Food food) {
        String status = statusChecker.checkStatusOfExpirationDate(food);
        for (Store store: storeList) {
            if (store.acceptFood(status)) {
                store.add(food);
                break;
            }
        }
    }
}
