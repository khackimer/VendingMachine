package com.techelevator;

import org.junit.*;

public class ItemTest {

	Item testItem = new Chip("Test Chip", 20.0);
	
	@Before
	public void reinstatiate() {
		testItem = new Chip("Test Chip", 20.0);
	}
	@Test
	public void testToStringOverride() {
		testItem = new Chip("Test Chip", 20.0);
		
		String testString = testItem.toString();
		
		Assert.assertEquals("Test Chip 20.0 5", testString);
	}
	
	@Test
	public void reduceBalanceDeductsOne() {
		testItem = new Chip("Test Chip", 20.0);
		
		int actual = testItem.reduceQuantity();
		
		Assert.assertEquals(4, actual);
		
	}
	
}
