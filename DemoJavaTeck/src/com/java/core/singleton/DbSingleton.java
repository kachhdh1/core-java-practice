package com.java.core.singleton;

public class DbSingleton {
	
	//eager 
	private  static DbSingleton dbSingleton=null;
	
	
	private DbSingleton(){}
	
	public static DbSingleton getInstance(){
		
		if(null==dbSingleton){
			synchronized (DbSingleton.class) {
				if(null==dbSingleton){
					dbSingleton = new DbSingleton();
				}
			}
		}
		
		return dbSingleton;
	}
}
