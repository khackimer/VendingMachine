package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
	private Drink drinkTest;
	
	@Before
	public void setup() {
		drinkTest = new Drink("Cola", 1.25);
	}
	
	@Test
	public void getNoise() {
		Assert.assertEquals("Glug Glug, Yum!", drinkTest.getNoise());
	}
	
	@Test
	public void getPennies() {
		drinkTest = new Drink("Cola", 1.25);
		Inventory object = new Inventory();
		double actual = object.depositCashAsPennies(drinkTest.getPrice());
		Assert.assertEquals(125.0, actual, 1);
	}
}