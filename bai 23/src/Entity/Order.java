package Entity;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antis
 */
public class Order {

    private ArrayList<Fruit> listFruit = new ArrayList();

    private String customerName;


    public Order() {
    }

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public void setListFruit(ArrayList<Fruit> listFruit) {
        this.listFruit = listFruit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    

    public void viewOrder(List<Order> listOrder) {
        if (listOrder.isEmpty()) {
            System.out.println("No orders have been placed yet.");
            return;
        }

        for (Order i : listOrder) {
            System.out.println("Customer: " + i.getCustomerName());
            System.out.printf("%-12s %-10s %-10s %-15s\n","Product ","| Quantity ","| Price ","| Amount");
            double totalAmount = 0;
            for (Fruit o : i.getListFruit()) {
                o.viewFruit();
                totalAmount += o.getAmount();

            }
            System.out.println("Total: " + totalAmount + "$");
        }
    }
}

//    public void viewOrderFix(List<Order> listOrder, String customerName) {
//        if (listOrder.isEmpty()) {
//
//            System.out.println("No orders have been placed yet.");
//            return;
//        }
//        System.out.println("Customer: " + customerName);
//        System.out.println("Product | Quantity | Price | Amount");
//        double totalAmount = 0;
//        for (Order o : listOrder) {
//
//            System.out.println(o.getFruitName() + " | " + o.getQuantity() + " | " + o.getPrice() + "$ | " + o.getAmount() + "$");
//            totalAmount += o.amount;
//
//        }
//        System.out.println("Total: " + totalAmount + "$");
//
//    }
//}
