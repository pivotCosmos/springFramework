package kosta.test.advice;

import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service("advice")
@Aspect
public class LogAdvice {
	
	private FileWriter fw;
	public LogAdvice() {
		try {
			fw = new FileWriter("src/main/java/kosta/test/advice/log.text", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Around("execution(public * kosta.test.*.*Impl.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		//사전처리
		String methodName = joinPoint.getSignature().getName();
		int i = joinPoint.getArgs().length;
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		//타겟을 호출
		Object obj = joinPoint.proceed();
		sw.stop();
		
		//사후처리
		StringBuilder sb = new StringBuilder();
		sb.append(methodName + " / 인수 개수 : ");
		sb.append( i + "개 / 리턴 값: " + obj);
		sb.append(" / 총 실행 시간 nanos: " + sw.getTotalTimeNanos() + "nanos\n");
		
		fw.write(sb.toString());
		fw.flush();
		
		return obj;
	}
}
