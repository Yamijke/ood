package lsp.foodwarehouse.store;

import lsp.foodwarehouse.Food;

public class ExpirationStrategy implements ChooseStoreStrategy {

    private AbstractStore warehouse;
    private AbstractStore shop;
    private AbstractStore trash;

    public ExpirationStrategy(AbstractStore warehouse, AbstractStore shop, AbstractStore trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    @Override
    public void choose(Food food) {
        String status = new ExpirationStatusChecker().checkStatusOfExpirationDate(food);
        if ("Fresh".equals(status)) {
            warehouse.add(food);
        } else if ("Middle".equals(status)) {
            shop.add(food);
        } else if ("Old".equals(status)) {
            trash.add(food);
        }
    }
}
