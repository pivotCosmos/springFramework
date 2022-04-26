package sample01;

public class MessageEnImpl implements MessageBean {
	
	public MessageEnImpl() {
		System.out.println("MessageEnImpl 기본생성자 호출됨......");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("How are you? "+name);
	}

}
