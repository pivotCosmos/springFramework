package kosta.mvc.exception;

//public class MyException extends RuntimeException{ //��üũ����
public class MyException extends Exception{ //üũ����
	
	public MyException() {}
	public MyException(String message) {
		super(message);
	}
	
}
