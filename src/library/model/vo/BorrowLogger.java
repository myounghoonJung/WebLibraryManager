package library.model.vo;

import java.sql.Date;

public class BorrowLogger {
	private int logNo;
	private Date logDate;
	private String bookId;
	private Date borrowDate;
	private Date untilBorrowDate;
	private Date returnDate;
	private String status;
	private String memberId;
	
	public BorrowLogger() {}

	// 도서 대여용 생성자
	public BorrowLogger(int logNo, Date logDate, String bookId, Date borrowDate, Date untilBorrowDate, String status, String memberId) {
		this.logNo = logNo;
		this.logDate = logDate;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.untilBorrowDate = untilBorrowDate;
		this.status = status;
		this.memberId = memberId;
	}
	
	// 도서 반납용 생성자
		public BorrowLogger(int logNo, Date logDate, String bookId, Date returnDate, String status, String memberId) {
			this.logNo = logNo;
			this.logDate = logDate;
			this.bookId = bookId;
			this.returnDate = returnDate;
			this.status = status;
			this.memberId = memberId;
		}
	
	// 조회용 생성자
	public BorrowLogger(int logNo, Date logDate, String bookId,
			Date borrowDate, Date untilBorrowDate, Date returnDate, String status, String memberId) {
		this.logNo = logNo;
		this.logDate = logDate;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.untilBorrowDate = untilBorrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.memberId = memberId;
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

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return logNo + "\t" + logDate + "\t" + bookId + "\t" + borrowDate
				+ "\t" + untilBorrowDate + "\t" + returnDate + "\t" + status + "\t" + memberId;
	}
	
	
	
	
}
