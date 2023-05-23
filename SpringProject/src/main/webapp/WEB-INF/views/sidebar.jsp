<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	<!-- CSS only -->
	<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> -->
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
	<!-- 부트스트랩 아이콘 -->
	<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"> -->
	
	<!-- fontawesome라이브러리추가 다양한 아이콘을 지원함.(EX) 검색용 돋보기 버튼) -->
	<!-- <script src="https://kit.fontawesome.com/a2e8ca0ae3.js" crossorigin="anonymous"></script> -->
	
	<link rel="stylesheet" href="resources/css/sidebar.css">

<title>Insert title here</title>
</head>
<body>
    <div class="sidebar">
        <div class="sidebar-logo">
            <i class="fa-solid fa-feather"></i>
        </div>
        <nav class="sidebar-icon-wrap">
            <ul>
                <!-- 메인 -->
                <li id="icon-home">
                    <a href="">
                        <span class="sidebar-icon"><i class="fa-solid fa-house"></i></span>
                        <span class="sidebar-text">홈</span>
                    </a>
                </li>
                <!-- 조직도 -->
                <li class="sidebar-cursor" id="icon-chart">
                    <div class="accordion-flush" id="accordionFlushExample">
                        <button class="accordion-button-sidebar accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                            <span class="sidebar-icon">
                                <i class="bi bi-diagram-3"></i>
                            </span>
                            <span class="sidebar-text">조직도</span>
                            <i class="sidebar-icon-arrow fa-solid fa-angle-down"></i>
                        </button>
                        <div id="flush-collapseOne" class="sidebar-more accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                            <a class="sidebar-more-text" href="">조직도 등록</a>
                            <a class="sidebar-more-text" href="">조직도 현황</a>
                        </div>
                    </div>
                </li>
                <!-- 메일 -->
                <li id="icon-mail">
                    <a href="">
                        <span class="sidebar-icon"><i class="fa-solid fa-envelope"></i></span>
                        <span class="sidebar-text">메일</span>
                    </a>
                </li>
                <!-- 게시판 -->
                <li class="sidebar-cursor" id="icon-notice">
                    <div class="accordion-flush" id="accordionFlushExample">
                        <button class="accordion-button-sidebar accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                            <span class="sidebar-icon"><i class="bi bi-file-text"></i></span>
                            <span class="sidebar-text">게시판</span>
                            <i class="sidebar-icon-arrow fa-solid fa-angle-down"></i>
                        </button>
                        <div id="flush-collapseOne" class="sidebar-more accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                            <a class="sidebar-more-text" href="">공지사항</a>
                            <a class="sidebar-more-text" href="">팀게시판</a>
                            <a class="sidebar-more-text" href="">자유게시판</a>
                        </div>
                    </div>
                </li>
                <!-- 캘린더 -->
                <li id="icon-calender">
                    <a href="">
                        <span class="sidebar-icon"><i class="bi bi-calendar-date"></i></span>
                        <span class="sidebar-text">캘린더</span>
                    </a>
                </li>
                <!-- 전자결재 -->
                <li id="icon-sign">
                    <a href="">
                        <span class="sidebar-icon"><i class="bi bi-briefcase-fill"></i></span>
                        <span class="sidebar-text">전자결재</span>
                    </a>
                </li>
                <!-- 근태 -->
                <li id="icon-work">
                    <a href="">
                        <span class="sidebar-icon"><i class="fa-solid fa-clock"></i></span>
                        <span class="sidebar-text">근태</span>
                    </a>
                </li>
                <!-- 연차관리 -->
                <li id="icon-vacation">
                    <a href="">
                        <span class="sidebar-icon"><i class="fa-solid fa-umbrella-beach"></i></span>
                        <span class="sidebar-text">연차관리</span>
                    </a>
                </li>
                <!-- 계정관리 -->
                <li id="icon-account">
                    <a href="">
                        <span class="sidebar-icon"><i class="fa-solid fa-user-plus"></i></span>
                        <span class="sidebar-text">계정관리</span>
                    </a>
                </li>
                <!-- 권한관리 -->
                <li id="icon-authority">
                    <a href="">
                        <span class="sidebar-icon"><i class="fa-solid fa-user-gear"></i></span>
                        <span class="sidebar-text">권한관리</span>
                    </a>
                </li>
            </ul>
        </nav>

        <!-- fixed-bottom : 최하단 고정 -->
        <nav class="sidebar-icon-end sidebar-icon-wrap fixed-bottom">
            <ul>
                <!-- 마이페이지 -->
                <li id="icon-info">
                    <a href="">
                        <span class="sidebar-icon"><i class="bi bi-person-circle"></i></span>
                        <span class="sidebar-text">마이페이지</span>
                    </a>
                </li>
                <!-- 로그아웃 -->
                <li id="icon-logout">
                    <a href="">
                        <span class="sidebar-icon"><i class="fa-solid fa-power-off"></i></span>
                        <span class="sidebar-text">로그아웃</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <script>

        // $(".sidebar").on('mouseout',function(){
        //     console.log("###?")
        //     // if($(".sidebar").width() < 300){
        //         // $('.accordion-collapse').removeClass("show");
        //     // }
        // });

        // $(".sidebar").hover(function(){
        //     $(this).css("width", "300");
        // },function(){
        //     $(this).css("width", "60");
        // })

    </script>
</body>
</html>