package com.example.sort;

import com.example.entity.Item;

import java.util.Comparator;

public class SortByName implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getItemName().compareToIgnoreCase(o2.getItemName());
    }
}
