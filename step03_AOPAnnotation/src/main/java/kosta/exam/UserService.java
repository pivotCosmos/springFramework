package kosta.exam;

import org.springframework.stereotype.Service;

@Service("service")
public class UserService {
	public String testHello() {
		System.out.println("UserService의 testHello() 핵심기능입니다...");
		try {
			Thread.sleep(1300);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return "안녕하세요";
	}
	
	public void insertHello(int i, int j) {
		System.out.println("UserService의 insertHello(int i, int j) 핵심기능입니다...");
		try {
			Thread.sleep(2500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
