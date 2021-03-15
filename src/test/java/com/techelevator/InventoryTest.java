package com.techelevator;

import java.io.File;
import java.util.Map;

import org.junit.*;

public class InventoryTest { 

	
	@Test
	public void createMapFromFile() {
		File testFile = new File("./mapTestFile.txt");
		Inventory testInventory = new Inventory();
		Map<String, Item> objectUnderTest = testInventory.runVendingMachine(testFile);
		
		Assert.assertEquals("{A1=Potato Crisps 3.05 5, A2=Stackers 1.45 5, A3=Grain Waves 2.75 5}", objectUnderTest.toString());
		
	}

	@Test
	public void penniesTest() {
		Inventory pennyTest = new Inventory();
		double balance = 5;
		double actual = pennyTest.depositCashAsPennies(balance);
		Assert.assertEquals(500.0, actual, 0);
	}
	
	@Test
	public void coinChangeTest() {
		Inventory coinTest = new Inventory();
		double balance = 25;
		String actual = coinTest.coinChange(balance);
		Assert.assertEquals("Here are your coins: 1.0 Quarters.", actual);
	}
	
	@Test
	public void oddNumTest() {
		Inventory oddNum = new Inventory();
		double balance = 65;
		String actual = oddNum.coinChange(balance);
		Assert.assertEquals("Here are your coins: 2 Quarter(s), 1 Dime(s), and 1 Nickel(s).", actual);
	}
	
	@Test
	public void doesProductExist() {
		Inventory doesItExist = new Inventory();
		String question = "D5";
		String actual = doesItExist.purchase(question);
		Assert.assertEquals("The selected product code doesn't exist.", actual);
	}
	
	@Test
	public void feedMoneyReturnsTrue() {
		Inventory obj = new Inventory();
		double userSelection = 5.0;
		boolean actual = obj.feedMoney(userSelection);
		
		Assert.assertEquals(true, actual);
		
	}
	
	@Test
	public void feedMoneyReturnsFalse() {
		Inventory obj = new Inventory();
		double userSelection = 3.0;
		boolean actual = obj.feedMoney(userSelection);
		
		Assert.assertEquals(false, actual);
		
	}
	
	@Test
	public void createLogReturnsTrue() {
		Inventory obj = new Inventory();
		
		boolean actual = obj.createNewLogEntry("TEST", 1.0, 5.0);
		
		Assert.assertEquals(true, actual);
	}
}
	