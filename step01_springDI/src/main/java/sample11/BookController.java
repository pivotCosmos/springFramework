package sample11;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Resource(name="bookDTO")
	private BookDTO book1;

	@Resource(name="bookDTO")
	private BookDTO book2;
	
	public void invoker() {
		bookService.save(book1, book2);
	}
}
