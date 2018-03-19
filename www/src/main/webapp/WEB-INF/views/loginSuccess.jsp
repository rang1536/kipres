<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​

<c:import url="./module/header.jsp"></c:import>

<script type="text/javascript">
function Login() {
	var form = document.form1;
	
	//아이디 검사
	//아이디에서 입력 필수 조건문
	if(form.id.value == "") {
		alert("아이디를 입력해야 합니다!");
		form.id.focus();//포커스를 id박스로 이동.
		return;
	}
	
	//아이디 입력 문자수를 4~12자로 제한하는 조건문
/* 	if(form.id.value.length < 4 || form.id.value.length > 12) {
		alert("아이디는 4~12자 이내로 입력 가능합니다!");
		form.id.select();//입력한 문자를 선택 상태로 만듬.
		return;
	} */
	
	//입력된 문자의 길이만큼 루프를 돌면서 검사 
	for(i=0; i<form.id.value.length; i++) {
		var ch = form.id.value.charAt(i);//문자를 반환(정수형), 범위 검사 가능
		//입력된 문자를 검사
		if( (ch < "a" || ch > "z") && (ch < "A" || ch > "Z") && (ch < "0" || ch > "9" ) ) {
			alert("아이디는 영문 소문자로만 입력 가능 합니다!");
			form.id.select();
			return;
		}
	}
	
	// 패스워드 검사
	if (form.password.value == "") {
		alert("비밀번호를 입력 해야 합니다.");
		form.password.focus();//포커스를 Password박스로 이동.
		return;
	}
	
	//비밀번호 입력 문자수를 4~12자로 제한하는 조건문
 	if (form.password.value.length < 4 || form.password.value.length > 12) {
		alert("비밀번호는 4~12자 이내로 입력 가능 합니다.");
		form.password.select();
		return;
	}
	
	form.submit();
}
</script>

	<div id="sub_wrapper">
		<div id="sub_con_wrapper">
			<div id="left_wrapper">
				<div id="left_title">
					<span>
						고객과의 신뢰를<br>최고로 여기는 기업
					</span>
					<h2>
						MyPage
					</h2>
				</div>
				
				<ul>
					<a class="active" href="login">로그인<i class="fa fa-chevron-right"></i></a>
					<a href="joinStep1">회원가입<i class="fa fa-chevron-right"></i></a>
					<a href="findId">아이디/비밀번호 찾기<i class="fa fa-chevron-right"></i></a>
				</ul>
			</div>
			<div id="right_wrapper">
				<div id="right_path">
					<h5><i class="fa fa-home"></i>&nbsp; > 로그인</h5>
				</div>
				
				<div id="right_header">
					<h1>로그인</h1>
					<h2></h2>
				<div>
					<c:if test="${!empty authInfo}">
						${authInfo.name}님, 안녕하세요.
						<a href="logout">[로그아웃하기]</a>
						<a href="changePwd">[비밀번호 변경하기]</a>
					</c:if>
					<c:if test="${empty authInfo}">
						<a href="joinStep1">[회원가입하기]</a>
						<a href="login">[로그인하기]</a>
					</c:if>
				</div>
				</div>

			</div>
		</div>
	</div>
	
<c:import url="./module/footer.jsp"></c:import>