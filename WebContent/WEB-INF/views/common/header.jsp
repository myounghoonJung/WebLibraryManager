<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="library.member.model.vo.*"%>
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
	$("div#loginbtn-container input").on("click",function(){
		location.href = "<%=request.getContextPath()%>/member/loginPage";
	});
	
	// 로그아웃 버튼 클릭 이벤트리스너
	$("div#loggedinbtn-container input").on("click",function(){
		location.href = "<%=request.getContextPath()%>/member/logout";
	});
	
	// 메뉴 클릭(링크이동) 이벤트리스너
	$("#mainmenu li").on("click",function(){
		console.log($(this)[0] == $("#li-memberManagement")[0]);
		if($(this)[0] == $("#li-notice")[0]){
			location.href="<%=request.getContextPath()%>/";
		}
		else if($(this)[0] == $("#li-memberManagement")[0]){
			location.href="<%=request.getContextPath()%>/admin/memberList";
		}
		else if($(this)[0] == $("#li-bookManagement")[0]){
			location.href="<%=request.getContextPath()%>/";
		}
		else if($(this)[0] == $("#li-bookSearch")[0]){
			location.href="<%=request.getContextPath()%>/";
		}
		else if($(this)[0] == $("#li-library")[0]){
			location.href="<%=request.getContextPath()%>/";
		}
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
			<div id="loginbtn-container">
				<input type="button" value="로그인">
			</div>
			<!-- 로그인 전 끝 -->
			<% 
			}
			else { 
			%>
			<!-- 로그인 후 시작 -->
			<div id="loggedinbtn-container">
				<input type="button" value="로그아웃" />
			</div>
			<!-- 로그인 후 끝 -->
			<%
			}
			%>
			<!-- 메인메뉴 시작 -->
			<nav id="mainmenu">
				<ul>
					<li id="li-notice">공지사항</li>
					<%
					// 로그인한 사용자가 관리자일 때 보여줄 메뉴
					if (loggedinMember!=null && loggedinMember.getMemberId().equals("admin")) {
					%>
					<li id="li-memberManagement">회원 관리</li>
					<li id="li-bookManagement">도서 관리</li>
					<% 
					}
					// 로그인한 사용자가 멤버이거나 로그인되지 않았을 때 보여줄 메뉴
					else {
					%>
					<li id="li-bookSearch">도서 검색</li>
					<li id="li-library">마이라이브러리</li>
					<%
					}
					%>
				</ul>
			</nav>
			<!-- 메인메뉴 끝 -->
		</header>
		<section id="mainsection">