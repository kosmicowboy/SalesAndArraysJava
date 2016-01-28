/***********************************************************
 // Assignment :  Program Sales and Arrays
 // by: Kyle Gray
 // Date: 1 / 25 / 2016
 // Description: Allow user to make purchases from your .csv loaded inventory
 //  Notes:
 //***********************************************************
 //************************************************************
 */

import java.util.Scanner;

public class MailOrderTest {





    public static void main(String[] args) {

        MailOrders orders = new MailOrders();
        Scanner input = new Scanner(System.in);
        String product = "";
        String quantity;

        System.out.println("Welcome to MailOrder and MyInventory storefront! As the user, you can make purchases from my inventory\n");
        System.out.println("Here's what I have in stock:\n");
        orders.fillInventory();

        String sales_rep = "\nPlease enter the next product number to buy or -99 = end\n";
        String out_of_stock = "This item is out of stock. Or you have entered an invalid product number. Please pick another one.";

        double order_total = 0.0;

        boolean flag = true;

        while(flag) {
            System.out.println(sales_rep);
            product = input.next();
            if (product.equals("-99")) {
                break;
            }
            MyInventory item = orders.getInventoryItem(Integer.parseInt(product));
            if (item == null) {
                System.out.println(out_of_stock);
            } else {

                System.out.println("Unit Price: " + item.getPrice() + "\n" +
                        "Current Quantity Available: " + item.getQty() + "\n" +
                        "How many would you like to order?");
                quantity = input.next();

                int sold = orders.processOrder(Integer.parseInt(product), Integer.parseInt(quantity));
                System.out.println("Quantity sold: " + sold);
                double item_amount = item.getPrice() * sold;
                System.out.println("Item Amount: $" + item_amount);
                order_total += item_amount;
                System.out.println("Order amount total: $" + order_total);

            }
        }

        System.out.println("Order amount total: $" + order_total + "\nBye");
    }

}

///////////////////////////////////////////////////////////////////
///   End Of File
///////////////////////////////////////////////////////////////////
