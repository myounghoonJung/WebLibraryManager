package library.model.vo;

import java.sql.Date;

public class Book {
	
	private int bookId; // 도서번호
	private String bookTitle; // 도서명
	private String author; // 저자
	private String genre; // 장르
	private String status; // 대여상태(B, N)
	private String delFlag; // 삭제유무(Y,N)
	private Date delDate; // 삭제날짜
	
	public Book() {}

	// 도서 추가용 생성자
	public Book(int bookId, String bookTitle, String author, String genre, String status) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.status = status;
	}
	
	// 도서 조회용 생성자
	public Book(int bookId, String bookTitle, String author, String genre, String status, String delflag,
			Date deldate) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.status = status;
		this.delFlag = delflag;
		this.delDate = deldate;
	}
	
	// BookDel용 생성자
	public Book(int bookId, String bookTitle, String author, String genre, Date delDate) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelflag() {
		return delFlag;
	}
	public void setDelflag(String delFlag) {
		this.delFlag = delFlag;
	}
	public Date getDeldate() {
		return delDate;
	}
	public void setDeldate(Date delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return bookId + "\t" + bookTitle + "\t" + author + "\t" + "\t" + genre
				+ "\t" + status + "\t" + delFlag + "\t" + delDate;
	}
	
//	@Override
//	public String toString() {
//		return bookId + "\t" + bookTitle + "\t" + author + "\t"
//				+ "\t" + genre + "\t" + status;
//	}
	
}
