package Entity;

import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antis
 */
public class Fruit {

    private int fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(int fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getAmount() {
        return this.price * this.quantity;
    }

    public int findById(List<Fruit> list, int id) {
        int find = 0;
        for (Fruit i : list) {
            if (i.getFruitId() == id) {
                return find;
            }
            find++;
        }

        return -1;

    }

    public void createFruit(List<Fruit> list) {
        String choice;
            int quantity;
            Scanner scanner = new Scanner(System.in);
        while (true) {
            
            System.out.print("Enter fruit id:");
            int fruitId = scanner.nextInt();
            int idx = findById(list, fruitId);
            if (idx != -1) {
                Fruit fruitc = list.get(idx);
                fruitc.printFruit();
                System.out.println("Update Y/N");
                choice = scanner.next();
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
                System.out.println("Input number of quantity: ");
                quantity = scanner.nextInt();
                fruitc.setQuantity(quantity + fruitc.getQuantity());
                fruitc.printFruit();
                System.out.println("Do you want to continue update Y/N");
                choice = scanner.next();
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            } else {
                System.out.print("\nEnter fruit name: ");
                String fruitName = scanner.next();
                System.out.print("\nEnter price: ");
                double price = scanner.nextDouble();
                System.out.print("\nEnter quantity: ");
                quantity = scanner.nextInt();
                System.out.print("\nEnter origin: ");
                String origin = scanner.next();
                list.add(new Fruit(fruitId, fruitName, price, quantity, origin));
                System.out.println("continue ? Y/N");
                choice = scanner.next();
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
        
    }

    public void printFruit() {
        System.out.printf("%-15s %-20s %-20s %-20s %-15s %-10s\n",this.getFruitId() , this.getFruitName() ,  this.getOrigin() ,this.getPrice() + "$ ",  this.quantity, this.getAmount()+ "$ ");
    }

    public void viewFruit() {
        System.out.printf("%-14s %-11s %-10s %-15s\n",this.fruitName , this.getQuantity() , this.price , this.getAmount());
    }
}
