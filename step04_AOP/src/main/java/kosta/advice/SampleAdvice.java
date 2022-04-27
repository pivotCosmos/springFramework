package kosta.advice;

import org.aspectj.lang.JoinPoint;

public class SampleAdvice {

	/**
	 * before
	 * */
	public void before(JoinPoint joinPoint) {
		//호출될 메소드(joinPoint)의 인수를 가져오기
		String methodName = joinPoint.getSignature().getName();
		
		Object [] params = joinPoint.getArgs();
		System.out.println(methodName + "의 인수의 개수는 " + params.length);
		if(params.length>0) {
			for(Object o : params) {
				System.out.println(methodName + "의 인수 : " + o);
			}
		}
		
		System.out.println(methodName + "이 호출되기전 before입니다.....\n");
	}
	
	
	/**
	 * after-returning(사후처리 : 정상적으로 동작했을때)
	 * 
	 *  @param : Object obj는 joinPoint(메소드)가 리턴한 정보를 담을 변수
	 *  		 xml을 설정할때 returning="obj" 속성이 필요하다
	 * */
	public void afterReturning(JoinPoint joinPoint , Object obj) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println(methodName + "의 리턴 값 : " + obj);
		System.out.println(methodName + "의 after-returning 실행중입니다....");
		
	}
	
	
	/**
	 * after-throwing(사후처리 : 예외가 발생했을때)
	 *   @param : 인수로 Throwable를 받기 위해서는 설정할때 throwing="e" 필수
	 * */
	public void afterThrowing(Throwable e) {
		System.out.println("예외정보 : " + e);
		System.out.println("예외가 발생했을때 afterThrowing 실행중입니다...\n");
	}
	
	
	/**
	 * after(사후처리: 예외발생여부 상관없이 무조건)
	 * */
	public void afterFinally() {
		System.out.println("예외발생여부 상관없이 무조건 사후처리 중입니다....\n");
	}
	
	
}
