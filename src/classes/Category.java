/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author George.Giazitzis
 */
public enum Category {
    FOOD("Food", 0.0),
    CLOTHES("Clothes", 0.0),
    ENTERTAINMENT("Entertainment", 0.0),
    OTHER("Other", 0.0);

    private final String name;
    private double sum;

    Category(String name, double sum) {
        this.name = name;
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void addSum(double sum) {
        this.sum += sum;
    }

    public String getName() {
        return name;
    }
}
