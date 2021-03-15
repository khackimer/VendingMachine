package com.techelevator;


public abstract class Item {

	
	private String name;
	private double price;
	private int quantity;
	

	public Item(String name, double price) {
		
		this.name = name; 
		this.price = price;
		quantity = 5;
		
	}

	public abstract String getNoise(); 
	
	public int reduceQuantity() { // when someone purchases call this method to reduce quantity
		quantity--; // reduce qty by 1
		return this.quantity;
	}
	
	@Override
	public String toString() { // override to allow a print of the list
		return  name + " " + price + " " + getQuantity();
	}

	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}


}

