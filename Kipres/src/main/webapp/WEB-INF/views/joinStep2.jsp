<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​

<c:import url="./module/header.jsp"></c:import>
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
					<form action="joinStep3" method="post">
						<p>
							<label> 아이디 :<br/>
							<input type="text" name="userId" id="userId">
							</label>
						</p>
						<p>
							<label> 비밀번호 :<br/>
							<input type="password" name="userPw" id="userPw">
							</label>
						</p>
						<p>
							<label> 비밀번호 확인:<br/>
							<input type="password" name="confirmUserPw" id="confirmUserPw">
							</label>
						</p>
						<p>
							<label> 이름:<br/>
							<input type="text" name="userName" id="userName">
							</label>
						</p>
						<p>
							<label> 휴대폰 번호:<br/>
							<input type="text" name="userHP" id="userHP">
							</label>
						</p>
						<p>
							<label> 이메일:<br/>
							<input type="text" name="userMail" id="userMail">
							</label>
						</p>
						<input type="submit" value="가입 완료">
					</form>
				</div>

			</div>
		</div>
	</div>
	
<c:import url="./module/footer.jsp"></c:import>