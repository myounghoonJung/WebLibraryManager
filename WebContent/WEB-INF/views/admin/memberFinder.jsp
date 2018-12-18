<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Member> list = (List<Member>)request.getAttribute("list");
	String searchType = request.getParameter("searchType");
	String searchKeyword = request.getParameter("searchKeyword");
	
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<style>
div#search-memberId{
	display: <%="memberId".equals(searchType)?"inline-block":"none"%>;
}
div#search-memberName{
	display: <%="memberName".equals(searchType)?"inline-block":"none"%>;
}
div#search-gender{
	display: <%="gender".equals(searchType)?"inline-block":"none"%>;
}
</style>
<script>
$(function(){
	
	var sid = $("div#search-memberId");
	var sname = $("div#search-memberName");
	var sgender = $("div#search-gender");
	
	$("select#searchType").change(function(){
		sid.hide();
		sname.hide();
		sgender.hide();
		
		$("div#search-"+$(this).val()).css("display","inline-block");
		
	});
	
	
	
});
</script>
<section id="memberList-container">
	<h2>회원 관리</h2>
	
	<!-- 검색창 시작 -->
	<div id="search-container">
		<!-- 검색타입 시작 -->
		<select id="searchType">
			<option value="memberId" <%="memberId".equals(searchType)?"selected":"" %>>아이디</option>
			<option value="memberName" <%="memberName".equals(searchType)?"selected":"" %>>이름</option>
			<option value="gender" <%="gender".equals(searchType)?"selected":"" %>>성별</option>
		</select>
		<!-- 검색타입 끝 -->
		
		<!-- 검색키워드 시작 -->
		<!-- 아이디 검색 -->
		<div id="search-memberId">
			<form action="<%=request.getContextPath()%>/admin/memberFinder">
				<input type="hidden" name="searchType" value="memberId" />
				<input type="search" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력하세요." value="<%="memberId".equals(searchType)?searchKeyword:""%>"/>
				<input type="submit" value="검색" />
			</form>
		</div>
		<!-- 이름 검색 -->
		<div id="search-memberName">
			<form action="<%=request.getContextPath()%>/admin/memberFinder">
				<input type="hidden" name="searchType" value="memberName" />
				<input type="search" name="searchKeyword" size="25" placeholder="검색할 이름을 입력하세요." value="<%="memberName".equals(searchType)?searchKeyword:""%>"/>
				<input type="submit" value="검색" />
			</form>
		</div>
		<!-- 성별 검색 -->
		<div id="search-gender">
			<form action="<%=request.getContextPath()%>/admin/memberFinder">
				<input type="hidden" name="searchType" value="gender" />
				<input type="radio" name="searchKeyword" value="M" id="gender0" <%="gender".equals(searchType) && "M".equals(searchKeyword)?"checked":""%>/><label for="gender0">남</label>
				<input type="radio" name="searchKeyword" value="F" id="gender1" <%="gender".equals(searchType) && "F".equals(searchKeyword)?"checked":""%>/><label for="gender1">여</label>
				<input type="submit" value="검색" />
			</form>
		</div>
		<!-- 검색키워드 끝 -->
	</div>
	<!-- 검색창 끝 -->
	
	<!-- 검색결과 시작 -->
	<table id="tbl-member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>생년월일</th>
				<th>전화번호</th>
				<th>최애장르</th>
				<th>현재대여권수</th>
				<th>역대대여권수</th>
				<th>회원가입일</th>
			</tr>
		</thead>
		<tbody>
			<% if(list == null || list.isEmpty()) { %>
			<tr>
				<td colspan="9">검색결과가 없습니다.</td>
			</tr>
			<% }
			else {
				for(Member m : list) { %>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/member/memberView?memberId=<%=m.getMemberId()%>">
						<%=m.getMemberId() %>
					</a>
				</td>
				<td><%=m.getMemberName() %></td>
				<td><%="M".equals(m.getGender())?"남":"여" %></td>
				<td><%=m.getBirthday() %></td>
				<td><%=m.getPhone() %></td>
				<td><%=m.getFavoriteGenre() %></td>
				<td><%=m.getPresentBorrowCount() %></td>
				<td><%=m.getHistoryBorrowCount() %></td>
				<td><%=m.getEnrollDate() %></td>
			</tr>
			<% }
			} %>
		</tbody>
	</table>
	<!-- 검색결과 끝 -->
	
</section>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>