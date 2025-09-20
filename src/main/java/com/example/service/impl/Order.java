package com.example.service.impl;

import com.example.entity.Item;
import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;
import com.example.service.OrderOperation;

import java.util.HashSet;
import java.util.Set;

public class Order implements OrderOperation {

    private final Set<Item> items = new HashSet<>();
    @Override
    public void addItem(Item item) throws DuplicateItemException {
        if(!items.add(item)){
            throw new DuplicateItemException("Item with ID "+item.getItemId() + " already exists !!");
        }
    }

    @Override
    public void viewItem() {
        if(items.isEmpty()){
            IO.println("There are no items in this order!");
        }
        else {
            for(Item i : items) System.out.println(i);
        }

    }

    @Override
    public void updateItem(int itemId, String newName, double newPrice) throws ItemNotFoundException {

        Item found =null;
        for(Item i : items){
            if(i.getItemId() == itemId){
                found = i;
                break;
            }
        }
        if(found == null){
            throw new ItemNotFoundException("Item not found with ID "+itemId);
        };

        found.setItemName(newName);
        found.setPrice(newPrice);
    }

    @Override
    public void deleteItem(int itemId) throws ItemNotFoundException {
        Item toRemove = null;
        for(Item i : items){
            if(i.getItemId() == itemId){
                toRemove = i;
                break;
            }
        }

        if(toRemove == null){
            throw new ItemNotFoundException("Item not found with ID "+itemId);
        }
        items.remove(toRemove);
    }

    @Override
    public Item searchItem(String name) throws ItemNotFoundException {
        for(Item i : items){
            if(i.getItemName().equalsIgnoreCase(name)){
                return i;
            }
        }
        throw new ItemNotFoundException("Item not found with name "+name);
    }

    @Override
    public Set<Item> getAllItems() {
        return items;
    }
}
