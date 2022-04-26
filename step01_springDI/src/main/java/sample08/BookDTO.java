package sample08;

public class BookDTO { //<bean class="BookDTO" p:
	private String subject;
	private String writer;
	private int price;
	private String date;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return subject + " | " + writer + " | " + price + " | "  + date;
	}
}
