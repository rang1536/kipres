<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>한국지적재산권경상학회</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">  <!-- font-awesome  플러그인 -->
<link rel="stylesheet" href="resources/css/style.css">  <!--  전체 스타일시트  -->
<link rel="stylesheet" href="resources/css/flexslider.css" type="text/css">  <!-- flex slider 스타일시트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="resources/js/jquery.flexslider.js"></script>  <!-- flex slider 제이쿼리 -->
<script>
$(document).ready(function(){
	/*  드롭다운 메뉴 컨트롤  */
	
	$("#slide_nav").hide(); // 드롭다운 메뉴 숨김
	
	$("#header_wrapper").hover(function(){  // 상단메뉴에 hover시 슬라이드 토글
		$("#slide_nav").slideToggle("fast");
	});
	
	var navigation = $('#header_wrapper').offset(); 
	
	/*   스크롤 제어 컨트롤   */
	
	
	$(window).scroll(function() {
		if( $(document).scrollTop() > navigation.top) { // #header_wrapper의 높이값보다 스크롤의 높이값이 클 때
			$('#header_wrapper').addClass('headerFixed'); // #header_wrapper에 .headerFixed의 속성을 추가 
		}
		else { 
			$('#header_wrapper').removeClass('headerFixed'); // #header_wrapper에서 .headerFixed의 속성을 제거
		}
		
		if ( $(this).scrollTop() > 150 ) { // 페이지 스크롤이 150픽셀 이상 내려가면
			$('.top').fadeIn(); // .top 페이드 인 
		} 
		else {
			$('.top').fadeOut(); // 그렇지 않으면 페이드 아웃 
		}	
	});
	
	/*   메인 이미지 슬라이드 컨트롤   */
	
	$('.flexslider').flexslider(); // flexslider 활성화

});
</script>

<!--[if It IE 9]>
	<script src="http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<![endif]-->
</head>
<body>
	
<div id="wrapper">
	<div id="quick_wrapper">
		<div id="quick_con_wrapper">
			<a href="#">로그인</a> <a href="#">회원가입</a>
		</div>
	</div>
	
	<div id="header_wrapper">
		<div id="header_con_wrapper">
			<a id="logo" href="main">
				<span>한국지적재산권</span> 경상학회
			</a>
			
			<!-- 상단 메뉴 시작 -->			
			<div id="main_nav">
				<ul>
					<li><a href="greeting">학회소개</a></li>
					<li><a href="notice">학회소식</a></li>
					<li><a href="guide">학회지</a></li>
					<li><a href="schedule">학술행사</a></li>
					<li><a href="direction">오시는 길</a></li>
				</ul>
				
				<!-- 드롭다운 메뉴 시작 -->
				<div id="slide_nav">
					<div id="slide_con_nav">
						<div id="slide_left">
						</div>
						<div id="slide_right">
							<ul>
								<a href="greeting">인사말</a>
								<a href="outline">학회개요</a>
								<a href="history">학회연혁</a>
								<a href="chart">조직도</a>
								<a href="committee">위원회</a>
								<a href="rule">회칙</a>
							</ul>
							<ul>
								<a href="notice">공지사항</a>
								<a href="reference">자료실</a>
							</ul>
							<ul>
								<a href="guide">학술지 안내</a>
								<a href="paperContribution">논문 투고</a>
								<a href="paperSearch">논문 검색</a>
							</ul>						
							<ul>
								<a href="schedule">학술행사 일정</a>
								<a href="conference">춘/추계 학술대회</a>
								<a href="gallery">학회행사 갤러리</a>
							</ul>
							<ul style="border-right:1px solid #ccc;">
								<a href="direction">찾아오시는 길</a>
							</ul>						
						</div><!-- End #slide_right -->
					</div><!-- End #slide_con_nav -->
				</div><!-- End #slide_nav -->							
			</div><!-- End #main_nav -->
		</div><!-- End #header_con_wrapper -->
	</div><!-- End #header_wrapper -->