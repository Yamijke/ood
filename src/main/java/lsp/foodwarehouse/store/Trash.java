package lsp.foodwarehouse.store;

public class Trash extends AbstractStore {

    @Override
    public boolean acceptFood(String status) {
        boolean rsl;
        rsl = "Old".equals(status);
        return rsl;
    }
}
