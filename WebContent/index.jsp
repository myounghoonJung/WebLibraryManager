<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="library.model.vo.Book,
				 library.model.vo.BookDel,
				 library.model.vo.BorrowLog,
				 library.model.vo.User,
				 library.model.vo.UserQuit,
				 library.model.service.LibraryService,
				 library.model.exception.LibraryException,
				 java.util.List" %>
<% 
	List<Book> bookList = null;
	List<User> userList = null;
	
	// service단에 업무 로직 요청
	try{
		// book list 불러오기
		bookList = new LibraryService().inquiryBookAll();
		System.out.println("bookList@index.jsp"+bookList);
	
	
		
	}
	catch(LibraryException e){
		e.printStackTrace(); //로깅용 예외 출력
		throw new Exception("도서관리 프로그램 index 페이지 오류!");
		
	}
	
   %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 관리 프로그램(관리자전용)</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<script>
$(function(){
	//도서 추가버튼 이벤트핸들러
	$("#btn-add").on("click",function(){
		location.href = "<%=request.getContextPath()%>/jsp/library/libraryInsertForm.jsp";
	});
});
</script>
<style>
div#container {
	/* border:1px solid black; */
	width:95%; 
	margin:auto; 
	padding:20px; 
	text-align:center; 
}
section{
	float:left;
}
section#tbl-container{
	/* border:1px solid black; */
	width:70%; 
	text-align:center; 
	padding: 0 30px 30px
}
section#tbl-container table{
	/* border:1px solid tomato; */
	border-collapse:collapse;
	width: 100%;
}
section#tbl-container table th, section#tbl-container table td {
	border:1px solid tomato;
	padding:5px;
}
section#srch-container{
	/* border:1px solid black; */
	width:25%; 
	height: 300px;
	text-align:left; 
	padding:30px 30px 100px 30px; 
}
button#btn-add{
	float: right;
	margin:10px 0;
}
/*마우스 오버시 컬러변경 효과*/
section#tbl-container table tr:hover td{
	background : tomato;
	color: white;
	cursor: pointer;
	font-weight: bold;
}

</style>
</head>
<body>
	<div id="container">
		<h2>도서관리 프로그램</h2>
		<section id="tbl-container">
			<h3>도서현황</h3>
			<table id="book">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>저자</th>
						<th>출판사</th>
						<th>장르</th>
						<th>대출여부</th>
					</tr>
				</thead>
				<tbody>
					<%
						if(!bookList.isEmpty()){
							for(Book b : bookList){
					%>
					<tr bid="<%=b.getBookNo() %>">
						<td><%=b.getBookNo() %></td>
						<td><%=b.getBookTitle() %></td>
						<td><%=b.getAuthor() %></td>
						<td><%=b.getPublisher() %></td>
						<td><%=b.getGenre() %></td>
						<td><%=b.getStatus() %></td>
					</tr>
					<%
							}
						}
						else {
					%>
					<tr>
						<td colspan="6">데이터가 존재하지 않습니다.</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<button id="btn-add">상품추가</button>
		</section>
	</div>
	
	
	
	
	
</body>
</html>