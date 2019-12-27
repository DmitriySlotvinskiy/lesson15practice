package com.slotvinskiy.bagpack;

public class Product {

    private int value;
    private int weight;
    private double valuePerWeight;

    public Product(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.valuePerWeight = (double) value / weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public double getValuePerWeight() {
        return valuePerWeight;
    }


    @Override
    public String toString() {
        return String.format("Product{%s UAH; %s kg; %.2f UAH/kg}", value, weight, valuePerWeight);
    }
}
