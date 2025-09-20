package com.example.service;

import com.example.entity.Item;
import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;

import java.util.Set;

public interface OrderOperation {
    void addItem(Item item) throws DuplicateItemException;
    void viewItem();
    void updateItem(int itemId , String newName , double newPrice) throws ItemNotFoundException;
    void deleteItem(int itemId) throws ItemNotFoundException;
    Item searchItem(String name) throws ItemNotFoundException;
    Set<Item> getAllItems();

}
