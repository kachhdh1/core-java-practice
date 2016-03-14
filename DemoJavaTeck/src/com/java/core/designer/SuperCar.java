package com.java.core.designer;

public class SuperCar extends CarDecorator{

	SuperCar(Car c) {
		super(c);
		
	}
	
	public void assemble(){
		super.assemble();
		System.out.print(" making it super car.");
	}

}
