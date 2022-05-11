package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TilesController {
	
	@RequestMapping("/")
	public String index() {
		return "index";// WEB-INF/views/index.jsp
	}
	
	@RequestMapping("/test1")
	public String aa() {
		return "board/list";
	}
	
	@RequestMapping("/test2")
	public ModelAndView bb() {
		return new ModelAndView("board/read");
	}
	
	@RequestMapping("/test3")
	public String cc() {
		return "user/join";
	}
	
	@RequestMapping("/test4")
	public String dd() {
		return "user/login";
	}
	
	@RequestMapping("/test5")
	public String ee() {
		return "test";
	}
	
	@RequestMapping("/test6")
	public String ff() {
		return "board/qa/list";
	}
	
	@RequestMapping("/test7")
	public String gg() {
		return "board/free/write";
	}
}
