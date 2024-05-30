package ru.gb.vending;

import ru.gb.vending.product.Bottle;
import ru.gb.vending.product.Product;
import ru.gb.vending.vending.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product product1 = new Product("Twix", 60);
        Product product2 = new Bottle("Coca-cola", 80, 2);
        Product product3 = new Product("Lays", 100);

        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(product3);

        System.out.println(vendingMachine);



    }
}
