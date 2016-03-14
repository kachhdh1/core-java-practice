package com.java.core.singleton;

public class SingletonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbSingleton dbObj = DbSingleton.getInstance();
		DbSingleton dbObj2 = DbSingleton.getInstance();
		System.out.println(dbObj);
		System.out.println(dbObj2);
		System.out.println("Are both objects same? :"+dbObj.equals(dbObj2)+"");
	}

}
