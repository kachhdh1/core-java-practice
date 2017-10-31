package com.dharmik.reflection;

import java.lang.reflect.Field;

public class AccessPrivateFields {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, 
		IllegalArgumentException, IllegalAccessException {
		PrivateObject po = new PrivateObject("Dharmik");
		PrivateObject po2 = new PrivateObject("Kachhia");
		//String var = po.privateField; //compilation error
		
		Field privateField = PrivateObject.class.getDeclaredField("privateField");
		privateField.setAccessible(true);

		/*
		 * we have made the field as accesible as true now to get value
		 * we have to supply of which object instance field we want
		 * the value of.
		 */
		System.out.println((String) privateField.get(po));
		System.out.println((String) privateField.get(po2));
	}

}

class PrivateObject{
	private String privateField;
	
	PrivateObject(String field){
		this.privateField = field;
	}
}
