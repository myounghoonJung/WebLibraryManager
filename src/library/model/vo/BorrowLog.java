package library.model.vo;

import java.sql.Date;

public class BorrowLog extends Book {
	
	private int logNo;
	private Date logDate;
	
	public BorrowLog() {}
	
	public BorrowLog(String bookNo, String bookTitle, String author, String publisher, String genre, Date borrowDate,
			Date returnDate, String status, String borrowUserId) {
		super(bookNo, bookTitle, author, publisher, genre, borrowDate, returnDate, status, borrowUserId);
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
	
	
	@Override
	public String toString() {
		return logNo + "\t" + logDate + "\t" + super.toString();
	}
	
	

}
