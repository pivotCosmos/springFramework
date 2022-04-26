package sample02;

public class Member {
	private String id;
	private String pwd;
	private int age;
	private String addr;
	
	public Member() {
		System.out.println("Member의 기본생성자 호출됨...");
	}
	
	public Member(String id) {
		System.out.println("Member의 Member(String id) 호출됨... id = " + id);
		this.id=id;
	}
	
	public Member(String id, String pwd) {
		System.out.println("Member의 Member(String id, String pwd) 호출됨...");
		this.id=id;
		this.pwd=pwd;
	}
	
	public Member(String id, int age) {
		System.out.println("Member의 Member(String id, int age) 호출됨... " + id + " , " + age);
		this.id=id;
		this.age=age;
	}
	
	public Member(String id, int age, String addr) {
		System.out.println("Member의 Member(String id, int age, String addr) 호출됨...");
		this.id=id;
		this.age=age;
		this.addr=addr;
	}
	
	public Member(String id, String pwd, int age, String addr) {
		System.out.println("Member의 Member(String id, String pwd, int age, String addr) 호출됨...");
		this.id=id;
		this.pwd=pwd;
		this.age=age;
		this.addr=addr;
	}
	
	@Override
	public String toString() {
		return id+" | " + pwd+ " | " + age + " | " + addr;
	}
}
