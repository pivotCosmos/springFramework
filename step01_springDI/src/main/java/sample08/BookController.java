package sample08;

public class BookController { //<bean class="BookController" autowire="constructor"
	private BookService bookService;
	private BookDTO book1;
	private BookDTO book2;
	
	public BookController() {}
	
	public BookController(BookService bookService, BookDTO book1, BookDTO book2) {
		this.bookService = bookService;
		this.book1 = book1;
		this.book2 = book2;
	}
	
	void invoker() {
		bookService.save(book2, book1);
	}
}
