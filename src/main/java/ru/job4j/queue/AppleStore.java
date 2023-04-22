package ru.job4j.queue;

import java.util.Queue;
import java.util.LinkedList;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String lastHappyCustomerName = null;
        for (int i = 0; i < queue.size(); i++) {
            Customer customer = queue.poll();
            if (i < count) {
                lastHappyCustomerName = customer.name();
            }
            queue.add(customer);
        }
        return lastHappyCustomerName;
    }

    public String getFirstUpsetCustomer() {
        String firstUpsetCustomer = null;
        for (int i = 0; i < queue.size(); i++) {
            Customer customer = queue.poll();
            if (i == count) {
                firstUpsetCustomer = customer.name();
            }
            queue.add(customer);
        }
        return firstUpsetCustomer;
    }
}
