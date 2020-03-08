/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import classes.Account;
import classes.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author George.Giazitzis
 */
public class FileManager {
    
    public static void loadFile(String file,Account acc) {
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))) {
            Account newAccount = (Account) read.readObject();
            importAccount(newAccount, acc);
            System.out.println("Purchases were loaded!");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    private static void importAccount(Account from, Account to) {
        to.clear();
        to.addToIncome(from.getBalance());
        from.getAccount().forEach(p -> to.getAccount().add(new Product(p)));       
    }

    public static void saveFile(String path,Account acc) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(path,false))) {
            new File(path).createNewFile();
            write.writeObject(acc);
            System.out.println("Purchases were saved!");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
