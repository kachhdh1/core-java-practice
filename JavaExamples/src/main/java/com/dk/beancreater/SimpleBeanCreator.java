package com.dk.beancreater;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.beans.BeanGenerator;

public class SimpleBeanCreator {

	public static void main(String[] args) throws Exception {
		List<String> argument_list = Arrays.asList("name", "age", "salary");
		
		BeanGenerator beanGenerator = new BeanGenerator();

		argument_list.forEach(arg -> beanGenerator.addProperty(arg, String.class));
		
		Object myBean = beanGenerator.create();
		Method setter = myBean.getClass().getMethod("setName", String.class);
		setter.invoke(myBean, "Dharmik");

		Method getter = myBean.getClass().getMethod("getName");
		System.out.println(getter.invoke(myBean));
	}

}
