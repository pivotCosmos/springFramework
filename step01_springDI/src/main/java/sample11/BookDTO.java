package sample11;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Scope("prototype") //필요할때마다 새로운 객체 생성
public class BookDTO {
	
	@Value("springDI")
	private String subject;
	
	@Value("장희정")
	private String writer;
	
	@Value("25000")
	private int price;
	
	@Value("2022-02-02")
	private String date;
}
