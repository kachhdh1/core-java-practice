package com.java.core.programming;



public class GenericTest {

	public static void main(String[] args) {
		Double[] tst = {1.0,2.0,3.0};
		Integer[] tsti = {1,2,3};
		Sum s = new Sum(tsti);
		System.out.println(s.sumTotal());
	}

}

class Sum<T extends Number>{
	T[] nums;
	
	Sum(T[] o){
		nums=o;
	}
	
	public double sumTotal(){
		double sum=0;
		
		for(int i=0;i<nums.length;i++){
			sum += nums[i].doubleValue();
		}
		
		return sum;
	}
}

class Account{}
class Mortgage extends Account{}
