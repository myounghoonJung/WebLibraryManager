<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message");
	String loc = (String)request.getAttribute("loc");
	System.out.printf("message=%s , loc%s\n",message,loc);
%>
<script>
alert("<%=message%>");
location.href= "<%=request.getContextPath()+loc%>";
</script>