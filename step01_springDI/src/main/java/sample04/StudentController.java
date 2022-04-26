package sample04;

public class StudentController {
	private StudentService studentService;
	private Student student;
	
	public StudentController() {
		System.out.println("StudentController의 생성자 호출됨!!!");
	}
	
	public void setStudent(Student student) {
		this.student = student;
		System.out.println("StudentController의 setStudent(Student student) 호출됨 , student = " + student);
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
		System.out.println("StudentController의 setStudentService(StudentService studentService) 호출됨, studentService = " + studentService);
	}
	
	public void insert() {
		System.out.println("StudentController의 insert 호출됨....");
		//서비스의 insert를 호출한다.
		studentService.insert(student);
		
	}
}
