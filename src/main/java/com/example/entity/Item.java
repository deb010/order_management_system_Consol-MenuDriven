package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Item {

    private int itemId;
    private String itemName;
    private double price;

    @Override
    public String toString(){
        return "[" +  itemId + " - " + itemName + " - $" + price + "]";
    }

    @Override
    public int hashCode(){
        return itemId;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        return this.itemId == other.itemId;

    }
}
