package kosta.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller //생성 <bean 동일
public class HomeController {
	
	@RequestMapping("/test.do")
	public ModelAndView aa(String no) {
		System.out.println("test.do가 요청되었습니다......");
		
		int i = Integer.parseInt(no);
		System.out.println("숫자 i = " + i);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home"); // WEB-INF/views/home.jsp이동
		
		// addObject는 기존의 request.setAttribute()와 동일
		mv.addObject("serverTime", new Date().toLocaleString()); //뷰에서 ${reqeustScope.serverTime}
		
		return mv;
	}
	
}
