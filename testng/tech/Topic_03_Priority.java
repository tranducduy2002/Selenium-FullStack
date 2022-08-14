package tech;

import org.testng.annotations.Test;

public class Topic_03_Priority {

    @Test //(priority = 1)
    public void Order_01_View_Product(){

    }

    @Test //(priority = 2)
    public void Order_02_Add_To_Cart(){

    }

    @Test(description = "Anyone can add item to Cart and proceed to payment") //(priority = 3)
    public void Order_03_Add_Payment_Method(){

    }

    @Test //(priority = 4)
    public void Order_04_Checkout(){

    }

}
