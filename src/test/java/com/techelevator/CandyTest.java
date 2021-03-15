package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {
	private Candy candyTest;
	
	@Before
	public void setup() {
		candyTest = new Candy("Wonka Bar", 1.50);
	}
	
	@Test
	public void getNoise() {
		Assert.assertEquals("Munch Munch, Yum!", candyTest.getNoise());
	}
	
	@Test
	public void getPennies() {
		candyTest = new Candy("Wonka Bar", 1.50);
		Inventory object = new Inventory();
		double actual = object.depositCashAsPennies(candyTest.getPrice());
		Assert.assertEquals(150.0, actual, 1);
	}
}
