package kosta.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.exam.MemberService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("kosta/main/applicationContext.xml");
		
		MemberService service = context.getBean("target", MemberService.class);
		service.insert();
		
		System.out.println("========================");
		service.select(4);
		
		System.out.println("========================");
		service.update("jang", "희정");
	}
	

}
