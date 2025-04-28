package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class StoreApp {

    public static void main(String[] args){
        List<Product> inventory = getInventory();

        listAllProducts(inventory);

    }


    public static List<Product> getInventory(){
        List<Product> inventory = new ArrayList<>();

       /* inventory.add(new Product(1, "Shirt", 19.99));
        inventory.add(new Product(2, "Shirt", 19.99));
        inventory.add(new Product(3, "Shoes", 19.99));
        inventory.add(new Product(4, "Hat", 19.99));
        inventory.add(new Product(5, "Jacket", 19.99));
*/

        //bonus 1

        
        return inventory;
    }

    public static void listAllProducts(List<Product> productList){
        System.out.println(" We carry the following inventory: ");

        for( Product product: productList){
            System.out.println(product);
        }
    }
}
