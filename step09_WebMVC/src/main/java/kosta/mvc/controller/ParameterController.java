package kosta.mvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.mvc.dto.Member;

@Controller //생성
@RequestMapping("/param")
public class ParameterController {

	/**
	 * 리턴이 void인경우는 뷰의 이름이 요청주소가 된다.
	 *   여기서는 WEB-INF/views/param/a.jsp이동
	 * */
	/*@RequestMapping("/a.do")
	public void aa(HttpServletRequest request) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("name : " + name + ", age : " + age);
		
		System.out.println("param/a.do요청되었습니다....");
	}*/
	
	
	/**
	 * 리턴타입이 void, String일때 뷰쪽으로 전달해야하는 정보가 있는경우
	 * 인수 Model은 뷰쪽으로 전달될 객체를 뜻한다.
	 * */
	@RequestMapping("/a.do")
	public void aa(String name, Integer age, Model model) { //int로 하면 null일때 오류남 - Integer쓰면 해결
		
		System.out.println("name : " + name + ", age : " + age);
		
		model.addAttribute("message", "배고파요~~ 점식뭐먹지??"); //뷰에서 @{requestScope.message}
		model.addAttribute("hobbys", Arrays.asList("등산","수영","낚시","골프")); //뷰에서 ${hobbys}
		
		System.out.println("param/a.do요청되었습니다....");
	}
	
	/**
	 * 인수로 Member객체를 받으면 폼에서 전달되는 'name이 일치하는' Member의
	 * 속성을 찾아 setXxx()자동으로 호출된다.
	 * 
	 *   : 인수로 객체(DTO=VO) 형태를 받으면 그 정보가 뷰쪽으로 그대로 전달되어
	 *     뷰에서 사용할수 있다.
	 *      사용방법은 클래스 이름 첫글자를 소문자로 즉 ${member}
	 *      
	 *      만약, 클래스이름 너무 길거나 어렵다면
	 *      @ModelAttribute를 이용해서 별칭을 만들어서 사용할수있다.
	 * */
	@PostMapping("/c.do")
	public String cc(@ModelAttribute("m") Member mem) {
		
		System.out.println("member : " + mem);
		//서비스 -> dao 등록을 완료한 후에...
		
		return "paramResult"; // WEB-INF/view/paramResult.jsp
	}
	///////////////////////////////////////
	
	/**
	 * 현재 Controller를 들렸다 가는 모든 요청의 결과 페이지에서
	 * Model정보로 사용할 수 있따. 뷰에서 ${addr}, ${menus}
	 * */
	@ModelAttribute("addr")
	public String aaa() {
		return "경기도 성남시 오리역";
	}
	
	@ModelAttribute("menus")
	public List<String> menus(){
		return Arrays.asList("짬뽕","짜장","탕수육","깐풍기");
	}
	
	@RequestMapping("/d.do")
	public String d(
			@RequestParam(value="id", required = false) String userId,
			@RequestParam(defaultValue = "0") int age,
			@RequestParam(defaultValue = "Guest") String name) {
		
		System.out.println("param/d.do 요청되었습니다.....");
		System.out.println("userId : " + userId);
		System.out.println("age : " + age);
		System.out.println("name : " + name);
		
		return "result"; //WEB-INF/views/result.jsp이동
	}
	
}
