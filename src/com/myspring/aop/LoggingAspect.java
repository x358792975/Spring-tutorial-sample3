package com.myspring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(public int com.myspring.aop.ArithmaticCalculator.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs(); 
		
		System.out.println("The method  "+ methodName + " begins with " + Arrays.asList(args));
		
	}
	
	@After("execution(public int com.myspring.aop.ArithmaticCalculator.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method ends with  "+ methodName);
		
	}
	@AfterReturning(value="execution(public int com.myspring.aop.ArithmaticCalculator.*(..))", returning="result")
	public void afterReturn(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method returns  with  "+ methodName);	
		System.out.println("Value ==" + result);
	}
	
	@AfterThrowing(value="execution(public int com.myspring.aop.ArithmaticCalculator.*(..))", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("Ex .... " + ex);
	}

}
