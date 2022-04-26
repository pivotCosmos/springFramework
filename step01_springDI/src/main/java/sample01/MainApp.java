package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//1.기존방식
		/*MessageBean bean = new MessageEnImpl();
		bean.sayHello("Heejung");
		
		bean = new MessageKoImpl();
		bean.sayHello("희정");*/
		
		//////////////////////////////////
		/*2.Spring Container에 의한 객체 생성(IoC - Inversion of Control ) - metadata라는 설정정보가 필요하다( ~.xml문서)
		   -Container의 종류
		     1)BeanFactory : 객체 생성 + 소멸등에 해당하는 객체의 라이프사이클을 관리
		     
		     2)ApplicationContext : BeanFactory의 확장개념으로 BeanFactory의 기능 + 다국어지원, 메시지 처리
		     
		     3)WebApplicationContext : Spring WEBMVC Container
		     
		      * Container는 객체들을 사전초기화 한다.(미리 메모리에 생성한다 - singleton이다)
		      * scope="prototype"으로 설정하면 지연초기화(필요할때 getBean할때마다 새롭게 생성한다)
		*/
		ApplicationContext context = new ClassPathXmlApplicationContext("sample01/applicationContext.xml");
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sample01/applicationContext.xml");
		
		MessageBean bean = context.getBean("ko", MessageBean.class);
		bean.sayHello("희정");
		
		
		System.out.println("------------------");
		bean = context.getBean("en", MessageBean.class);
		bean.sayHello("Heejung");
		System.out.println("bean주소 : " + bean);
		
		System.out.println("------------------");
		bean = context.getBean("en2", MessageBean.class);
		bean.sayHello("Gahyun");
		System.out.println("bean주소 : " + bean);
		
		
		
	}

}
