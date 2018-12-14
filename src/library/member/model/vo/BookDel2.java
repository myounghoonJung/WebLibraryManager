package library.member.model.vo;

import java.sql.Date;

public class BookDel2 {
	private Date delDate;
	private int bookId;
	private String bookTitle;
	private String author;
	private String genre;
	
	public BookDel2() {}

	public BookDel2(Date delDate, int bookId, String bookTitle, String author, String genre) {
		this.delDate = delDate;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return delDate + "\t" + bookId + "\t" + bookTitle + "\t" + author + "\t" + genre;
	}
	
	
	
	
}
