/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author George.Giazitzis
 */
public class Product implements Serializable, Comparable<Product> {

    private final String name;
    private final double price;
    private final Category category;
    private static final long serialversionUID = 3286228943957126343L;
    
    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.category.addSum(price);
    }
    
    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
        this.category = product.category;
        this.category.addSum(product.price);
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public Category getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
        return String.format("%s $%.2f", name, price);
    }
    
    @Override
    public int compareTo(Product product) {
        if (this.price < product.price) {
            return 1;
        }
        if (this.price > product.price) {
            return -1;
        }
        return 0;
    }
}
