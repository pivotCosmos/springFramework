package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context =
			new ClassPathXmlApplicationContext("kosta/exam/applicationContext.xml");
		/**
		 * AOP PoxyServer는 J2SE방식으로 서버를 생성한다.
		 *  이것은 만약, interface의 구현객체를 joinPotin대상으로 설정할때 반드시 interface를 통해
		 *  타겟대상을 호출하도록 해야한다. (interface가 없는 객체는 해당없음)
		 * 
		 *  만약, J2SE방식을 CGLIB방식으로 변경하면 interface기반 또는 구현객체를 통해 호출해도
		 *  상관 없다!
		 * */
		MessageService service = context.getBean("target", MessageService.class);
		service.korHello();
		
		/*System.out.println("----------------------");
		service.engHello();
		
		System.out.println("----------------------");
		String re = service.hello();
		System.out.println("결과 re = " + re);
		
		System.out.println("----------------------");
		int i = service.hello("이나영");
		System.out.println("결과 i = " + i);
		
		System.out.println("======================");
		UserService service2 = context.getBean("service", UserService.class);
		String aa = service2.testHello();
		System.out.println("결과 aa = " + aa);
		
		System.out.println("----------------------");
		service2.insertHello(4, 5);*/
	}
}
