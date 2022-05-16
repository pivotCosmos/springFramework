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
		//����ȣ�� �ϰ� �����ϸ� ������ UserDTO�� �޾Ƽ�
		UserDTO loginUser = userService.loginCheck(userDTO);
		if(loginUser!=null) {
			//HttpSession�� ������ �����Ѵ� - �信�� ����ϰ� ���� ${loginUser}, ${loginName}
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("loginName", loginUser.getName());
		
			return "redirect:/";
		}else {
			throw new RuntimeException("���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
