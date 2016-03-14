package com.java.core.programming;

public class StaticsDemo {

	
	public static void main(String[] args) {
		Hospital hosp1 = new Hospital("ms");
		Hospital hosp2 = new Hospital("bro");
		
		System.out.println(Hospital.noOfChild);
		System.out.println(hosp1.getNoOfChild());
		System.out.println(hosp2.getNoOfChild());
	}

}

class Hospital{
	static int noOfChild=0;
	
	private String childName;
	
	Hospital(String name){
		this.childName= name;
		noOfChild++;
	}

	
	public int getNoOfChild() {
		return noOfChild+1;
	}

	public void setNoOfChild(int noOfChild) {
		this.noOfChild = noOfChild;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
}
