package com.dharmik.programming.ArraysNdStrings;

public class TransposeArray {

	private static int rows=3;
	private static int columns=3;
	private static int[][] data;
	
	public static void main(String[] args) {

		data = new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		transpose();
	}
	
	public static void transpose(){
		int[][] temp = new int[columns][rows];
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				temp[j][i] = data[i][j];//main logics
			}
		}
		data = temp;
		print();
	}

	public static void print() {
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

}
