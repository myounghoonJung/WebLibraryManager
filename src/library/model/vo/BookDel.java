package library.model.vo;

import java.sql.Date;

public class BookDel extends Book {

	public BookDel() {}

	public BookDel(int bookId, String bookTitle, String author, String genre, Date delDate) {
		super(bookId,bookTitle,author,genre,delDate);
	}

	@Override
	public String toString() {
		return super.getBookId() + "\t" + super.getBookTitle() + "\t" + super.getAuthor() 
			+ "\t" + super.getGenre() + "\t" + super.getDeldate();
	}
	
	
	
	
}
