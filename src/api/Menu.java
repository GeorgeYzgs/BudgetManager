/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import classes.Account;
import classes.Category;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author George.Giazitzis
 */
public class Menu {

    private static Scanner sc = new Scanner(System.in);
    private static Account acc = new Account();

    public static void mainMenu() {
        loop:
        do {
            System.out.println("Choose your action:\n"
                    + "1) Add income\n"
                    + "2) Add purchase\n"
                    + "3) Show list of purchases\n"
                    + "4) Balance\n"
                    + "5) Save\n"
                    + "6) Load\n"
                    + "7) Analyze (Sort)\n"
                    + "0) Exit\n");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Enter income:");
                    acc.addToIncome(Double.parseDouble(sc.nextLine()));
                    System.out.println("Income was added!");
                    break;
                case "2":
                    addProductMenu();
                    break loop;
                case "3":
                    showProductsMenu();
                    break loop;
                case "4":
                    System.out.printf("Balance: $%.2f\n", acc.getBalance());
                    break;
                case "5":
                    FileManager.saveFile("purchases.txt", acc);
                    break;
                case "6":
                    FileManager.loadFile("purchases.txt", acc);
                    break;
                case "7":
                    analyze();
                    break loop;
                case "0":
                    System.out.println("Bye!");
                    break loop;
                default:
                    System.out.println("Invalid command, try again!");
            }
            System.out.println();
        } while (true);
    }

    private static void analyze() {
        Collections.sort(acc.getAccount());
        loop:
        do {
            System.out.println("How do you want to sort?\n"
                    + "1) Sort all purchases\n"
                    + "2) Sort by type\n"
                    + "3) Sort certain type\n"
                    + "4) Back\n");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("All");
                    AccountManager.showAllProducts(acc);
                    break;
                case "2":
                    AccountManager.sortPerType(acc);
                    break;
                case "3":
                    chooseType();
                    break;
                case "4":
                    mainMenu();
                    break loop;
                default:
                    System.out.println("Invalid command, try again!");
            }
            System.out.println();
        } while (true);
    }

    private static void chooseType() {
        loop:
        do {
            System.out.println("Choose the type of purchase\n"
                    + "1) Food\n"
                    + "2) Clothes\n"
                    + "3) Entertainment\n"
                    + "4) Other\n");
            switch (sc.nextLine()) {
                case "1":
                    AccountManager.showProducts(Category.FOOD, acc);
                    break loop;
                case "2":
                    AccountManager.showProducts(Category.CLOTHES, acc);
                    break loop;
                case "3":
                    AccountManager.showProducts(Category.ENTERTAINMENT, acc);
                    break loop;
                case "4":
                    AccountManager.showProducts(Category.OTHER, acc);
                    break loop;
                default:
                    System.out.println("Invalid command, try again!");
            }
            System.out.println();
        } while (true);
    }

    private static void addProductMenu() {
        loop:
        do {
            System.out.println("Choose the type of purchase\n"
                    + "1) Food\n"
                    + "2) Clothes\n"
                    + "3) Entertainment\n"
                    + "4) Other\n"
                    + "5) Back\n");
            switch (sc.nextLine()) {
                case "1":
                    AccountManager.addProduct(Category.FOOD, acc);
                    break;
                case "2":
                    AccountManager.addProduct(Category.CLOTHES, acc);
                    break;
                case "3":
                    AccountManager.addProduct(Category.ENTERTAINMENT, acc);
                    break;
                case "4":
                    AccountManager.addProduct(Category.OTHER, acc);
                    break;
                case "5":
                    mainMenu();
                    break loop;
                default:
                    System.out.println("Invalid command, try again!");
            }
            System.out.println();
        } while (true);
    }

    private static void showProductsMenu() {
        loop:
        do {
            System.out.println("Choose the type of purchases\n"
                    + "1) Food\n"
                    + "2) Clothes\n"
                    + "3) Entertainment\n"
                    + "4) Other\n"
                    + "5) All\n"
                    + "6) Back\n");
            switch (sc.nextLine()) {
                case "1":
                    AccountManager.showProducts(Category.FOOD, acc);
                    break;
                case "2":
                    AccountManager.showProducts(Category.CLOTHES, acc);
                    break;
                case "3":
                    AccountManager.showProducts(Category.ENTERTAINMENT, acc);
                    break;
                case "4":
                    AccountManager.showProducts(Category.OTHER, acc);
                    break;
                case "5":
                    AccountManager.showAllProducts(acc);
                    break;
                case "6":
                    mainMenu();
                    break loop;
                default:
                    System.out.println("Invalid command, try again!");
            }
            System.out.println();
        } while (true);
    }

}
