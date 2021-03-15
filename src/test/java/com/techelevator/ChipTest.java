package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {
	private Chip chipTest;
	
	@Before
	public void setup() {
		chipTest = new Chip("Stackers", 1.45);
	}
	
	@Test
	public void getNoise() {
		Assert.assertEquals("Crunch Crunch, Yum!", chipTest.getNoise());
	}
	
	@Test
	public void getPennies() {
		chipTest = new Chip("Stackers", 1.45);
		Inventory object = new Inventory();
		double actual = object.depositCashAsPennies(chipTest.getPrice());
		Assert.assertEquals(145.0, actual, 1);
	}
}
