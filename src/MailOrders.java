/***********************************************************
 // Assignment :  Program Sales and Arrays
 // by: Kyle Gray
 // Date: 1 / 25 / 2016
 // Description: Allow user to make purchases from your .csv loaded inventory
 //  Notes:
 //***********************************************************
 //************************************************************
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class MailOrders {

    ArrayList<MyInventory> inventory = new ArrayList<>();

    void fillInventory() {

        String csvFile = "Program_Inventory.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator

                String[] item_string = line.split(cvsSplitBy);

                MyInventory item = new MyInventory();
                item.setProductNum(Integer.parseInt( item_string[0]), Double.parseDouble(item_string[1].substring(1)), Integer.parseInt(item_string[2]) );

                inventory.add(item);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (MyInventory item : inventory)
        {
            System.out.println("Product Number: " + item.getProductNum() + " Price: $" + item.getPrice());
        }

    }

    int processOrder(int ProductNum, int Qty)
    {
        MyInventory item = getInventoryItem(ProductNum);
        int purchased = 0;
        if (item != null) {
            int in_stock = item.getQty();
            if (Qty <= in_stock) {
                item.updateQty(Qty);
                purchased = Qty;
            } else {
                System.out.println("We only had " + item.getQty() + " in stock.");
                purchased = item.getQty();
                item.updateQty(purchased);
            }
        }
        return purchased;
    }

    MyInventory getInventoryItem(int id) {
        MyInventory matched_item = null;
        for (MyInventory item : inventory)
        {
            if (id == item.getProductNum())
            {
                matched_item = item;
            }
        }
        return matched_item;
    }

}

///////////////////////////////////////////////////////////////////
///   End Of File
///////////////////////////////////////////////////////////////////
