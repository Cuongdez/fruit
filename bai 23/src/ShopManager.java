
import Entity.Fruit;
import Entity.Order;
import java.util.ArrayList;
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
public class ShopManager {

    ArrayList<Order> orderList;
    ArrayList<Fruit> fruitList;

    public ShopManager() {
        this.orderList = new ArrayList();
        this.fruitList = new ArrayList();

    }

    public void testFruitData() {
        fruitList.add(new Fruit(1, "chuoi", 10000, 10, "VietNam"));
        fruitList.add(new Fruit(2, "tao", 15000, 2, "My"));
        fruitList.add(new Fruit(3, "cam", 20000, 9, "Thai"));
        fruitList.add(new Fruit(4, "oi", 13000, 15, "Thai"));
        fruitList.add(new Fruit(5, "le", 25000, 6, "VietNam"));
    }

    public void menu() {
        this.testFruitData();
        Order vo = new Order();
        Fruit cf = new Fruit();

        boolean loop = true;
        while (loop) {

            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1.Create Fruit");
            System.out.println("2.View orders");
            System.out.println("3.Shopping (for buyer)");
            System.out.println("4.Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
//            ShopManager manager = new ShopManager();
                case 1:
                    cf.createFruit(fruitList);
                    break;
                case 2:
                    vo.viewOrder(orderList);
                    break;
                case 3:
                    this.shopping();
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Enter number 1-4 ");
                    System.err.println("Enter Again !!");
                    break;

            }

        }

    }

    public void shopping() {
        Scanner scanner = new Scanner(System.in); 
        boolean isNew = true;
        String customerName = "";
        Order order = new Order();
        boolean oldOrderlist;
        while (true) {
            // Create a new order object

            // Display list of fruits with their details
            System.out.println("List of Fruits:");
            System.out.printf("%-10s %-20s %-20s %-20s %-15s %-15s\n","| ++ Item ++ ","| ++ Fruit Name ++ ","| ++ Origin ++ ","| ++ Price ++ ","|++ Quantity ++ ","|++ Amount ++");
            fruitList.forEach(fruit -> {
                fruit.printFruit();

            });
            System.out.print("You selected: ");
            String fruitName = scanner.next();

            // Find the selected fruit from the list
            Fruit selectedFruit = null;
            for (Fruit fruit : fruitList) {
                if (fruit.getFruitName().equalsIgnoreCase(fruitName)) {
                    selectedFruit = fruit;
                    break;
                }
            }

            // If fruit is not found, prompt the user to try again
            if (selectedFruit == null) {
                System.out.println("Fruit not found. Please try again.");
                continue;
            }
            //
            // Ask for the quantity of the selected fruit
            System.out.print("Please input quantity: ");
            int quantity = scanner.nextInt(); // Check if there is enough stock available
            if (quantity > selectedFruit.getQuantity()) {
                //quantity = 0 an di
                System.out.println("Not enough stock available.");
                continue;
            }

            // Calculate the total amount for the order
            double totalAmountForFruit = selectedFruit.getPrice() * quantity;

            // Display the order details
            System.out.printf("%-10s %-20s %-20s %-15s\n","Product","| Quantity ","| Price ","| Amount");
            System.out.printf("%-12s %-20s %-20s %-15s\n",selectedFruit.getFruitName(), quantity, selectedFruit.getPrice(), totalAmountForFruit);

            // Ask for the customer's name and finalize the order
            

            // Set order details
            int idx;
            Fruit sf = new Fruit();
//            if (!isNew) {

            idx = sf.findById(order.getListFruit(), selectedFruit.getFruitId());
            if (idx != -1) {
                sf = order.getListFruit().get(idx);
                sf.setQuantity(quantity + sf.getQuantity());
            } else {
                sf = new Fruit(selectedFruit.getFruitId(), fruitName, selectedFruit.getPrice(), quantity, selectedFruit.getOrigin());
                order.getListFruit().add(sf);
            }
            //double amount,int fruitId, String fruitName, double price, int quantity, String origin
//            order.getListFruit().setFruitName(selectedFruit.getFruitName());
//            order.setQuantity(quantity);
//            order.setAmount(totalAmountForFruit);
// Set the calculated amount
            // Add the order to the list of orders

            // Update the stock for the selected fruit
            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

            // Display the total amount for the order
            System.out.println("Total : " + totalAmountForFruit + "$");
            System.out.println("continue ? Y/N");
            orderList.add(order);
            String choice = scanner.next().trim();
            if (choice.equalsIgnoreCase("N")) {
                if (isNew) {
                System.out.print("Input your name: ");
                customerName = scanner.next();
                order.setCustomerName(customerName);
            }
                orderList.add(order);
                break;
            } else {
                isNew = false;

            }
        }
    }

}
