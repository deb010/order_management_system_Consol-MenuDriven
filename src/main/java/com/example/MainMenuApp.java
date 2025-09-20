package com.example;

import com.example.entity.Item;
import com.example.service.impl.Order;
import com.example.sort.SortByName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenuApp {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        int choice;

        do{
            IO.println("==".repeat(10)+ " ORDER MANAGEMENT MENU " +"==".repeat(10));
            IO.println("1. Add Item");
            IO.println("2. View All Items");
            IO.println("3. Update Item");
            IO.println("4. Delete Item");
            IO.println("5. Search Item by Name");
            IO.println("6. Sort Item by Name");
            IO.println("7. Sort Item by Price");
            IO.println("0. Exit");

            IO.println("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        IO.println("Enter Item ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        IO.println("Enter Item Name : ");
                        String name = sc.nextLine();
                        IO.println("Enter Item Price : ");
                        double price = sc.nextDouble();
                        order.addItem(new Item(id,name,price));
                        IO.println("Item Added Successfully");
                        break;

                    case 2:
                        IO.println("<--------- All Items ---------->");
                        order.viewItem();
                        break;

                    case 3:
                        IO.println("Enter Item ID to update : ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        IO.println("Enter new Item Name : ");
                        String newName = sc.nextLine();
                        IO.println("Enter new Item Price : ");
                        double newPrice = sc.nextDouble();
                        order.updateItem(uid,newName,newPrice);
                        IO.println("Item Updated Successfully");
                        break;

                    case 4:
                        IO.println("Enter Item ID to delete : ");
                        int did = sc.nextInt();
                        order.deleteItem(did);
                        IO.println("Item Deleted Successfully");
                        break;

                    case 5:
                        IO.println("Enter Item Name to search : ");
                        String sname = sc.nextLine();
                        Item found =  order.searchItem(sname);
                        IO.println("Item Found Successfully");
                        IO.println("Found: "+found);
                        break;

                    case 6:
                        IO.println("Item sorted by name : ");
                        List<Item> listByName = new ArrayList<>(order.getAllItems());
                        listByName.sort(new SortByName());
                        listByName.forEach(System.out::println);
                        IO.println("Item Sorted by Name Successfully !! ");
                        break;

                    case 7:
                        IO.println("Item sorted by Price : ");
                        List<Item> listByPrice = new ArrayList<>(order.getAllItems());
                        listByPrice.sort(new SortByName());
                        listByPrice.forEach(System.out::println);
                        IO.println("Item Sorted by Price Successfully !! ");
                        break;

                    case 0:
                        IO.println("============= Exiting Application ============");
                        break;

                    default:
                        IO.println("Invalid choice...!!");
                }
            } catch (Exception e) {
                IO.println("Error : "+e.getMessage());
            }
        }
        while (choice != 0);
        sc.close();

    }
}
