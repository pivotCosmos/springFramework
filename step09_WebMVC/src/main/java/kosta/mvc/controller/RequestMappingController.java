package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //����
@RequestMapping("/rem")
public class RequestMappingController {
	
	/**
	 * ���� String�ΰ��� ���ϰ��� ���� �̸��� �ȴ�.
	 * */
	@RequestMapping("/a.do")
	public String test(){
		System.out.println("RequestMappingController�� a.do ��û�Ǿ����ϴ�.");
		
		return "result"; ///WEB-INF/views/result.jsp
	}
	
	/**
	 * ������ void�� ���� ��û�� �ּҰ� ���� �̸��� �ȴ�.
	 *  ex) rem/a.do ��û�� �Ǹ� rem/a�� ���̸��̴�. prefix+rem/a+suffix (.do�� ����̶� ������)
	 *     ��� /WEB-INF/views/rem/a.jsp�̵��Ѵ�.
	 * */
	/*
	 * @RequestMapping("rem/a.do") public void aa(){
	 * System.out.println("rem/a.do ��û�Ǿ����ϴ�..."); }
	 */
	
	/**
	 * �������� ��û�� �ϳ��� �޼ҵ带 ������ ��
	 * */
	@RequestMapping(value = {"/b.do","/c.do"})
	public void b() {
		System.out.println("rem/b.do �Ǵ� rem/c.do ��û�Ǿ����ϴ�...");
	}
	
	/*@RequestMapping("/test.do")
	public ModelAndView aaa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("�̸� : " + name);
		
		ModelAndView mv = new ModelAndView("result","message","get �Ǵ� post ��û�Ϸ��Դϴ�.");
		
		return mv;
	}*/
	
	/////get��� �Ǵ� post��� �����ϱ�///////////////////////////////////
	//@RequestMapping(value = "/test.do" , method= RequestMethod.GET)
	@GetMapping("/test.do") //4.3 version �̻�
	public ModelAndView aaa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("�̸� : " + name);
		
		ModelAndView mv = new ModelAndView("result","message","get ��û�Ϸ��Դϴ�.");
		
		return mv;
	}
	
	//@RequestMapping(value = "/test.do" , method= RequestMethod.POST)
	@PostMapping(value="/test.do") //4.3 version �̻�
	public ModelAndView bb(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("�̸� : " + name);
		
		ModelAndView mv = new ModelAndView("result","message","post ��û�Ϸ��Դϴ�.");
		
		return mv;
	}
	
	/**
	 * parameter ������ ���� ȣ��Ǵ� �޼ҵ带 �ٸ���....
	 * */
	//@RequestMapping(value = "/a.do", params = {"id"})
	@RequestMapping(value = "/a.do", params = {"id=hee"})
	//@RequestMapping(value = "/a.do", params = {"id!=hee"})
	//@RequestMapping(value = "/a.do", params = {"id","age"})
	public String c() {
		System.out.println("parameter ������ ���� ȣ��Ǵ� �޼ҵ� ȣ��Ǿ����ϴ�.");
		
		return "result";
	}
	
}
