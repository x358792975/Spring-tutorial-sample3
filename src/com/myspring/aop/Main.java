package com.myspring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ArithmaticCalculator arithmaticCalculator = (ArithmaticCalculator) context.getBean("arithmaticCalculator");
		
		//System.out.println(arithmaticCalculator.getClass().getName());
		
		int result = arithmaticCalculator.add(2, 3);
		System.out.println(result);
		
		result = arithmaticCalculator.div(100, 0);
		System.out.println(result);
		
	}

}
