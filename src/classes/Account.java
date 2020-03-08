/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George.Giazitzis
 */
public class Account implements Serializable {

    private double balance;
    private List<Product> account;
    private static final long serialversionUID = 129348938L;

    public Account() {
        this.balance = 0;
        this.account = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Product> getAccount() {
        return account;
    }

    public void addToIncome(double price) {
        balance += price;
    }

    public void reduceBalance(double price) {
        balance -= price;
        if (balance < 0) {
            balance = 0;
        }
    }

    public void clear() {
        balance = 0;
        account.clear();
        Category.FOOD.setSum(0.0);
        Category.CLOTHES.setSum(0.0);
        Category.ENTERTAINMENT.setSum(0.0);
        Category.OTHER.setSum(0.0);
    }
}
