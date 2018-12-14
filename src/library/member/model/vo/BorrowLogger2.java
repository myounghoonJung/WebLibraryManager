package library.member.model.vo;

import java.sql.Date;

public class BorrowLogger2 {
	private int logNo;
	private Date logDate;
	private int bookId;
	private String bookTitle;
	private String author;
	private String genre;
	private Date borrowDate;
	private Date untilBorrowDate;
	private Date returnDate;
	private String status;
	private String borrowMemberId;
	
	public BorrowLogger2() {}

	public BorrowLogger2(int logNo, Date logDate, int bookId, String bookTitle, String author, String genre,
			Date borrowDate, Date untilBorrowDate, Date returnDate, String status, String borrowMemberId) {
		this.logNo = logNo;
		this.logDate = logDate;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.borrowDate = borrowDate;
		this.untilBorrowDate = untilBorrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.borrowMemberId = borrowMemberId;
	}

	public int getLogNo() {
		return logNo;
	}

	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
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

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getUntilBorrowDate() {
		return untilBorrowDate;
	}

	public void setUntilBorrowDate(Date untilBorrowDate) {
		this.untilBorrowDate = untilBorrowDate;
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

	public String getBorrowMemberId() {
		return borrowMemberId;
	}

	public void setBorrowMemberId(String borrowMemberId) {
		this.borrowMemberId = borrowMemberId;
	}

	@Override
	public String toString() {
		return logNo + "\t" + logDate + "\t" + bookId + "\t"
				+ bookTitle + "\t" + author + "\t" + genre + "\t" + borrowDate
				+ "\t" + untilBorrowDate + "\t" + returnDate + "\t" + status
				+ "\t" + borrowMemberId;
	}
	
	
	
	
}
