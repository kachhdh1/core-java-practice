package com.dk.beancreater;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.cglib.beans.BeanGenerator;

public class SimpleBeanCreator {
	
	public static void main( String[] args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
    	BeanGenerator beanGenerator = new BeanGenerator();
    	 
    	beanGenerator.addProperty("name", String.class);
    	Object myBean = beanGenerator.create();
    	Method setter = myBean.getClass().getMethod("setName", String.class);
    	setter.invoke(myBean, "some string value set by a cglib");
    	 
    	Method getter = myBean.getClass().getMethod("getName");
    	System.out.println(getter.invoke(myBean));
    }

}
