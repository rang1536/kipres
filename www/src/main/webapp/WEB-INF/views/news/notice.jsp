<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​

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
					<table border="1" width="600px">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>이름</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
<!-- 					<c:if test="${noticePage.hasNoNotices()}">

						<tr>
							<td colspan="4">게시글이 없습니다.</td>
						</tr>

						</c:if>
-->
					<c:forEach var="list" items="${list}">
						<tr>
							<td>
								${list.ntNum}
							</td>
							<td>
								<a href="noticeDetail?ntNum=${list.ntNum}">
									<c:out value="${list.ntTitle}"/>
								</a>
							</td>
							<td>...</td>
							<td>${list.ntInsertDate}</td>
							<td>${list.ntHit}</td>
						</tr>
					</c:forEach>
					</table>

					<a href="notice_writeArticle">글쓰기</a>
				</div>

			</div>
		</div>
	</div>
	
<c:import url="../module/footer.jsp"></c:import>