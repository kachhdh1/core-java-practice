package com.dk.functionaltechniques.partialappandcurrying;

import java.util.function.Function;

public class CurryingExamples {

	public static void main(String[] args) {
		CurryingTaxExample();
		CurryingFunctionExample();
	}

	public static void CurryingTaxExample(){
		//function with two arguments and we will make one function each taking one argument
		Function<Double, Function<Double,Double>> calculateTax = rate -> amount -> amount * rate;
		Function<Double,Double> calculateNationalTax = calculateTax.apply(0.2);
		Function<Double,Double> calculateInternationalTax = calculateTax.apply(0.3);
		
		System.out.println( calculateNationalTax.apply(100.0) );
        System.out.println( calculateInternationalTax.apply(100.0) );
	}
	
	public static void CurryingFunctionExample(){
		/*
		 * In this example, we are turning a three parameter function into currying example.
		 * arguments are(Short, Integer, Long)
		 */
		Function<Short, Function<Integer,Function<Long,Long>>> func = 
				s -> i -> l -> s + i + l;
		System.out.println(func.apply((short)1).apply(2).apply(3L));
	}
}
