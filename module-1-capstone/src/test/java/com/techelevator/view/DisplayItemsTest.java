package com.techelevator.view;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DisplayItemsTest extends TestCase {
    @Test
    public void testUpdateInventory() {
        DisplayItems item = new DisplayItems();
        item.setCurrentFile("module-1-capstone/vendingmachine.csv");
        item.displayMenu();
        item.updateInventory("Wonka Bar 4");
        List<String> inventoryitem = item.getReturnList();
        String x = inventoryitem.get(6);
        assertEquals(true, x.contains("4"));
    }

    public void testGetPurchaseMessage() {
        DisplayItems item = new DisplayItems();
        assertEquals("Crunch Crunch, Yum!", item.getPurchaseMessage("Chip"));
    }

    public void testDoPurchase() {
        DisplayItems item = new DisplayItems();
        item.setCurrentFile("module-1-capstone/vendingmachine.csv");
        PurchaseMenu.addMoney(10);
        assertEquals(true, item.doPurchase("Wonka Bar 5"));
    }


}