package com.techelevator.view;
public class PurchaseMenu {

    private static double currentMoney;

    public PurchaseMenu() { }
    public static double getCurrentMoney() {
        return currentMoney;
    }


    public static void resetCurrentMoney() {
        SalesLog.logToSales("GIVE CHANGE: $" + getCurrentMoney() + " $0.0");
        currentMoney = 0.0;
    }
    public static void addMoney(double money) {
        currentMoney += money;
        SalesLog.logToSales("FEED MONEY: $" + money + " $" + getCurrentMoney());
    }
    public static boolean updatePurchase(double purchasePrice) {
        if (currentMoney >= purchasePrice) {
            currentMoney -= purchasePrice;
            return true;
        }
        else {
            return false;
        }
    }
}

