package sample10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Component //id="boardDTO"
@Scope("prototype") //디폴트는 singleton. prototype은 필요할때마다 새로 생성.
public class BoardDTO {
	
	@Value("10")
	private int no;
	
	@Value("springDI")
	private String subject;
	
	@Value("스프링신기하다.")
	private String content;
	
}
