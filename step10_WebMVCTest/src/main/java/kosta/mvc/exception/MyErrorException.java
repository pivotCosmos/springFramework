package kosta.mvc.exception;

public class MyErrorException extends Exception { //체크예외 - 예외처리 필수
//public class MyErrorException extends RuntimeException { //비체크예외 - 예외처리 선택
	public MyErrorException() {}
	public MyErrorException(String message) {
		super(message);
	}
}
