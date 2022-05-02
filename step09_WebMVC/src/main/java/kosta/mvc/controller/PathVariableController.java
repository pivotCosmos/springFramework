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
		System.out.println("PathVariable test 중입니다...");
		System.out.println("type = " + type);
		System.out.println("id = " + id);
	}
	
	/*@RequestMapping(value={"user/jang.do"}) //경로 구체적으로 설정해 둔걸 우선 찾아간다.
	public void aa() {
		System.out.println("PathVariable22222 test 중입니다...");
	}*/
	
	@RequestMapping("/{userId}")
	public void test2(@PathVariable String userId) {
		System.out.println("blog/* 요청입니다....userId = " + userId);
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
