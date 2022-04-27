package kosta.exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * 공통의 기능 : 사전, 사후 처리 (around방식)
 * 
 *   -사전처리 : 현재시간을 구한다.
 *   
 *   -사후처리 : 현재시간을 구한다(사후시간 - 사전시간 = 총소요시간)
 *   
 *      -JoinPoint : 실제 타겟대상의 죽 메소드에 대한 정봉를 가져올수 있는 메소드들을 제공한다.
 *      -ProceedingJoinPoint : JoinPoint의 확장개념으로 메소드에대한 정보도 제공하고 
 *      					   타겟대상을 호출할수 있는 메소드 제공한다.(proceed())
 * */
@Service("advice")
@Aspect
public class TimerAdvice {

	@Around("execution(public * kosta.exam.*Service*.*ello(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println(" [LOG] " + methodName + " 호출되기전 사전 처리입니다......" );
		
		//사전처리
		StopWatch sw = new StopWatch();
		sw.start();
		
		//실제 타겟대상을 호출!!
		Object obj = joinPoint.proceed();
		
		//사후처리
		sw.stop();
		
		System.out.println(" [LOG] " + methodName + "의 리턴값 obj = " + obj);
		System.out.println(" [LOG] " + methodName + "의 총 실행 ms : " + sw.getTotalTimeMillis() + "ms");
		System.out.println(" [LOG] " + methodName + "의 호출 완료 후 사후 처리완료..........\n");
		
		return obj;
		
	}
}
