package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Order(1)
public class AroundAdvice {
	
	/**
	 * around방식 (사전, 사후)
	 * */
	@Around("PointCutClass.aa()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around방식의 사전처리 중입니다....\n");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("around방식의 사후처리 중입니다....\n");
		
		return obj;
		
	}
}
