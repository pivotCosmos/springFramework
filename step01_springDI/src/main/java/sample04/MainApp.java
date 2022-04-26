package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//1. 기존방식
		/*StudentController controller = new StudentController();
		
		Student student = new Student();
		student.setName("희정");
		student.setNo(10);
		student.setPhone("222-2222");
		student.setAddr("서울");
		
		controller.setStudent(student);
		
		StudentService service = new StudentServiceImpl();
		StudentServiceImpl ss= (StudentServiceImpl)service;
		
		StudentDAO studentDAO = new StudentDAOImpl();
		ss.setStudentDAO(studentDAO);
		
		controller.setStudentService(service);
		System.out.println("-------------------");
		controller.insert();*/
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("sample04/springDISetter.xml");
		
		System.out.println("==============");
		StudentController controller = context.getBean("controller", StudentController.class);
		
		controller.insert();
	}

}
