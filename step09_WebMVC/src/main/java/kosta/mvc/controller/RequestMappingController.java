package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //생성
@RequestMapping("/rem")
public class RequestMappingController {
	
	/**
	 * 리턴 String인경우는 리턴값이 뷰의 이름이 된다.
	 * */
	@RequestMapping("/a.do")
	public String test(){
		System.out.println("RequestMappingController의 a.do 요청되었습니다.");
		
		return "result"; ///WEB-INF/views/result.jsp
	}
	
	/**
	 * 리턴이 void인 경우는 요청된 주소가 뷰의 이름이 된다.
	 *  ex) rem/a.do 요청이 되면 rem/a가 뷰이름이다. prefix+rem/a+suffix (.do는 약속이라 제거함)
	 *     결론 /WEB-INF/views/rem/a.jsp이동한다.
	 * */
	/*
	 * @RequestMapping("rem/a.do") public void aa(){
	 * System.out.println("rem/a.do 요청되었습니다..."); }
	 */
	
	/**
	 * 여러개의 요청이 하나의 메소드를 실행할 때
	 * */
	@RequestMapping(value = {"/b.do","/c.do"})
	public void b() {
		System.out.println("rem/b.do 또는 rem/c.do 요청되었습니다...");
	}
	
	/*@RequestMapping("/test.do")
	public ModelAndView aaa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		ModelAndView mv = new ModelAndView("result","message","get 또는 post 요청완료입니다.");
		
		return mv;
	}*/
	
	/////get방식 또는 post방식 구분하기///////////////////////////////////
	//@RequestMapping(value = "/test.do" , method= RequestMethod.GET)
	@GetMapping("/test.do") //4.3 version 이상
	public ModelAndView aaa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		ModelAndView mv = new ModelAndView("result","message","get 요청완료입니다.");
		
		return mv;
	}
	
	//@RequestMapping(value = "/test.do" , method= RequestMethod.POST)
	@PostMapping(value="/test.do") //4.3 version 이상
	public ModelAndView bb(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		ModelAndView mv = new ModelAndView("result","message","post 요청완료입니다.");
		
		return mv;
	}
	
	/**
	 * parameter 정보에 따라 호출되는 메소드를 다르게....
	 * */
	//@RequestMapping(value = "/a.do", params = {"id"})
	@RequestMapping(value = "/a.do", params = {"id=hee"})
	//@RequestMapping(value = "/a.do", params = {"id!=hee"})
	//@RequestMapping(value = "/a.do", params = {"id","age"})
	public String c() {
		System.out.println("parameter 정보에 따라 호출되는 메소드 호출되었습니다.");
		
		return "result";
	}
	
}
