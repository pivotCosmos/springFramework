package kosta.mvc.dto;

public class Member {
	private String id;
	private String name;
	private int age;
	private String addr;
	
	private boolean state;//<input type="checkbox"
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
		System.out.println("setId(String id) call , id = " + id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setName(String name) call , name = " + name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		System.out.println("setAge(int age) call , age = " + age);
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("setAddr(String addr) call , addr = " + addr);
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
		System.out.println("setState(boolean state) call , state = " + state);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}
	
	
}
