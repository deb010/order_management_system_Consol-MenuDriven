package com.example;

import com.example.entity.Item;
import com.example.service.impl.Order;
import com.example.sort.SortByName;
import com.example.sort.SortByPrice;
import java.util.ArrayList;
import java.util.List;

public class OrderManagementSystemApplication {

    static void main() {

        try {
            Order  order = new Order();
            order.addItem(new Item(101,"Pen",20));
            order.addItem(new Item(102,"Notebook",50));
            order.addItem(new Item(103,"Pencil",10));
            order.addItem(new Item(104,"Paper",10));
            order.addItem(new Item(105,"Canvas",100));

            IO.println("-".repeat(10) + " ALL ITEMS " + "-".repeat(10));
            order.viewItem();

            IO.println("-".repeat(10)+ " SEARCH ITEMS BY NAME [PEN] " +"-".repeat(10));
            IO.println(order.searchItem("Pen"));

            IO.println("-".repeat(10)+ " UPDATE ITEMS BY ID [ID 101] " +"-".repeat(10));
            order.updateItem(101,"Markar",25);
            order.viewItem();

            IO.println("-".repeat(10)+ " DELETE ITEMS BY ID [ID 103] " +"-".repeat(10));
            order.deleteItem(103);
            order.viewItem();

            IO.println("-".repeat(10)+ " SORT ITEMS BY NAME " +"-".repeat(10));
            List<Item> listByName = new ArrayList<>(order.getAllItems());
            listByName.sort(new SortByName());
            listByName.forEach(System.out::println);

            IO.println("-".repeat(10)+ " SORT ITEMS BY PRICE " +"-".repeat(10));
            List<Item> listByPrice = new ArrayList<>(order.getAllItems());
            listByPrice.sort(new SortByPrice());
            listByPrice.forEach(System.out::println);




        } catch (Exception e) {
           IO.println("ERROR: " + e.getMessage());
        }

    }

}
