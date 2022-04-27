package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	/**
	 * around방식 (사전, 사후)
	 * */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around방식의 사전처리 중입니다....\n");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("around방식의 사후처리 중입니다....\n");
		
		return obj;
		
	}
}
