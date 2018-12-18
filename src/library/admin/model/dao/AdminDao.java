package library.admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import library.member.model.vo.Member;
import static library.common.JDBCTemplate.close;

public class AdminDao {
	
	private Properties prop = new Properties();
	
	public AdminDao() {
		String fileName = AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public List<Member> selectMemberList(Connection conn) {
		List<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberList");
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				
				m.setMemberId(rset.getString("memberid"));
				m.setMemberName(rset.getString("membername"));
				m.setGender(rset.getString("gender"));
				m.setBirthDay(rset.getDate("birthday"));
				m.setPhone(rset.getString("phone"));
				m.setFavoriteGenre(rset.getString("favoritegenre"));
				m.setPresentBorrowCount(rset.getInt("presentborrowcount"));
				m.setHistoryBorrowCount(rset.getInt("historyborrowcount"));
				m.setEnrollDate(rset.getDate("enrolldate"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}


	public List<Member> selectMemberByCondition(Connection conn, String searchType, String searchKeyword) {
		List<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberByCondition");
		query = query.replace("searchType", searchType);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				
				m.setMemberId(rset.getString("memberid"));
				m.setMemberName(rset.getString("membername"));
				m.setGender(rset.getString("gender"));
				m.setBirthDay(rset.getDate("birthday"));
				m.setPhone(rset.getString("phone"));
				m.setFavoriteGenre(rset.getString("favoritegenre"));
				m.setPresentBorrowCount(rset.getInt("presentborrowcount"));
				m.setHistoryBorrowCount(rset.getInt("historyborrowcount"));
				m.setEnrollDate(rset.getDate("enrolldate"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

}
