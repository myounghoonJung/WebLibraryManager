package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.model.service.MemberService;
import library.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		System.out.printf("[ %s | %s ] @MemberLoginServlet\n",memberId,memberPw);
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
				
		String sResult = new MemberService().loginCheck(m);
		System.out.println("로그인 결과 [" + sResult + "] @MemberLoginServlet");
		
		if(sResult.equals("LOGIN_OK")) {
			// 아이디 저장 관련 : 쿠키
			
			
			// 온전한 멤버정보를 가져오기 위한 처리
			m = new MemberService().selectOne(memberId);
			
			// request객체는 생명주기가 짧기때문에 로그인정보를 온전히 보전할 수 없음.
			// 따라서 session객체에 담아서 정보 전달
			// getSession(true) : 기본값. 세션이 있으면 해당 세션을 반납. 없으면 새로 생성 후 반납
			// getSession(false) : 세션이 있으면 해당 세션을 반납. 없으면 null을 반납
			HttpSession session = request.getSession(true);
			System.out.printf("세션객체 아이디 [ %s ] @MemberLoginServlet\n",session.getId());
			
			// 로그인 정보 유지시간 설정. 단위(초)
			session.setMaxInactiveInterval(10*60);
			
			// 로그인 로그 기록하기위한 ip 어트리뷰트 설정
			String ip = request.getRemoteAddr();
			System.out.printf("로그인 ip [ %s ] @MemberLoginServlet\n",ip);
			session.setAttribute("ip", ip);
			
			// 로그인한 회원정보 어트리뷰트 설정
			session.setAttribute("loggedinMember", m);
			
			// 인덱스로 페이지 리다이렉트
			response.sendRedirect(request.getContextPath());
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
