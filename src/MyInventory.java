/***********************************************************
 // Assignment :  Program Sales and Arrays
 // by: Kyle Gray
 // Date: 1 / 25 / 2016
 // Description: Allow user to make purchases from your .csv loaded inventory
 //  Notes:
 //***********************************************************
 //************************************************************
 */

public class MyInventory {
    int ProductNum;
    double Price;
    int Qty;

    void setProductNum(int productNum, double price, int qty) {
        ProductNum = productNum;
        Price = price;
        Qty = qty;
    }

    int getProductNum(){
        return ProductNum;
    }

    double getPrice() {
        return Price;
    }

    int updateQty(int num) {
        Qty -= num;
        return Qty;
    }

    int getQty() {
        return Qty;
    }
}

///////////////////////////////////////////////////////////////////
///   End Of File
///////////////////////////////////////////////////////////////////
