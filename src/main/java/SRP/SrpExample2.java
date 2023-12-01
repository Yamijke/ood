package SRP;

import java.util.List;

public class SrpExample2 {
    private List<SrpExample2> orders;

    public void addOrder(SrpExample2 order) {
        orders.add(order);
    }

    public void removeOrder(SrpExample2 order) {
        orders.remove(order);
    }

    //Нарушение принципа SRP, класс должен отвечать за управлением заказами, но занимается и печатью
    public void printOrder(SrpExample2 order) {
        System.out.println("Order Summary: ");
    }
}
