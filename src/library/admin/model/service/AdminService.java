package library.admin.model.service;

import java.sql.Connection;
import java.util.List;

import library.admin.model.dao.AdminDao;
import library.member.model.vo.Member;
import static library.common.JDBCTemplate.*;

public class AdminService {

	public List<Member> selectMemberList() {
		List<Member> list = null;
		
		Connection conn = getConnection();
		
		list = new AdminDao().selectMemberList(conn);
		
		close(conn);
		
		return list;
	}

	public List<Member> selectMemberByCondition(String searchType, String searchKeyword) {
		List<Member> list = null;
		
		Connection conn = getConnection();
		
		list = new AdminDao().selectMemberByCondition(conn,searchType,searchKeyword);
		
		close(conn);
		
		return list;
	}

}
