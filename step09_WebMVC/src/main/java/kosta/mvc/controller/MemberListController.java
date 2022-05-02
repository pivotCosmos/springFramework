package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.dto.Member;
import kosta.mvc.dto.MemberListDTO;

@Controller
public class MemberListController {
	
	@RequestMapping("/list/memberMulti.do")
	public String aa(MemberListDTO memberList) {
		System.out.println("--------------------");
		for(Member m : memberList.getList()) {
			System.out.println("m.isState() = "+m.isState());
			System.out.println("m.getName() = "+m.getName());
			System.out.println("m.getAge() = "+m.getAge());
			System.out.println("m.getAddr() = "+m.getAddr()+"\n");
		}
			
		System.out.println("--------------------");
		return "listResult"; //WEB-INF/views/memberMulti.jsps
	}
}
