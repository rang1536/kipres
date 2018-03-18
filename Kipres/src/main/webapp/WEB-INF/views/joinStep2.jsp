<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>​

<c:import url="./module/header.jsp"></c:import>
<script type="text/javascript">
function sendIt() {
	var form = document.joinForm;
	var email = form.userMail.value;
	var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;//이메일 형식

	//아이디 입력여부 검사
	if (form.userId.value == "") {
		alert("아이디를 입력하지 않았습니다.")
		form.userId.focus()
		return false;
	}
	
 	//아이디 유효성 검사 (영문소문자, 숫자만 허용)
	for (i = 0; i < form.userId.value.length; i++) {
		ch = form.userId.value.charAt(i)
		if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
			alert("아이디는 대소문자, 숫자만 입력가능합니다.")
			form.userId.focus()
			form.userId.select()
			return false;
		}
	}
	
	//아이디에 공백 사용하지 않기
	if (form.userId.value.indexOf(" ") >= 0) {
		alert("아이디에 공백을 사용할 수 없습니다.")
		form.userId.focus()
		form.userId.select()
		return false;
	}
	
	//아이디 길이 체크 (4~12자)
	if (form.userId.value.length<4 || form.userId.value.length>12) {
		alert("아이디를 4~12자까지 입력해주세요.")
		form.userId.focus()
		form.userId.select()
		return false;
	}
	
	//비밀번호 입력여부 체크
	if (form.userPw.value == "") {
		alert("비밀번호를 입력하지 않았습니다.")
		form.userPw.focus()
		return false;
	}
	if (form.userPw.value == form.userId.value) {
		alert("아이디와 비밀번호가 같습니다.")
		form.userPw.focus()
		return false;
	}
	//비밀번호 길이 체크(4~8자 까지 허용)
	if (form.userPw.value.length<4 || form.userPw.value.length>12) {
		alert("비밀번호를 4~12자까지 입력해주세요.")
		form.userPw.focus()
		form.userPw.select()
		return false;
	}
	//비밀번호와 비밀번호 확인 일치여부 체크
	if (form.userPw.value != form.confirmUserPw.value) {
		alert("비밀번호가 일치하지 않습니다")
		form.confirmUserPw.value = ""
		form.confirmUserPw.focus()
		return false;
	}
	
	//이메일 형식 체크
	if (form.userMail.value == "") {
		alert("이메일을 입력하지 않았습니다.")
		form.userMail.focus()
		return false;
	}
	if (regex.test(email) === false) {
		alert("잘못된 이메일 형식입니다.");
		form.userMail.value=""
		form.userMail.focus()
		return false;
	}     
	//이름 형식 2글자 이상
	if (form.userName.value == "") {
		alert("이름을 입력하지 않았습니다.")
		form.userName.focus()
		return false;
	}
	
	if(form.userName.value.length<2){
		alert("이름을 2자 이상 입력해주십시오.")
		form.userName.focus()
		return false;
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
					<a href="login">로그인<i class="fa fa-chevron-right"></i></a>
					<a class="active" href="join">회원가입<i class="fa fa-chevron-right"></i></a>
					<a href="findId">아이디/비밀번호 찾기<i class="fa fa-chevron-right"></i></a>
				</ul>
			</div>
			<div id="right_wrapper">
				<div id="right_path">
					<h5><i class="fa fa-home"></i>&nbsp; > 회원가입</h5>
				</div>
				
				<div id="right_header">
					<h1>회원 정보 입력</h1>
					<h2></h2>
				</div>
				
				<div>
					<form name="joinForm" action="joinStep3" method="post">
						<p>
							<label> 아이디 :<br/>
							<input type="text" name="userId" id="userId" value="${registerRequest.userId}">
							<c:if test="${errors.id}">Id를 입력하세요.</c:if>
							<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
							</label>
						</p>
						<p>
							<label> 비밀번호 :<br/>
							<input type="password" name="userPw" id="userPw">
							<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
							</label>
						</p>
						<p>
							<label> 비밀번호 확인:<br/>
							<input type="password" name="confirmUserPw" id="confirmUserPw">
							<c:if test="${errors.notMatch}">비밀번호가 일치하지 않습니다.</c:if>
							<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
							</label>
						</p>
						<p>
							<label> 이름:<br/>
							<input type="text" name="userName" id="userName" value="${registerRequest.userName}">
							<c:if test="${errors.name}">이름을 입력하세요.</c:if>
							</label>
						</p>
						<p>
							<label> 휴대폰 번호:<br/>
							<input type="text" name="userHP" id="userHP" value="${registerRequest.userHP}">
							<c:if test="${errors.hp}">휴대폰 번호를 입력하세요.</c:if>
							</label>
						</p>
						<p>
							<label> 이메일:<br/>
							<input type="text" name="userMail" id="userMail" value="${registerRequest.userMail}">
							<c:if test="${errors.mail}">이메일을 입력하세요.</c:if>
							</label>
						</p>
						<input type="button" value="회원가입" onclick="sendIt()">
						<input type="reset" value="다시 입력">
					</form>
				</div>

			</div>
		</div>
	</div>
	
<c:import url="./module/footer.jsp"></c:import>
