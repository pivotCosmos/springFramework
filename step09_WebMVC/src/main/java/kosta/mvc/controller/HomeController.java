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
@Controller //���� <bean ����
public class HomeController {
	
	@RequestMapping("/test.do")
	public ModelAndView aa(String no) {
		System.out.println("test.do�� ��û�Ǿ����ϴ�......");
		
		int i = Integer.parseInt(no);
		System.out.println("���� i = " + i);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home"); // WEB-INF/views/home.jsp�̵�
		
		// addObject�� ������ request.setAttribute()�� ����
		mv.addObject("serverTime", new Date().toLocaleString()); //�信�� ${reqeustScope.serverTime}
		
		return mv;
	}
	
}
