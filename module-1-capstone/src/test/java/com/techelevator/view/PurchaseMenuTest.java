package com.techelevator.view;
import junit.framework.TestCase;
import org.junit.Test;

public class PurchaseMenuTest extends TestCase {

    @Test
    public void testAddMoney(){
        PurchaseMenu.addMoney(2.0);
        assertEquals(2.0, PurchaseMenu.getCurrentMoney());
        PurchaseMenu.resetCurrentMoney();
    }
    @Test
    public void testResetCurrentMoney(){
        PurchaseMenu.addMoney(2.0);
        PurchaseMenu.resetCurrentMoney();
        assertEquals(0.0,PurchaseMenu.getCurrentMoney());
    }
    @Test
    public void testUpdatePurchase(){

        PurchaseMenu.addMoney(2.0);
        assertEquals(true,PurchaseMenu.updatePurchase(2.0));

    }


}