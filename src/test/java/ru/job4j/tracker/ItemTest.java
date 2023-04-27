package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
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
        assertEquals(expected, items);
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
        assertEquals(expected, items);
    }
}