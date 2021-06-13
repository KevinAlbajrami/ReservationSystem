package com.sample.reservationSys.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectImpl {
	
	@Before("execution(* com.sample.reservationSys.controllers.UserController.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("Before "+ jp.getSignature().getName());
	}
	
	@After("execution(* com.sample.reservationSys.controllers.UserController.*(..))")
	public void after(JoinPoint jp) {
		System.out.println("After "+ jp.getSignature().getName());
	}
}
