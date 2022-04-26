package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		//1. 기존방식 : service 호출-> dao호출해서 결과를 확인
		/*MemberDAO dao = new MemberDAO();
		Member member = new Member("jang", "1234", 20, "서울");
		
		MemberService service = new MemberService(dao, member);
		service.serviceInsert();*/
		/////////////////////////////////////
		ApplicationContext context=
				new ClassPathXmlApplicationContext("sample02/springDIConstructor.xml");
		
		System.out.println("-------------------");
		MemberService service = context.getBean("service", MemberService.class);
		service.serviceInsert();
	}
	
}
