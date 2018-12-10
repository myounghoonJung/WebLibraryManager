package library.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import library.model.dao.LibraryDao;
import library.model.exception.LibraryException;
import library.model.vo.Book;
import library.model.vo.BookDel;
import library.model.vo.User;

public class LibraryService {

	public int insertBook(Book book) throws LibraryException {
		Connection conn = getConnection();
		
		int result = new LibraryDao().insertBook(conn, book);
		
		close(conn);
		
		return result;
	}
	
	public int deleteBook(String bookNo) throws LibraryException {
		Connection conn = getConnection();
		
		int result = new LibraryDao().deleteBook(conn, bookNo);
		
		close(conn);
		
		return result;
	}

	public int insertUser(User user) throws LibraryException {
		Connection conn = getConnection();
		
		int result = new LibraryDao().insertUser(conn, user);
		
		close(conn);
		
		return result;
	}
	
	public int deleteUser(String userId) throws LibraryException {
		Connection conn = getConnection();
		
		int result = new LibraryDao().deleteUser(conn, userId);
		
		close(conn);
		
		return result;
	}
	

	public int borrowBook(String userId, String bookNo) throws LibraryException {
		Connection conn = getConnection();
		
		int result = new LibraryDao().borrowBook(conn, userId, bookNo);
		
		close(conn);
		
		return result;
	}

	public int returnBook(String bookNo) throws LibraryException {
		Connection conn = getConnection();
		
		int result = new LibraryDao().returnBook(conn, bookNo);
		
		close(conn);
		
		return result;
	}

	public List<Book> inquiryBookAll() throws LibraryException {
		Connection conn = getConnection();
		
		List<Book> list = new LibraryDao().inquiryBookAll(conn);
		
		close(conn);
		
		return list;
	}

	public List<Book> inquiryBookOnBorrow() throws LibraryException {
		Connection conn = getConnection();
		
		List<Book> list = new LibraryDao().inquiryBookOnBorrow(conn);
		
		close(conn);
		
		return list;
	}

	public List<Book> inquiryBookDel() throws LibraryException {
		Connection conn = getConnection();
		
		List<Book> list = new LibraryDao().inquiryBookDel(conn);
		
		close(conn);
		
		return list;
	}

	public int updateUser(String colName, String updateData, String userId) throws LibraryException {
		Connection conn = getConnection();
		
		int result = new LibraryDao().updateUser(conn, colName, updateData, userId);
		
		close(conn);
		
		return result;
	}

	public List<User> inquiryUserAll() throws LibraryException {
		Connection conn = getConnection();
		
		List<User> list = new LibraryDao().inquiryUserAll(conn);
		
		close(conn);
		
		return list;
	}

	public List<Book> inquiryBookOnBorrow(String userId) throws LibraryException {
		Connection conn = getConnection();
		
		List<Book> list = new LibraryDao().inquiryBookOnBorrow(conn, userId);
		
		close(conn);
		
		return list;
	}

	public List<Book> inquiryBorrowLog(String userId) throws LibraryException {
		Connection conn = getConnection();
		
		List<Book> list = new LibraryDao().inquiryBorrowLog(conn, userId);
		
		close(conn);
		
		return list;
	}

	public List<User> inquiryUserQuit() throws LibraryException {
		Connection conn = getConnection();
		
		List<User> list = new LibraryDao().inquiryUserQuit(conn);
		
		close(conn);
		
		return list;
	}


	

	

	

}
