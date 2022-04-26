package sample07;

public class MemberVO {
	private String name;
	private int age;
	private String addr;
	
	public MemberVO() {
		System.out.println("MemberVO의 기본생성자...");	
	}

	public MemberVO(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
		System.out.println("MemberVO(String name, int age, String addr) 생성자 호출...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("MemberVo의 setName(String name) call , name = " + name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("MemberVo의 setAge(int age) call , age = " + age);
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("MemberVo의 setAddr(String addr) call , addr = " + addr);
	}
	
}
