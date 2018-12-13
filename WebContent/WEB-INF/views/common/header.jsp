<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="library.model.vo.Member,
				 java.util.List" %>
<% 
	Member loggedinMember = (Member)session.getAttribute("loggedinMember");

	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kh 도서 대여 프로그램</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<script>
$(function(){
	// 로그인 버튼 클릭 이벤트리스너
	$("div#login-container input").on("click",function(){
		location.href = "<%=request.getContextPath()%>/member/loginPage";
	});
	
	// 로그아웃 버튼 클릭 이벤트리스너
	$("div#loggedin-container input").on("click",function(){
		location.href = "<%=request.getContextPath()%>/member/logout";
	});
});
</script>
</head>
<body>
	<div id="container">
		<header>
			<h1 id="title">kh 도서 대여 프로그램</h1>
			<% 
			if(loggedinMember == null) { 
			%>
			<!-- 로그인 전 시작 --> 
			<div id="login-container">
				<input type="button" value="로그인">
			</div>
			<!-- 로그인 전 끝 -->
			<% 
			}
			else {
			%>
			<!-- 로그인 후 시작 -->
			<div id="loggedin-container">
				<input type="button" value="로그아웃" />
			</div>
			<!-- 로그인 후 끝 -->
			<%
			}
			%>
			<!-- 메인메뉴 시작 -->
			<nav>
				<ul>
					<li>공지사항</li>
					<% // 로그인한 사용자가 멤버일 때 보여줄 메뉴
					if(!loggedinMember.getMemberId().equals("admin")){
					%>
					<li>도서 검색</li>
					<li>마이 라이브러리</li>
					<%
					}
					// 로그인한 사용자가 관리자일 때 보여줄 메뉴
					else {
					%>
					<li>회원 관리</li>
					<li>도서 관리</li>
					<% } %>
				</ul>
			</nav>
			<!-- 메인메뉴 끝 -->
		</header>
		<section>