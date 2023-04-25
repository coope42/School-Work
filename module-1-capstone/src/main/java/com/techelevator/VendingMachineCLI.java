package com.techelevator;

import com.techelevator.view.DisplayItems;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;
import com.techelevator.view.SalesLog;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String MAIN_PURCHASE_OPTION_FEED = "Feed Money";
	private static final String MAIN_PURCHASE_OPTION_SELECT = "Select Product";
	private static final String MAIN_PURCHASE_OPTION_FINISH = "Finish Transaction";
	private static final String[] MAIN_PURCHASE_MENU = { MAIN_PURCHASE_OPTION_FEED, MAIN_PURCHASE_OPTION_SELECT,  MAIN_PURCHASE_OPTION_FINISH};
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		System.out.println("Please input the inventory file location.");
		Scanner inputFile = new Scanner(System.in);

		DisplayItems newDisplay = new DisplayItems();
		newDisplay.setCurrentFile(inputFile.nextLine());
		newDisplay.displayMenu();

		SalesLog trackSales = new SalesLog();
		trackSales.salesLogFile();
		trackSales.logToSales("Sales Log file created");

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				// display vending machine items
				System.out.println(newDisplay.getReturnList().toString()
								.replaceAll("\\[", "")
								.replaceAll("]", "")
								.replaceAll(", ", "\n"));
				choice.equals(null);
			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				String purchaseChoice = (String) menu.getChoiceFromOptions((MAIN_PURCHASE_MENU));

				//do purchase
				switch (purchaseChoice) {
					case MAIN_PURCHASE_OPTION_FEED:
						System.out.println("How much would you like to add?");
						Scanner addingMoney = new Scanner(System.in);
						PurchaseMenu.addMoney(addingMoney.nextDouble());
						System.out.println("Current money provided: $" + PurchaseMenu.getCurrentMoney());
						break;
					case MAIN_PURCHASE_OPTION_SELECT:
						String displayPurchaseOptions = (String) menu.getChoiceFromOptions
								(newDisplay.getReturnList().toArray());
						if (displayPurchaseOptions.substring(3).contains("0")) {
							System.out.println("Sorry, we are currently sold out.");
							choice.equals(MAIN_MENU_OPTION_PURCHASE);
						} else {
							if (newDisplay.doPurchase(displayPurchaseOptions)) {
								String purchaseMessage = newDisplay.getPurchaseMessage
										(displayPurchaseOptions);
								System.out.println(purchaseMessage);
							} else if (!newDisplay.doPurchase(displayPurchaseOptions)) {
								System.out.println("Sorry, insufficient funds.");
							}
						}
						break;
					case MAIN_PURCHASE_OPTION_FINISH:
						System.out.println("Your change is: $" + PurchaseMenu.getCurrentMoney());
						PurchaseMenu.resetCurrentMoney();
						choice.equals(null);
						break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
