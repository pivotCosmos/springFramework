package kosta.web.mvc.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.web.mvc.user.dto.UserDTO;
import kosta.web.mvc.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public void aa() {}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(UserDTO userDTO, HttpSession session) {
		//서비스호출 하고 성공하면 리턴한 UserDTO를 받아서
		UserDTO loginUser = userService.loginCheck(userDTO);
		if(loginUser!=null) {
			//HttpSession에 정보를 저장한다 - 뷰에서 사용하고 있음 ${loginUser}, ${loginName}
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("loginName", loginUser.getName());
		
			return "redirect:/";
		}else {
			throw new RuntimeException("아이디 혹은 비밀번호가 틀립니다.");
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
