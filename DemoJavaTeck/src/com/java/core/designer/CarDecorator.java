package com.java.core.designer;

public class CarDecorator implements Car {
	protected Car car;
	
	CarDecorator(Car c){
		this.car = c;
	}
	
	public void assemble() {
		this.car.assemble();
	}

}
