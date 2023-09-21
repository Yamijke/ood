package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class ItemTest {

    private void assertItemEquals(Item expected, Item actual) {
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void whenNameAscendingSorting() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Name2"));
        items.add(new Item("Name1"));
        items.add(new Item("Name3"));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Name1"));
        expected.add(new Item("Name2"));
        expected.add(new Item("Name3"));
        assertThat(items.size()).isEqualTo(expected.size());
        for (int i = 0; i < expected.size(); i++) {
            assertItemEquals(expected.get(i), items.get(i));
        }
    }

    @Test
    public void whenNameDescendingSorting() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Name2"));
        items.add(new Item("Name1"));
        items.add(new Item("Name3"));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Name3"));
        expected.add(new Item("Name2"));
        expected.add(new Item("Name1"));
        assertThat(items.size()).isEqualTo(expected.size());
        for (int i = 0; i < expected.size(); i++) {
            assertItemEquals(expected.get(i), items.get(i));
        }
    }
}