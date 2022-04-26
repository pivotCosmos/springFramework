package sample07;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("sample07/springDIAutowire.xml");

	}

}
