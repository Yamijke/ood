package lsp.foodwarehouse.store;

import lsp.foodwarehouse.Food;

public interface ChooseStoreStrategy {
    void choose(Food food);
}
