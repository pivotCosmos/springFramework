package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context =
			new ClassPathXmlApplicationContext("kosta/exam/applicationContext.xml");
		
		MessageService service = context.getBean("target", MessageService.class);
		service.korHello();
		
		System.out.println("----------------------");
		service.engHello();
		
		System.out.println("----------------------");
		String re = service.hello();
		System.out.println("결과 re = " + re);
		
		System.out.println("----------------------");
		int i = service.hello("이나영");
		System.out.println("결과 i = " + i);
	}
}
