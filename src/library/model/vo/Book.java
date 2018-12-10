package library.model.vo;

import java.sql.Date;

public class Book {
	
	private String bookNo; // 도서번호
	private String bookTitle; // 도서명
	private String author; // 저자
	private String publisher; // 출판사
	private String genre; // 장르

	private Date borrowDate; // 대출한 날짜
	private Date returnDate; // 대출기간은 15일
	
	private String status; // 대출상태. (B, N)

	private String borrowUserId;// 이 도서를 대출한 회원의 아이디
	
	public Book() {}

	public Book(String bookNo, String bookTitle, String author, String publisher, String genre) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
	}
	
	public Book(String bookNo, String bookTitle, String author, String publisher, String genre, Date borrowDate,
			Date returnDate, String status, String borrowUserId) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.borrowUserId = borrowUserId;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBorrowUserId() {
		return borrowUserId;
	}

	public void setBorrowUserId(String borrowUserId) {
		this.borrowUserId = borrowUserId;
	}

	@Override
	public String toString() {
		return bookNo + "\t" + bookTitle + "\t" + author + "\t" + publisher
				+ "\t" + genre + "\t" + borrowDate + "\t" + returnDate + "\t"
				+ status + "\t" + borrowUserId;
	}
	
}
