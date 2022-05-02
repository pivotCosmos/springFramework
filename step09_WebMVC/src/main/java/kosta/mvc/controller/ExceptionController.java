package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	
	@RequestMapping("/exception.do")
	public String aa(String no) {
		int convertNo = Integer.parseInt(no);
		System.out.println("convertNo = " + convertNo);
		
		int result = 100/convertNo;
		System.out.println("���� ��� : " + result );
		
		return "result";
	}
	
	/**
	 * ���� Controller���� �����ϴ� ����ó��
	 * */
	@ExceptionHandler(value = {NumberFormatException.class , ArithmeticException.class})
	//@ExceptionHandler(value = {Exception.class})
	public ModelAndView error(Exception e) {
		System.out.println(e.getMessage());
		//���ܰ� �߻������� �ؾ��ϴ� �ϵ��� �ۼ�...
		
		ModelAndView mv = new ModelAndView("error/errorView"); // WEB-INF/views/error/errView.jsp
		mv.addObject("errClass",e.getClass()); //�信�� @{errClass}
		mv.addObject("errMsg",e.getMessage());
		
		return mv;
	}
	
}
