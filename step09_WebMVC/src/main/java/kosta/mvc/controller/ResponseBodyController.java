package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //@Controller + @ResponseBody 조합 (4.x 이상에서 추가)
public class ResponseBodyController {
	
	@RequestMapping(value = "/responseBody.do" , produces = "text/html;charset=UTF-8")
	//@ResponseBody //리턴되는 값이 뷰이름 말고 응답데이터가 된다. - Front단이 Ajax인 경우에 사용한다.
	public String aa() {
		System.out.println("responseBody.do 요청되었습니다..");
		
		return "Have a nie day! 좋은하루";
	}
	
	@RequestMapping(value="/responseBody2.do" , produces = "text/html;charset=UTF-8")
	//@ResponseBody
	public String bb() {
		return "Spring 정말 신기하다!";
	}
}
