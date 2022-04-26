package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sample05/applicationContext.xml");
		
		OrderMessage orderMessage = context.getBean("orderMessageImpl", OrderMessageImpl.class);
		orderMessage.getOrderMessage();
	}

}
