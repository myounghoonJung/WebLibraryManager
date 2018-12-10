package library.model.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import library.model.exception.LibraryException;
import library.model.vo.Book;
import library.model.vo.BookDel;
import library.model.vo.BorrowLog;
import library.model.vo.User;
import library.model.vo.UserQuit;

public class LibraryDao {

	private Properties prop = new Properties();

	public LibraryDao() throws LibraryException {

		try {
			String fileName = LibraryDao.class.getResource("/query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
			throw new LibraryException("LibraryDao생성자  오류 : " + e.getMessage());
		}
	}

	public int insertBook(Connection conn, Book b) throws LibraryException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBook");
		int result = 0;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBookNo());
			pstmt.setString(2, b.getBookTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setString(5, b.getGenre());

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (Exception e) {
			throw new LibraryException("insertBook Error!!", e);
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteBook(Connection conn, String bookNo) throws LibraryException {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteBook");
		int result = 0;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNo);

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (Exception e) {
			throw new LibraryException("deleteBook Error!!", e);
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertUser(Connection conn, User u) throws LibraryException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertUser");
		int result = 0;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPw());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getGender());
			pstmt.setInt(5, u.getAge());
			pstmt.setString(6, u.getPhone());

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (Exception e) {
			throw new LibraryException("inserUser Error!!", e);
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteUser(Connection conn, String userId) throws LibraryException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteUser");
		int result = 0;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (Exception e) {
			throw new LibraryException("deleteUser Error!!", e);
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int borrowBook(Connection conn, String userId, String bookNo) throws LibraryException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("borrowBook");
		int result = 0;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, bookNo);

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (Exception e) {
			throw new LibraryException("borrowBook Error!!", e);
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int returnBook(Connection conn, String bookNo) throws LibraryException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("returnBook");
		int result = 0;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNo);

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (Exception e) {
			throw new LibraryException("returnBook Error!!", e);
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<Book> inquiryBookAll(Connection conn) throws LibraryException {

		Statement stmt = null;
		String query = prop.getProperty("inquiryBookAll");
		ResultSet rset = null;
		List<Book> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("bookno"));
				b.setBookTitle(rset.getString("booktitle"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setGenre(rset.getString("genre"));
				b.setBorrowDate(rset.getDate("borrowdate"));
				b.setReturnDate(rset.getDate("returndate"));
				b.setStatus(rset.getString("status"));
				b.setBorrowUserId(rset.getString("borrowuserid"));

				list.add(b);
			}

		} catch (Exception e) {
			throw new LibraryException("inquiryBookAll Error!!", e);
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public List<Book> inquiryBookOnBorrow(Connection conn) throws LibraryException {

		Statement stmt = null;
		String query = prop.getProperty("inquiryBookOnBorrow");
		ResultSet rset = null;
		List<Book> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("bookno"));
				b.setBookTitle(rset.getString("booktitle"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setGenre(rset.getString("genre"));
				b.setBorrowDate(rset.getDate("borrowdate"));
				b.setReturnDate(rset.getDate("returndate"));
				b.setStatus(rset.getString("status"));
				b.setBorrowUserId(rset.getString("borrowuserid"));

				list.add(b);
			}

		} catch (Exception e) {
			throw new LibraryException("inquiryBookOnBorrow Error!!", e);
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public List<Book> inquiryBookDel(Connection conn) throws LibraryException {

		Statement stmt = null;
		String query = prop.getProperty("inquiryBookDel");
		ResultSet rset = null;
		List<Book> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				BookDel bd = new BookDel();

				bd.setBookNo(rset.getString("bookno"));
				bd.setBookTitle(rset.getString("booktitle"));
				bd.setAuthor(rset.getString("author"));
				bd.setPublisher(rset.getString("publisher"));
				bd.setGenre(rset.getString("genre"));
				bd.setDelDate(rset.getDate("deldate"));

				list.add(bd);
			}

		} catch (Exception e) {
			throw new LibraryException("inquiryBookDel Error!!", e);
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public int updateUser(Connection conn, String colName, String updateData, String userId) throws LibraryException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateUser").replace("*colName*", colName);
		int result = 0;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, updateData);
			pstmt.setString(2, userId);

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (Exception e) {
			throw new LibraryException("updateUser Error!!", e);
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<User> inquiryUserAll(Connection conn) throws LibraryException {
		Statement stmt = null;
		String query = prop.getProperty("inquiryUserAll");
		ResultSet rset = null;
		List<User> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				User u = new User();

				u.setUserId(rset.getString("userid"));
				u.setUserPw(rset.getString("userpw"));
				u.setUserName(rset.getString("username"));
				u.setGender(rset.getString("gender"));
				u.setAge(rset.getInt("age"));
				u.setPhone(rset.getString("phone"));
				u.setBorrowPresentCount(rset.getInt("borrowpresentcount"));
				u.setBorrowHistoryCount(rset.getInt("borrowhistorycount"));
				u.setEnrollDate(rset.getDate("enrolldate"));

				list.add(u);
			}

		} catch (Exception e) {
			throw new LibraryException("inquiryUserAll Error!!", e);
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public List<Book> inquiryBookOnBorrow(Connection conn, String userId) throws LibraryException {

		PreparedStatement pstmt = null;
		String query = prop.getProperty("inquiryBookOnBorrowUser");
		ResultSet rset = null;
		List<Book> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("bookno"));
				b.setBookTitle(rset.getString("booktitle"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setGenre(rset.getString("genre"));
				b.setBorrowDate(rset.getDate("borrowdate"));
				b.setReturnDate(rset.getDate("returndate"));
				b.setStatus(rset.getString("status"));
				b.setBorrowUserId(rset.getString("borrowuserid"));

				list.add(b);
			}

		} catch (Exception e) {
			throw new LibraryException("inquiryBookOnBorrow Error!!", e);
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> inquiryBorrowLog(Connection conn, String userId) throws LibraryException {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("inquiryBorrowLog");
		ResultSet rset = null;
		List<Book> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				BorrowLog bl = new BorrowLog();

				bl.setLogNo(rset.getInt("logno"));
				bl.setLogDate(rset.getDate("logdate"));
				bl.setBookNo(rset.getString("bookno"));
				bl.setBookTitle(rset.getString("booktitle"));
				bl.setAuthor(rset.getString("author"));
				bl.setPublisher(rset.getString("publisher"));
				bl.setGenre(rset.getString("genre"));
				bl.setBorrowDate(rset.getDate("borrowdate"));
				bl.setReturnDate(rset.getDate("returndate"));
				bl.setStatus(rset.getString("status"));
				bl.setBorrowUserId(rset.getString("borrowuserid"));

				list.add(bl);
			}

		} catch (Exception e) {
			throw new LibraryException("inquiryBorrowLog Error!!", e);
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<User> inquiryUserQuit(Connection conn) throws LibraryException {
		Statement stmt = null;
		String query = prop.getProperty("inquiryUserQuit");
		ResultSet rset = null;
		List<User> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				UserQuit uq = new UserQuit();

				uq.setUserId(rset.getString("userid"));
				uq.setUserPw(rset.getString("userpw"));
				uq.setUserName(rset.getString("username"));
				uq.setGender(rset.getString("gender"));
				uq.setAge(rset.getInt("age"));
				uq.setPhone(rset.getString("phone"));
				uq.setBorrowHistoryCount(rset.getInt("borrowhistorycount"));
				uq.setEnrollDate(rset.getDate("enrolldate"));
				uq.setQuitDate(rset.getDate("quitdate"));

				list.add(uq);
			}

		} catch (Exception e) {
			throw new LibraryException("inquiryUserQuit Error!!", e);
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

}
