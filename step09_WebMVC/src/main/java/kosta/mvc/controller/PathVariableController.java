package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {

	//@RequestMapping(value={"user/jang.do","user/hee.do"})
	@RequestMapping(value={"{type}/{id}.do"})
	public void test(@PathVariable String type,
					 @PathVariable String id) {
		System.out.println("PathVariable test ���Դϴ�...");
		System.out.println("type = " + type);
		System.out.println("id = " + id);
	}
	
	/*@RequestMapping(value={"user/jang.do"}) //��� ��ü������ ������ �а� �켱 ã�ư���.
	public void aa() {
		System.out.println("PathVariable22222 test ���Դϴ�...");
	}*/
	
	@RequestMapping("/{userId}")
	public void test2(@PathVariable String userId) {
		System.out.println("blog/* ��û�Դϴ�....userId = " + userId);
	}
	
	
	@RequestMapping("/{kind}/{type}/{no}")
	public void test3(@PathVariable String kind,
					  @PathVariable String type ,
					  @PathVariable int no) {
		
		System.out.println("kind = " + kind);
		System.out.println("type = " + type);
		System.out.println("no = " + no);
	}
	
	
	@RequestMapping("{url}.do")
	public void aa() {}
}
