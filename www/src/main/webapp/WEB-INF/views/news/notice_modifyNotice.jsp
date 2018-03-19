<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

</head>
<body>
<c:import url="../module/header.jsp"></c:import>
	<div id="sub_wrapper">
		<div id="sub_con_wrapper">
			<div id="left_wrapper">
				<div id="left_title">
					<span>
						고객과의 신뢰를<br>최고로 여기는 기업
					</span>
					<h2>
						학회소식
					</h2>
				</div>
				
				<ul>
					<a class="active" href="notice">공지사항<i class="fa fa-chevron-right"></i></a>
					<a href="reference">자료실<i class="fa fa-chevron-right"></i></a>
				</ul>
			</div>
			<div id="right_wrapper">
				<div id="right_path">
					<h5><i class="fa fa-home"></i>&nbsp; > 학회소식 > 공지사항</h5>
				</div>
				
				<div id="right_header">
					<h1>공지사항</h1>
					<h2>앞선 기술력과 뛰어난 혁신으로<br>고객 여러분께 최고의 경험을 선물합니다.</h2>
				</div>
				
				<div>
					<h2>게시글 수정</h2>
					<form action="modifySuccess?ntNum=${modifyNotice.ntNum}" method="post">
					    <div>
					        제목
					        <input type="text" name="ntTitle" size="80" value="${modifyNotice.ntTitle}">
					    </div>
					    <div>
					        내용
					        <textarea name="ntContents" id="ntContents" rows="4" cols="80">${modifyNotice.ntContents}</textarea>
					    </div>
					    <div style="width:650px; text-align: center;">
					        <input type="submit" value="글 수정">
					    </div>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>	
<c:import url="../module/footer.jsp"></c:import>