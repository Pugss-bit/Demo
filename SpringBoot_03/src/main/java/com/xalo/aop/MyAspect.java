package com.xalo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Component
public class MyAspect {

	@Pointcut(value = "execution(* com.xalo.controller.*.*(..))")
	public void exe() {

	}

	@Before(value = "exe()")
	public void before() {
		System.out.println("before");
	}

	@Around(value = "exe()")
	public void around(ProceedingJoinPoint po) {
		System.out.println("bbb");
		try {
			po.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around");
	}

	@AfterReturning(value = "exe()")
	public void afterReturn() {
		System.out.println("afterReturn");
	}

	@AfterThrowing(value = "exe()", throwing = "ex")
	public void afterThrow(Exception ex) {
		System.out.println("afterThrow");
	}

	@After(value = "exe()")
	public void after() {
		System.out.println("after");
	}
}
