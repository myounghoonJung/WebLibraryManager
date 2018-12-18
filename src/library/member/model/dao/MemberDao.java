package library.member.model.dao;

import static library.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import library.member.model.vo.Member;

public class MemberDao {
	
	Properties prop = new Properties();
	
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String loginCheck(Connection conn, Member m) {
		String sResult = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("loginCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sResult = rset.getString("login_check");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return sResult;
	}

	public Member selectOne(Connection conn, String memberId) {
		Member m = new Member();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m.setMemberId(rset.getString("memberid"));
				m.setMemberPw(rset.getString("memberpw"));
				m.setMemberName(rset.getString("membername"));
				m.setGender(rset.getString("gender"));
				m.setBirthDay(rset.getDate("birthday"));
				m.setPhone(rset.getString("phone"));
				m.setFavoriteGenre(rset.getString("favoritegenre"));
				m.setPresentBorrowCount(rset.getInt("presentborrowcount"));
				m.setHistoryBorrowCount(rset.getInt("historyborrowcount"));
				m.setEnrollDate(rset.getDate("enrolldate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public int insertMember(Connection conn, Member m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setDate(5, m.getBirthday());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getFavoriteGenre());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public void logger(Connection conn, String memberId, String status, String ip) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("logger");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, status);
			pstmt.setString(3, ip);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
	}

}
