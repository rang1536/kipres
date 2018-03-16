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
					<h1>회원가입 완료</h1>
					<h2></h2>
				</div>
				
				<div>
					<p><strong>${registerRequest.userName}님	</strong>
					회원가입을 완료했습니다.</p>
					<p><a href="main">[첫 화면 이동]</a></p>
				</div>

			</div>
		</div>
	</div>
	
<c:import url="./module/footer.jsp"></c:import>