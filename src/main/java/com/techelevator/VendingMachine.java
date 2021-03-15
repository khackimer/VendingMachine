package com.techelevator;

import java.io.File;

import java.util.Map;

public class VendingMachine {
	
	
	public static void main(String[] args) {
		// We're creating an input file, named from the csv
		File inputFile = new File("./vendingmachine.csv");
	
		// We need to bring in this file to bring in our Inventory object, which is the vending machine name
		Inventory vm800 = new Inventory();
		// Creating an item map when we run the vending machine and give it a file. This allows our menus to see our inventory. Gets it up and running.
		Map<String, Item> itemMap = vm800.runVendingMachine(inputFile);
		// Menu object. Menues need a map and inventory object, which we just created.
		Menu testMenu = new Menu(itemMap, vm800);
		// Run main menu
		testMenu.getMainMenu();
	 	 		   
	}
}
		
