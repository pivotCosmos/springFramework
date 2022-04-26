package sample10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component //id="boardController"
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardDTO boardDTO1;
	
	@Autowired
	private BoardDTO boardDTO2;
	
	
	void test() {
		System.out.println("BoardController의 test() 호출됨...");
		
		System.out.println("boardService = " + boardService);
		System.out.println("boardDTO1 = " + boardDTO1);
		System.out.println("boardDTO2 = " + boardDTO2);
		
		System.out.println("********************");
		boardService.select();
	}
}
