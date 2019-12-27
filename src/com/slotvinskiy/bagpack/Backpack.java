package com.slotvinskiy.bagpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final int MAX_WEIGHT = 15;
    private int value = 0;
    private int totalWeight = 0;
    private List<Product> products = new ArrayList<>();


    public int getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void add(Product product) {
        this.products.add(product);
        this.totalWeight += product.getWeight();
    }

    public void delete(Product product) {
        this.products.remove(product);
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public int getTotalValue() {
        int totalValue = 0;
        for (Product product :
                products) {
            totalValue += product.getValue();
        }
        return totalValue;
    }

    public int getRestWeight() {
        return MAX_WEIGHT - this.totalWeight;
    }

    public void showProducts() {
        System.out.println("Products in backpack");
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("Backpacks total weight is: " + this.getTotalWeight() + ", total value is: " + this.getTotalValue());
    }

    @Override
    public String toString() {
        return "BagPack{" +
                "total weight=" + totalWeight +
                ", value=" + value +
                ", products=" + products +
                '}';
    }
}
