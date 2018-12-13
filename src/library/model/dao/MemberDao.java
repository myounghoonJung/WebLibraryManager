package library.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import library.model.vo.Member;
import static common.JDBCTemplate.close;

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

}
