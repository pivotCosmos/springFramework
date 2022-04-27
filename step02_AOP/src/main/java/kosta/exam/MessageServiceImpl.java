package kosta.exam;

public class MessageServiceImpl implements MessageService {

	@Override
	public void korHello() {
		System.out.println("MessageServiceImpl의 korHello() 핵심기능입니다...");
		try{
			Thread.sleep(1500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void engHello() {
		System.out.println("MessageServiceImpl의 engHello() 핵심기능입니다...");
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String hello() {
		System.out.println("MessageServiceImpl의 hello() 핵심기능입니다...");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return "장희정";
	}

	@Override
	public int hello(String name) {
		System.out.println("MessageServiceImpl의 hello(String name) 핵심기능입니다...");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return 100;
	}

}
