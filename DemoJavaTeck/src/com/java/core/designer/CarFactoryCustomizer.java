package com.java.core.designer;

public class CarFactoryCustomizer {

	
	public static void main(String[] args) {
		Car maruti = new Maruti800();
		Car superCar = new SuperCar(maruti);
		superCar.assemble();
	}

}
