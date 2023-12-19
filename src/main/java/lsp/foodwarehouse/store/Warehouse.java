package lsp.foodwarehouse.store;

public class Warehouse extends AbstractStore {
    @Override
    public boolean acceptFood (String status) {
        boolean rsl;
        rsl = "Fresh".equals(status);
        return rsl;
    }
}
