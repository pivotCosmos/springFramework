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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/{url}") //요청된 주소 = 뷰의 이름!!   step9_WebMVC참고하자!!
	public void url() {}//void일때는 어떻게 view를 찾는거였지..?
}
