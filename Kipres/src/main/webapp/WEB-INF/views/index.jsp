<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="./module/header.jsp"></c:import>

	<div id="main_wrapper">
		<!-- 메인 슬라이드 시작 -->
		<div class="flexslider">
			<ul class="slides">
				<li style="background:url('resources/images/slide01.jpg') 50% 100% no-repeat;"></li>
				<li style="background:url('resources/images/slide02.jpg') 50% 100% no-repeat"></li>
			</ul>
		</div>
	</div><!-- End #main_wrapper --> 
		
	<div id="bottom_wrapper">
		<div id="bottom_con_wrapper">
			<section style="background:url(resources/images/section01.jpg) 100% 98% no-repeat;">
				<h4> <span>공지사항</span></h4>
				<p>앞서가는 기술력과 노하우로<br>세계로 뻗어나가는<br>저희 회사를 소개합니다.</p>
				<a href="notice">자세히보기</a>
			</section>
			
			<section style="background:url(resources/images/section02.jpg) 100% 98% no-repeat;">
				<h4><span>자료실</span></h4>
				<p>최고의 품질을 보증하는<br>저희 제품을 소개합니다.</p>
				<a href="reference">자세히보기</a>
			</section>

			<section style="background:url(resources/images/section03.jpg) 100% 98% no-repeat;">
				<h4>CONTACT <span>INFO</span></h4>
				<p>전화 : 02) 345-6789<br>팩스 : 02) 345-6780<br>E-MAIL : davedesign@tistory.com</p>
				<a href="direction">찾아오시는길</a>
			</section>
		</div><!-- End #bottom_con_wrapper -->
	</div><!-- End #bottom_wrapper -->

<c:import url="./module/footer.jsp"></c:import>