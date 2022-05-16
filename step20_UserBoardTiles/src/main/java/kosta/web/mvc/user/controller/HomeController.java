package kosta.web.mvc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.web.mvc.user.service.UserService;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "main/index";
	}
	
}
