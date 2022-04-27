package kosta.advice;

import org.aspectj.lang.annotation.Pointcut;

/**
 * pointCut을 정의해 놓는 클래스
 * */
public class PointCutClass {
	/**
	 * 로그기록을 할 pointCut
	 * */
	@Pointcut("execution(public * kosta.exam.*Impl.*(..))")
	public void aa() {}
	
	/**
	 * 트랜잭션 처리할 pointCut
	 * */
	@Pointcut("execution(public * kosta.exam.*Impl.insert(..))")
	public void bb() {}
	
	/**
	 * 세션유무 체크할 pointCut
	 * */
	@Pointcut("execution(public * kosta.exam.*Impl.select(..))")
	public void cc() {}
}
