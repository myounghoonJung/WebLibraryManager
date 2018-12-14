package library.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.member.model.service.MemberService;
import library.member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollEnd
 */
@WebServlet("/member/memberEnrollEnd")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String gender = request.getParameter("gender");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		Date birthday = Date.valueOf(year+"-"+month+"-"+day);
		String phone = request.getParameter("phone");
		String[] fGenreArr = request.getParameterValues("favoriteGenre");
		String favoriteGenre = "";
		if (fGenreArr != null) {
			for (int i=0; i<fGenreArr.length; i++) {
				favoriteGenre += fGenreArr[i];
				if (i != fGenreArr.length-1) {
					favoriteGenre += ",";
				}
			}
		}
		
		Member m = new Member(memberId, memberPw, memberName, gender, birthday, phone, favoriteGenre);
		
		int result = new MemberService().insertMember(m);
		
		String msg = "";
		String loc = "/";
		
		if (result > 0) {
			msg = "회원가입에 성공하였습니다.";
		}
		else {
			msg = "회원가입에 실패하였습니다.";
			loc = "/member/memberEnroll";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
