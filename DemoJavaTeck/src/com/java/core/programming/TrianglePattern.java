package com.java.core.programming;

public class TrianglePattern {

	
	public static void main(String[] args) {
		int triangleHeight = 10;
		int base = triangleHeight+(triangleHeight-1);
		int space = (base-1)/2;
		int printNo;
		for(int i=1;i<=triangleHeight;i++){
			printNo = base-space*2;
			leaveSpace(space);
			for(int j=1;j<=printNo;j++){
				System.out.print("*");
			}
			leaveSpace(space);
			System.out.println("");
			space--;
		}
	}
	
	public static void leaveSpace(int num){
		for(int i=1;i<=num;i++){
			System.out.print(" ");
		}
		
	}

}
