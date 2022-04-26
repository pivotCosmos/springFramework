package sample04;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("StudentServiceImpl 생성자 호출됨...");
	}
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("StudentServiceImpl의 setStudentDAO(StudentDAO studentDAO) 호출됨... , studentDAO = "+studentDAO);
	}
	
	@Override
	public void insert(Student student) {
		System.out.println("StudentServiceImpl의 insert 호출됨...");
		//dao를 호출한다.
		
		studentDAO.insert(student);
		
	}

}
