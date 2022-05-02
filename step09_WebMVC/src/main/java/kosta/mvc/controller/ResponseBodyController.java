package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //@Controller + @ResponseBody ���� (4.x �̻󿡼� �߰�)
public class ResponseBodyController {
	
	@RequestMapping(value = "/responseBody.do" , produces = "text/html;charset=UTF-8")
	//@ResponseBody //���ϵǴ� ���� ���̸� ���� ���䵥���Ͱ� �ȴ�. - Front���� Ajax�� ��쿡 ����Ѵ�.
	public String aa() {
		System.out.println("responseBody.do ��û�Ǿ����ϴ�..");
		
		return "Have a nie day! �����Ϸ�";
	}
	
	@RequestMapping(value="/responseBody2.do" , produces = "text/html;charset=UTF-8")
	//@ResponseBody
	public String bb() {
		return "Spring ���� �ű��ϴ�!";
	}
}
