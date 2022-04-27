package com.study.myapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component("log") //객체 생성
public class LogAdvice {
//	@Before(value="execution(* com.study.myapp.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[공통 로그] 비지니스 로직 수행 전 호출 ");
//	}
	
	//익셉션 여부와 상관없이 메소드 실행 후 호출된다
//	@After(value="execution(* com.study.myapp.Product.getInfo())")
//	public void AfterLog() {
//		System.out.println("[공통 로그] 비지니스 로직 수행 후 호출 ");
//	}
//	@AfterReturning(value="execution(* com.study.myapp.Product.getInfo())")
//	public void AfterReturnLog() {
//		System.out.println("[공통 로그] 비즈니스 로직 수행시 익셉션 없이 실행 후 호출 ");
//		//수행 후 호출이 맞긴 하지만 익셉션이 없어야 한다
//	}
//	@AfterThrowing(value="execution(* com.study.myapp.Product.getInfo())")
//	public void AfterThrowLog() {
//		System.out.println("[공통 로그] 비지니스 로직 수행시 익셉션 발생 후 호출 ");
//		//수행 후 호출이 맞긴 하지만 익셉션이 없어야 한다
//	}
	@Around(value="execution(* com.study.myapp.Product.getInfo())")
	public void AroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[공통 로그] 비즈니스 로직 수행시 전 호출 ");
		try {
			//비즈니스 메소드 호출
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("[공통 로그] 비즈니스 로직 수행시 후 호출 ");
		//수행 후 호출이 맞긴 하지만 익셉션이 없어야 한다
	}

}
