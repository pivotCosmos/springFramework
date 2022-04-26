package sample08;

public class BookServiceImpl implements BookService { //<bean class="BookServiceImpl" autowire="??"
	private EmailSender emailSender;
	private MessageSender messageSender;
	private BookDAO bookDao;
	
	public BookServiceImpl() {}
	
	public BookServiceImpl(BookDAO bookDao) {
		this.bookDao=bookDao;
	}
	
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Override
	public void save(BookDTO bookDTO1, BookDTO bookDTO2) {
		bookDao.save(emailSender, messageSender, bookDTO1, bookDTO2);
	}

}
