package library.model.vo;

import java.sql.Date;

public class BorrowLogger {
	private int logNo;
	private Date logDate;
	private Date borrowDate;
	private Date untilBorrowDate;
	private Date returnDate;
	private String status;
	private Book b = new Book();
	private Member m = new Member();
	
	public BorrowLogger() {}

	// 도서 대여용 생성자
	public BorrowLogger(int logNo, Date logDate, int bookId, String bookTitle, String author, String genre,
			Date borrowDate, Date untilBorrowDate, String status, String borrowMemberId) {
		this.logNo = logNo;
		this.logDate = logDate;
		b.setBookId(bookId);
		b.setBookTitle(bookTitle);
		b.setAuthor(author);
		b.setGenre(genre);
		this.borrowDate = borrowDate;
		this.untilBorrowDate = untilBorrowDate;
		this.status = status;
		m.setMemberId(borrowMemberId);
	}
	
	// 도서 반납용 생성자
		public BorrowLogger(int logNo, Date logDate, int bookId, String bookTitle, String author, String genre,
				Date returnDate, String status, String borrowMemberId) {
			this.logNo = logNo;
			this.logDate = logDate;
			b.setBookId(bookId);
			b.setBookTitle(bookTitle);
			b.setAuthor(author);
			b.setGenre(genre);
			this.returnDate = returnDate;
			this.status = status;
			m.setMemberId(borrowMemberId);
		}
	
	// 조회용 생성자
	public BorrowLogger(int logNo, Date logDate, int bookId, String bookTitle, String author, String genre,
			Date borrowDate, Date untilBorrowDate, Date returnDate, String status, String borrowMemberId) {
		this.logNo = logNo;
		this.logDate = logDate;
		b.setBookId(bookId);
		b.setBookTitle(bookTitle);
		b.setAuthor(author);
		b.setGenre(genre);
		this.borrowDate = borrowDate;
		this.untilBorrowDate = untilBorrowDate;
		this.returnDate = returnDate;
		this.status = status;
		m.setMemberId(borrowMemberId);
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


	@Override
	public String toString() {
		return logNo + "\t" + logDate + "\t" + b.getBookId() + "\t"
				+ b.getBookTitle() + "\t" + b.getAuthor() + "\t" + b.getGenre() + "\t" + borrowDate
				+ "\t" + untilBorrowDate + "\t" + returnDate + "\t" + status
				+ "\t" + m.getMemberId();
	}
	
	
	
	
}
