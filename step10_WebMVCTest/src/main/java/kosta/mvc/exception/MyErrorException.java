package kosta.mvc.exception;

public class MyErrorException extends Exception { //üũ���� - ����ó�� �ʼ�
//public class MyErrorException extends RuntimeException { //��üũ���� - ����ó�� ����
	public MyErrorException() {}
	public MyErrorException(String message) {
		super(message);
	}
}
