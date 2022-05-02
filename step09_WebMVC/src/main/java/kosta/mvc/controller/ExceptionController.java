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
		System.out.println("나눈 결과 : " + result );
		
		return "result";
	}
	
	/**
	 * 현재 Controller에서 발행하는 예외처리
	 * */
	@ExceptionHandler(value = {NumberFormatException.class , ArithmeticException.class})
	//@ExceptionHandler(value = {Exception.class})
	public ModelAndView error(Exception e) {
		System.out.println(e.getMessage());
		//예외가 발생했을때 해야하는 일들을 작성...
		
		ModelAndView mv = new ModelAndView("error/errorView"); // WEB-INF/views/error/errView.jsp
		mv.addObject("errClass",e.getClass()); //뷰에서 @{errClass}
		mv.addObject("errMsg",e.getMessage());
		
		return mv;
	}
	
}
