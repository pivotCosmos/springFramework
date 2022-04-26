package sample06;

public class Customer {
	private String id;
	private int age;
	private String addr;
	
	public Customer() {
		System.out.println("Customer의 기본생성자...");
	}
	
	public Customer(String id) {
		System.out.println("Customer(String id) 생성자 호출... , id = " + id);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		System.out.println("Customer의 setId(String id) call... , id = " + id);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("Customer의 setAge(int age) call... , age = " + age);
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("Customer의 setAddr(String addr) call... , addr = " + addr);
	}
	
	@Override
	public String toString() {
		return id + " | " + age + " | " + addr;
	}
}
