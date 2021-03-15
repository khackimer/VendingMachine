package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {
	private Gum gumTest;
	
	@Before
	public void setup() {
		gumTest = new Gum("U-Chews", 0.85);
	}
	
	@Test
	public void getNoise() {
		Assert.assertEquals("Chew Chew, Yum!", gumTest.getNoise());
	}
	
	@Test
	public void getPennies() {
		gumTest = new Gum("U-Chews", 0.85);
		Inventory object = new Inventory();
		double actual = object.depositCashAsPennies(gumTest.getPrice());
		Assert.assertEquals(85.0, actual, 1);
	}
}