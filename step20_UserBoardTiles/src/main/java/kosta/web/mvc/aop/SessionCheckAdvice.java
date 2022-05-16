package kosta.web.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * board/* �� ��� ���� ���� �ٿ�ε� �˻� ��ȸ���� �ݵ�� �α��ε� ����ڸ� ���ٰ����ϵ��� üũ
 *  : ���� ������ ���ߴٸ� ������������ �̵� �Ҽ� �ֵ����Ѵ�.
 * */

@Service //����
@Aspect //���ɻ���
public class SessionCheckAdvice {

	/*
	@Before("execution(public * kosta.web.mvc.board.controller.BoardController.*(..))")
	public void before(JoinPoint joinPoint) {//around����̸� object����, ����ó�� ������ void
		//������ ������ �ִ��� üũ�Ѵ�.
		//HttpSession session=?? joinPoint�� �޾ƿ´�.
		
		Object [] params = joinPoint.getArgs();
		HttpSession session = (HttpSession)params[0];
		
		if(session==null || session.getAttribute("loginUser")==null) {
			throw new RuntimeException("�α����ϰ� �̿����ּ���.");
		}
	}
	*/
	////////////////////////////////////////////////////////////////
	/**
	 * Controller��������(joinPoint) �Ű������� HttpSession�� �������� �ʰ�
	 * Service or dao �������� HttpServletRequest������ ����Ҽ� �ֵ��� �Ҽ� �ִ� ���
	 *    : Spring���� 2.x �̻󿡼����� Service or dao �������� HttpServletRequest�� ����Ҽ� �ֵ���
	 *      RequestContext�� �����Ѵ�.
	 * */
	@Before("execution(public * kosta.web.mvc.board.controller.BoardController.*(..))")
	public void before(JoinPoint joinPoint) {//around����̸� object����, ����ó�� ������ void
		//������ ������ �ִ��� üũ�Ѵ�.
		//HttpSession session=?? joinPoint�� �޾ƿ´�.
		RequestAttributes requestAttr = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes)requestAttr;
		HttpServletRequest request = sra.getRequest();
		
		HttpSession session = request.getSession();
		
		if(session==null || session.getAttribute("loginUser")==null) {
			throw new RuntimeException("�α����ϰ� �̿����ּ���.");
		}
	}
}
