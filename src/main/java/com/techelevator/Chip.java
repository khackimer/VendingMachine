package com.techelevator;

public class Chip extends Item {

	public Chip(String name, double price) {
		super(name, price);
	
	}

	@Override
	public String getNoise() {
		return "Crunch Crunch, Yum!";
	}

	
}