package com.techelevator.view;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayItems {

    // returnList for updating inventory and logs.
    private File currentFile;
    private final int MAX_INVENTORY = 5;
    private boolean result;

    private static List<String> returnList = new ArrayList<>();
    private static List<String> menuItems = new ArrayList<>();

    public DisplayItems() {
    }
    public void setCurrentFile(String fileName) {
        this.currentFile = new File(fileName);
    }

    // Updates the inventory when a purchase is made, reformats item back into String.
    public void updateInventory(String purchase) {
        int z = 0;
        for (String itemMenu : returnList) {
            if (itemMenu.contains(purchase.substring(0, purchase.length()-2))) {
                String[] currentInv = itemMenu.split("\\|");
                int x = Integer.parseInt(currentInv[4]) - 1;
                String itemToSet = (currentInv[0] + "|"
                        + currentInv[1] + "|"
                        + currentInv[2] + "|"
                        + currentInv[3] + "|"
                        + x);
                returnList.set(z, itemToSet);
                SalesLog.logToSales(currentInv[1] + " "
                                    + currentInv[0] + " $"
                                    + currentInv[2] + " $"
                                    + PurchaseMenu.getCurrentMoney());
                break;
            }
            z++;
        }
    }

    // Gets the items off list and grabs the Name and Inv for display
    public List<String> getReturnList() {
        int z = 0;
        for (String format : returnList) {
            String[] split = format.split("\\|");
            menuItems.set(z, split[1] + " " + split[4]);
            z++;
        }
        return menuItems;
    }

    // initializes the menu from a txt file
    public void displayMenu() {

        try (Scanner invList = new Scanner(currentFile)) {
            while (invList.hasNextLine()) {
                String thisLine = invList.nextLine();
                returnList.add(thisLine + "|" + MAX_INVENTORY);
                menuItems.add(thisLine + "|" + MAX_INVENTORY);
            }
        } catch (Exception e) {

        }
    }
    // Gets the purchase message based off the type of item.
    public String getPurchaseMessage(String purchase) {
        String newMessage = "";
        for (String menu : returnList) {
            String[] purchaseMessage = menu.split("\\|");
            if (menu.contains(purchase.substring(0, purchase.length()-2))) {
                switch (purchaseMessage[3]) {
                    case "Chip":
                        newMessage = "Crunch Crunch, Yum!";
                        updateInventory(purchase);
                        return newMessage;
                    case "Candy":
                        newMessage = "Munch Munch, Yum!";
                        updateInventory(purchase);
                        return newMessage;
                    case "Drink":
                        newMessage = "Glug Glug, Yum!";
                        updateInventory(purchase);
                        return newMessage;
                    case "Gum":
                        newMessage = "Chew Chew, Yum!";
                        updateInventory(purchase);
                        return newMessage;
                }
            }
        }
        return newMessage;
    }
    // checks if chosen item is in stock, and machine has enough money to complete transaction, returns true/false
    public boolean doPurchase(String chosenItem) {
        for (String purchase : returnList) {
            if(purchase.contains(chosenItem.substring(0, chosenItem.length()-2))) {
                String[] purchaseSplit = purchase.split("\\|");
                result = PurchaseMenu.updatePurchase(Double.parseDouble(purchaseSplit[2]));
                return result;

            }
        }
        return result;
    }
}

