package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Inventory {
    	
	double balance;
	
	List <String> inventoryList = new ArrayList<>();

	Map<String, Item> itemMap = new LinkedHashMap<>();
	
	
	// Run this method to start the vending machine
	public Map<String, Item> runVendingMachine(File inputFile) {
	
		
		// try-with-resources
 		try (Scanner fileScanner = new Scanner(inputFile)){ // create scanner to scan file
			
			while (fileScanner.hasNextLine()) { // read file line by line as long as there is a next line
				String singleLine = fileScanner.nextLine(); // create string

				String[] itemDetails = null; // create String array
				
				itemDetails = singleLine.split("\\|"); // splits line into array at pipe
				if(itemDetails[3].equals("Chip")) {
					Item newItem = new Chip(itemDetails[1], Double.parseDouble(itemDetails[2]));
					itemMap.put(itemDetails[0], newItem);
				
				} else if (itemDetails[3].equals("Candy")) {
					Item newItem = new Candy(itemDetails[1], Double.parseDouble(itemDetails[2]));
					itemMap.put(itemDetails[0], newItem);
				
				} else if (itemDetails[3].equals("Drink")) {
					Item newItem = new Drink(itemDetails[1], Double.parseDouble(itemDetails[2]));
					itemMap.put(itemDetails[0], newItem);
				
				}else if (itemDetails[3].equals("Gum")) {
					Item newItem = new Gum(itemDetails[1], Double.parseDouble(itemDetails[2]));
					itemMap.put(itemDetails[0], newItem);
				}		
			}
		} catch (FileNotFoundException e) {
			System.out.println("There is an error with the file.");
			e.printStackTrace();
			}

		
		return itemMap;
	}
	
	
	public String purchase(String productCode) {
		double oldBalance = balance;
		
		if(!itemMap.containsKey(productCode)) {
			System.out.println("The selected product code doesn't exist.");
			return "The selected product code doesn't exist."; // return to Purchase Menu
		}
		
		if(itemMap.containsKey(productCode)) {
		 	Item currentItem = itemMap.get(productCode);

			if(currentItem.getQuantity() == 0) {
			
			System.out.print("Product is SOLD OUT\n\n"); ; // newMenu.getPurchaseMenu(); <<-- need to return to purchase menu
			return "Product is SOLD OUT"; // return to Purchase Menu
			
			} else if(balance >= currentItem.getPrice()) {
																							
			currentItem.reduceQuantity();// Qty - 1	 
			
			balance -= currentItem.getPrice();
			System.out.println(currentItem.getName() + " $" + currentItem.getPrice() + " $" + balance + " " + "\"" +currentItem.getNoise() + "\"" + "\n");
			
			createNewLogEntry(currentItem.getName() + " " + productCode, oldBalance, balance);
			return ""; // return to Purchase Menu
			
			
			} else {
				System.out.println("Please enter more money."); // price exceeds balance 
				return ""; // return to Purchase Menu
			}
		}
		return null;
	}
	
	public boolean feedMoney(double addMoney) {

		double oldBalance = getBalance();
	
		Set<Double> values = new HashSet<Double>(Arrays.asList(new Double[] {1.00, 2.00, 5.00, 10.00}));
		// The shorter version of doing value.add1, value.add2, etc.
		// We have a set of doubles called values. All of the values from that set are in the array list.
			if(values.contains(addMoney)) {
				balance += addMoney;
				createNewLogEntry("FEED MONEY: ", oldBalance, getBalance());
				return true;
			} 
		
		return false;
		
	}
	
	
	public boolean createNewLogEntry(String step, double oldBalance, double newBalance) { // Will return true or false
		
		String fileName = "log.txt"; // Creating a new file name

		
		LocalDateTime myDateObj = LocalDateTime.now(); // Establishing local date and time
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
		String formattedDate = myDateObj.format(myFormatObj);
		
		File filePath = new File("."); // File Path Here
		fileName = "log.txt"; 
		File logFile = new File(filePath, fileName); // Creating a file called logFile
		if (filePath.exists()) { // If Path exists...
			if (!logFile.exists()) { // If File doesnt exist...
				try {
					logFile.createNewFile(); // Open up PrintWriter and FileWriter
					PrintWriter fileWriter = new PrintWriter(new FileWriter(fileName, true));
					// Format to date, step, oldbalance, newbalance
					fileWriter.printf(formattedDate + " " + step + " " + "$" + oldBalance + " " + "$" + newBalance + "\n");
	
					fileWriter.close();
				} catch (IOException e) { // Catch exception if file doesn't exist
					e.printStackTrace();
				}
			} else if (logFile.exists()) { // If file already exists, we'll append onto already created file
			try(PrintWriter fileWriter = new PrintWriter(new FileWriter(fileName, true))) {
					
				fileWriter.printf(formattedDate + " "+ step + " " + "$" + oldBalance + " " + "$" + newBalance + "\n");
				
			} catch (IOException e) {
				
				e.printStackTrace();
				}
			}
			return true;
		}
		return false;	
	}

	
	public double depositCashAsPennies (double deposit) {
		return  (deposit * 100);
	}
	
	public String coinChange (double balance) {
		
		double quartersDue = 0;
		double dimesDue = 0;                                                      
		double nickelsDue = 0;                                                    
		                                                                       
		// Balance counter moves through 25s, to 10s, to 5s                    
			if (balance % 25 == 0) {                                         
				quartersDue = balance / 25;                                  
				return "Here are your coins: " + quartersDue + " Quarters.";   
			} else if (balance % 25 != 0) {                                  
				quartersDue = balance / 25; 
				balance -= (int)quartersDue * 25;
				dimesDue = balance / 10; 
				balance -= (int)dimesDue * 10;
				nickelsDue = balance / 5;                              
			}                                                                  
		                                                                       
		                                                                       
		return "Here are your coins: " + (int)quartersDue + " Quarter(s), " 
				+ (int)dimesDue + " Dime(s), and " + (int)nickelsDue + " Nickel(s).";		
	}
	
	public double getBalance() {
		return balance;
	}
}


	

	
	
	
	
