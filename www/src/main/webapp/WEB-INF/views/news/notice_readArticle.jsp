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
					<table border="1" style="width:600px">
						<caption>게시판</caption>
						<colgroup>
							<col width='15%' />
							<col width='*%' />
						</colgroup>
						<tbody>
							
							<tr>
								<td>제목</td> 
								<td><c:out value="${noticeInfo.ntTitle}"/></td> 
							</tr>
							<tr>
								<td>작성자</td> 
								<td><c:out value="${authInfo.name}"/></td> 
							</tr>
							<tr>
								<td>게시일</td> 
								<td><c:out value="${noticeInfo.ntInsertDate}"/></td> 
							</tr>
							<tr>
								<td>첨부파일</td>
								<td><a href="http://sh86.kr/resources/img/edit.jpg">
								첨부 다운
								</a></td> 
							</tr>
							<tr>
								<td>내용</td> 
								<td><c:out value="${noticeInfo.ntContents}"/></td> 
							</tr>
							
						</tbody>
					</table>
					<a href="notice">돌아가기</a>
					<a href="noticeDelete?ntNum=<c:out value="${noticeInfo.ntNum}"/>">삭제</a>
					<a href="noticeModify?ntNum=<c:out value="${noticeInfo.ntNum}"/>">수정</a>
				</div>
				
			</div>
			
		</div>
		
	</div>
	
	
<c:import url="../module/footer.jsp"></c:import>