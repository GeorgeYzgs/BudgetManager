/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import classes.*;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author George.Giazitzis
 */
public class AccountManager {

    private static final Scanner sc = new Scanner(System.in);

    public static void sortPerType(Account acc) {
        Map<Double, String> list = new TreeMap<>(Collections.reverseOrder());
        list.put(Category.CLOTHES.getSum(), Category.CLOTHES.getName());
        list.put(Category.ENTERTAINMENT.getSum(), Category.ENTERTAINMENT.getName());
        list.put(Category.FOOD.getSum(), Category.FOOD.getName());
        list.put(Category.OTHER.getSum(), Category.OTHER.getName());
        for (Map.Entry<Double, String> entry : list.entrySet()) {
            if (entry.getKey() != 0) {
                System.out.printf("%s - $%.2f\n", entry.getValue(), entry.getKey());
            }
        }
        double sum = Category.FOOD.getSum() + Category.CLOTHES.getSum()
                + Category.ENTERTAINMENT.getSum() + Category.OTHER.getSum();
        System.out.printf("Total sum: $%.2f\n", sum);
    }

    public static void addProduct(Category type, Account acc) {
        System.out.println("Enter purchase name:");
        String product = sc.nextLine();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(sc.nextLine());
        acc.getAccount().add(new Product(product, price, type));
        System.out.println("Purchase was added!");
        acc.reduceBalance(price);
    }

    public static void showProducts(Category type, Account acc) {
        if (type.getSum() != 0) {
            System.out.println(type.getName() + ":");
            acc.getAccount().stream().filter(p -> p.getCategory().equals(type)).forEach(System.out::println);
            System.out.printf("Total sum: $%.2f\n", type.getSum());
        } else {
            System.out.println("Purchase list is empty");
        }
    }

    public static void showAllProducts(Account acc) {
        if (acc.getAccount().isEmpty()) {
            System.out.println("Purchase list is empty");
            return;
        }
        acc.getAccount().forEach(System.out::println);
        double sum = Category.FOOD.getSum() + Category.CLOTHES.getSum()
                + Category.ENTERTAINMENT.getSum() + Category.OTHER.getSum();
        System.out.printf("Total sum: $%.2f\n", sum);
    }
}
