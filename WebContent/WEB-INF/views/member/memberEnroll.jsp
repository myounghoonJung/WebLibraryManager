<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script>
/*
 *  회원가입 유효성 검사
 */
 function enrollValidate(){
	/* // 아이디
	if ($("#memberId")).val().trim().length < 4){
		alert("아이디는 4글자 이상");
		return false;
	}
	
	var regExpName = /^[가-힣]{2,}$/;
	if (!regExpName.test($("#memberName").val())){
		alert("이름은 한글이고 두 글자이상이어야 합니다.");
		return false;
	}
	
	if($("#phone").val().length != 11){
		alert("핸드폰번호를 확인해주세요.");
		return false;
	}
	
	// 아이디 중복검사여부 체크
	var idValid = $("#idValid").val();
	if(idValid==0){
		alert("아이디 중복검사를 해주세요.");
		return false;
	} */
	
	return true;
}

function checkIdDuplicate(){
	var memberId = $("#memberId").val().trim();
	
	// 아이디 중복검사시에도 유효성검사 해야함
	if(memberId.length < 4){
		alert("아이디는 4글자 이상");
		return;
	}
	
	// 현 페이지에서는 폼을 전송할 수 없기 때문에 팝업창을 띄우고 그곳에서 폼 전송
	var target = "checkIdDuplicate";
	// open의 첫 번째 인자 url은 생략. form의 action값이 이를 대신한다.
	var popup = open("",target,"left=300px, top=100px, height=250px, width=350px");
	
	// input:hidden이 담겨있는 폼에 바로 접근할 수 있음
	checkIdDuplicateForm.memberId.value = memberId;
	checkIdDuplicateForm.target = target;
	checkIdDuplicateForm.submit();
}
</script>
<form action="<%=request.getContextPath()%>/member/checkIdDuplicate" name="checkIdDuplicateForm" method="post">
	<input type="hidden" name="memberId" />
</form>
<section id="enroll-container">
	<h2>회원가입 정보 입력</h2>
	<h3>회원가입 유효성 검사 완성해야함</h3>
	<form action="<%=request.getContextPath()%>/member/memberEnrollEnd"	name="memberEnrollForm" method="post" onsubmit="return enrollValidate();">
		<table>
			<tr>
				<td>아이디 <span class="reqired">*</span></td>
				<td>
					<input type="text" name="memberId" id="memberId" required/>
					<input type="button" value="중복검사" onclick="checkIdDuplicate();" />
				</td>
			</tr>
			<tr>
				<td>패스워드 <span class="reqired">*</span></td>
				<td><input type="password" name="memberPw" id="memberPw" required/></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input type="password" name="memberPw2" id="memberPw2" required/></td>
			</tr>
			<tr>
				<td>이름 <span class="reqired">*</span></td>
				<td><input type="text" name="memberName" id="memberName" required/></td>
			</tr>
			<tr>
				<td>성별 <span class="reqired">*</span></td>
				<td>
					<input type="radio" name="gender" id="gender0" value="M" checked/><label for="gender0">남</label>
					<input type="radio" name="gender" id="gender1" value="F"/><label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<td>생년월일 <span class="reqired">*</span></td>
				<td>
					<select name="year" id="year">
						<%
						for (int i=2018; i>1900; i--){
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
						}
						%>
					</select>
					년
					<select name="month" id="month">
						<%
						for (int i=1; i<13; i++){
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
						}
						%>
					</select>
					월
					<select name="day" id="day">
						<%
						for (int i=1; i<32; i++){
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
						}
						%>
					</select>
					일
				</td>
			</tr>
			<tr>
				<td>전화번호 <span class="reqired">*</span></td>
				<td><input type="tel" name="phone" id="phone" required/></td>
			</tr>
			<tr>
				<td>최애 장르</td>
				<td>
					<input type="checkbox" name="favoriteGenre" id="genre0" value="소설" /><label for="genre0">소설</label>
					<input type="checkbox" name="favoriteGenre" id="genre1" value="인문" /><label for="genre1">인문</label>
					<input type="checkbox" name="favoriteGenre" id="genre2" value="문학" /><label for="genre2">문학</label>
					<input type="checkbox" name="favoriteGenre" id="genre3" value="역사" /><label for="genre3">역사</label>
					<input type="checkbox" name="favoriteGenre" id="genre4" value="사회" /><label for="genre4">사회</label>
					<br>
					<input type="checkbox" name="favoriteGenre" id="genre5" value="과학" /><label for="genre5">과학</label>
					<input type="checkbox" name="favoriteGenre" id="genre6" value="자기계발" /><label for="genre6">자기계발</label>
					<input type="checkbox" name="favoriteGenre" id="genre7" value="만화" /><label for="genre7">만화</label>
					<input type="checkbox" name="favoriteGenre" id="genre8" value="여행" /><label for="genre8">여행</label>
					<input type="checkbox" name="favoriteGenre" id="genre9" value="IT" /><label for="genre9">IT</label>
				</td>
			</tr>
		</table>
		<input type="submit" value="회원가입" />
		<input type="reset" value="초기화" />
	</form>
</section>



<%@ include file="/WEB-INF/views/common/footer.jsp" %>