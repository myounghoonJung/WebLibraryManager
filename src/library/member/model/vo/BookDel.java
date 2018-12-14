package library.member.model.vo;

import java.sql.Date;

public class BookDel extends Book {
	private int delNo;
	private Date delDate;

	public BookDel() {}

	public BookDel(int delNo, Date delDate, String bookId, String bookTitle, String author, String genre) {
		super(bookId,bookTitle,author,genre);
		this.delNo = delNo;
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return delNo + "\t" + delDate + "\t" + super.getBookId() + "\t" + super.getBookTitle() + "\t" + super.getAuthor() 
			+ "\t" + super.getGenre();
	}
	
	
	
	
}
