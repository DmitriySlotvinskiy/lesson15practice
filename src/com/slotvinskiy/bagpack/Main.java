// Программа создает рюкзак (мах 15кг),
// генерирует список продуктов,
// сортирует список продуктов два раза:
// первый раз от самого тяжелого продукта к самому легкому, второй - от самого дорого продукта на 1 кг к самому дешевому
// получается что в начале списка оказываются самые дорогие и самые тяжелые,
// т.е. если есть продукт №1 - 8 кг, цена за кг 10грн/кг, и продукт №2 - 5 кг, цена за кг 10грн/кг(така я же),
// то в рюкзак сначала ложим продукт №1. Таким образом в дальнейшем проще добрать рюкзак менее тяжелыми продуктами до
// максимального веса.
// После сортировки наполняем отсортированым списком рюкзак, до тех пор пока не наткнёмся на элемент который не влазит.
// После этого метод начнет поиск продукта который влезет, если такой есть.

package com.slotvinskiy.bagpack;

import java.util.*;

public class Main {

    public static final int SIZE = 10;
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Backpack backpack = new Backpack();
        System.out.println(backpack);
        List<Product> productList = new ArrayList<>();
        generateProductList(productList);
        sortByWeightFromMaxToMin(productList);
        sortByValuePerWeightFromMaxToMin(productList);
        printProductsList(productList);
        fillBackpack(backpack, productList);
        backpack.showProducts();
    }

    private static void fillBackpack(Backpack backpack, List<Product> productList) {

        for (Product product :
                productList) {
            if (backpack.getRestWeight() >= product.getWeight()) {
                backpack.add(product);
            } else if (backpack.getRestWeight() == 0) {
                break;
            } else {
                findAndAddProductByWeight(backpack, productList);
            }
        }
    }

    private static void findAndAddProductByWeight(Backpack backpack, List<Product> productList) {
        for (Product product :
                productList) {
            if (product.getWeight() <= backpack.getRestWeight()) {
                backpack.add(product);
                if (backpack.getRestWeight() == 0) {
                    break;
                }
            }
        }
    }

    private static void printProductsList(List<Product> productList) {
        System.out.println("Product list:");
        int counter = 0;
        for (Product product :
                productList) {
            counter++;
            System.out.println(counter + " - " + product);
        }
    }

    private static void sortByValuePerWeightFromMaxToMin(List<Product> productList) {
        productList.sort(new Comparator<>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) (p2.getValuePerWeight() * 100 - p1.getValuePerWeight() * 100);
            }
        });
    }

    private static void sortByWeightFromMaxToMin(List<Product> productList) {
        productList.sort(new Comparator<>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p2.getWeight() - p1.getWeight();
            }
        });
    }

    private static void generateProductList(List<Product> list) {
        for (int i = 0; i < SIZE; i++) {
            int someWeight = RANDOM.nextInt(10) + 1;
            int someValue = RANDOM.nextInt(10) + 1;
            Product someProduct = new Product(someValue, someWeight);
            list.add(someProduct);
        }
    }
}
