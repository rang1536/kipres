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
					<h2>아이디와 비밀번호를 입력하세요.</h2>
				</div>
				
				<div>
					<h2>로그인</h2>
					    <form action="login" method="post">
					    <c:if test="${errors.idOrPwNotMatch}">아이디와 비밀번호가 일치하지 않습니다.</c:if>
					        <table border="1" width="400px">
					            <tr>
					                <td>아이디</td>
					                <td><input name="id" id="id" value="${param.id}">
					                <c:if test="${errors.id}">ID를 입력하세요.</c:if>
					                </td>
					            </tr>
					            <tr>
					                <td>비밀번호</td>
					                <td><input type="password" name="password" id="password" >
					                <c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
					                </td>
					            </tr>
					            <tr>
					                <td colspan="2" align="center">
					                    <input type="submit" value="로그인">
					                    <a href="joinStep1">회원가입</a>
					                </td>
					            </tr>
					        </table>
					    </form>

				</div>

			</div>
		</div>
	</div>
	
<c:import url="./module/footer.jsp"></c:import>