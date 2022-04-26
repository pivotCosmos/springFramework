package sample04;

public class Student {
	private String name;
	private int no;
	private String phone;
	private String addr;
	
	public Student() {
		System.out.println("Student 기본생성자 호출되었습니다.");
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Student의 setName(String name) call , name = " + name);
	}

	public void setNo(int no) {
		this.no = no;
		System.out.println("Student의 setNo(int no) call , no = " + no);
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("Student의 setPhone(String phone) call , phone = " + phone);
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("Student의 setAddr(String addr) call , addr = " + addr);
	}
	
	@Override
	public String toString() {
		return name + " | " + no + " | " + phone + " | " + addr;
	}
	
}
