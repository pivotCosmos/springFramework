package sample03;

public class BookController {
	private BookDAO bookDao;
	private BookVo bookVo;
	
	public BookController() {}
	
	public BookController(BookDAO bookDao, BookVo bookVo) {
		System.out.println("BookController(BookDAO bookDao, BookVo bookVo) 호출...");
		this.bookDao = bookDao;
		this.bookVo = bookVo;
	}
	
	void bookInsert() {
		bookDao.insert(bookVo);
	}
}
