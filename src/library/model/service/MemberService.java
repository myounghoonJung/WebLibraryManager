package library.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import library.model.dao.MemberDao;
import library.model.vo.Member;

public class MemberService {

	public String loginCheck(Member m) {
		String sResult = "";
		
		Connection conn = getConnection();
		
		sResult = new MemberDao().loginCheck(conn, m);
		
		close(conn);
		
		return sResult;
	}

	public Member selectOne(String memberId) {
		Member m = null;
		
		Connection conn = getConnection();
		
		m = new MemberDao().selectOne(conn, memberId);
		
		close(conn);
		
		return m;
	}

}
