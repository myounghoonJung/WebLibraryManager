package library.member.model.vo;

import java.sql.Date;

public class Book {
	
	private String bookId; // 도서번호
	private String bookTitle; // 도서명
	private String author; // 저자
	private String genre; // 장르
	private String status; // 대여상태(B, N)
	
	public Book() {}

	// 도서 추가용 생성자
	public Book(String bookId, String bookTitle, String author, String genre, String status) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.status = status;
	}
	
	// 도서 조회용 생성자
	public Book(String bookId, String bookTitle, String author, String genre, String status, String delflag,
			Date deldate) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.status = status;
	}
	
	// BookDel용 생성자
	public Book(String bookId, String bookTitle, String author, String genre) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
	}

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return bookId + "\t" + bookTitle + "\t" + author + "\t" + genre + "\t" + status;
	}
	
//	@Override
//	public String toString() {
//		return bookId + "\t" + bookTitle + "\t" + author + "\t"
//				+ "\t" + genre + "\t" + status;
//	}
	
}
