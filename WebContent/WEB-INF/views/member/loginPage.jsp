<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function loginValidate(){
	
	return true;
}
</script>
<!-- 로그인 시작 -->
<div id="login-container">
	<form action="<%=request.getContextPath()%>/member/login" id="loginForm" method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="memberId" id="memberId" placeholder="아이디" />
				</td>
				<td>
					
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="memberPw" id="memberPw" placeholder="패스워드" />
				</td>
				<td>
					<input type="submit" value="로그인" onclick="return loginValidate();" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkbox" name="saveId" id="saveId" />
					<label for="saveId">아이디 저장</label>
					<input type="button" value="회원가입" />
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 로그인 끝 -->
