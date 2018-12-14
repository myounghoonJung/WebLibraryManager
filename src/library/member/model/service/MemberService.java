package library.member.model.service;

import static library.common.JDBCTemplate.close;
import static library.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import library.member.model.dao.MemberDao;
import library.member.model.vo.Member;

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

	public int insertMember(Member m) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new MemberDao().insertMember(conn,m);
		
		close(conn);
		
		return result;
	}

}
