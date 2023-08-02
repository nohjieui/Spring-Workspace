<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  공통적으로사용할 라이브러리 추가 -->
<!-- Jquey 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩에서 제공하있는 스타일 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 부투스트랩에서 제공하고있는 스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- alertify -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
<!-- alertify css -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<!-- 
	font-family: 'Black Han Sans', sans-serif;
	font-family: 'Noto Sans KR', sans-serif; 
-->
<style>
	div {box-sizing:border-box;}
	#header {
		width: 80%;
		height: 100px;
		padding-top:20px;
		margin :auto;
		/* sticky : 스크롤이 임계점(최상단)에 도달했을 때 화면에 스티커처럼 붙임
	        - 평소에는 static(기본 position상태) 임계점 도달 시 fixed(화면 특정 위치에 고정)
	
	        * top, bottom, left, right 속성이 필수로 작성되어야 함
	            -> 임계점 도달 시 어느 위치에 부착할지를 지정해야되기 때문에
	    */
	    position: sticky;
	    top: 0; /* 최상단에 붙임*/
	    background-color: white;
	    border-bottom : 2px solid black;
	    z-index: 10;
	}
	#header_1_left>a{
		color: black;
		text-decoration: none;
		font-size: 30px;	
		font-family: 'Black Han Sans', sans-serif;
	}
</style>
</head>



<body>
	<c:if test="${ not empty alertMsg }">
		<script>
			alertify.alert("서비스 요청 성공", '${alertMsg}' );
		</script>
		<c:remove var="alertMsg" scope="session" />
	</c:if>

	
	<div class="header">
		<div class="col" id="header_1_left">
			<a href="${path}">TALKING</a>
		</div>
		<div class="col" id="header_1_center">
			<div class="search-area">
	        <!-- form 내부 input 태그 값을 서버 또는 페이지로 전달, 기능구현 X -->
	        <form action="#" name="search-form">
	            <fieldset>
	
	                <!-- autocomplete="off" : 검색어 자동완성을 막음  -->
	                <input type="search" id="query" name="query" 
	                    autocomplete="off" placeholder="검색어를 입력해주세요.">
	
	                <!-- 검색 버튼 -->
	                    <button type="submit" id="search-btn" class="fa-solid fa-magnifying-glass"></button>  
	                </fieldset>
	            </form>
	        </div>
		</div>
		<div class="col" id="header_1_right">
           		<%-- 로그인이 되어있지 않은 경우 --%>
   				<c:if test="${ empty sessionScope.loginUser}"> 
          			<a data-toggle="modal" data-target="#loginModal">로그인</a>
           			<span>|</span>
           			<a href="${path}/member/insert">회원가입</a>
           			<span>|</span>
                    <a href="#">ID/PW 찾기</a>
           			<!-- 회원가입 / ID/PW 찾기 영역 -->

           		</c:if>
		</div>			
	</div>
	
	<div class="nav">
	    <ul>
	    	<li><a href="#">HOME</a></li>
	    	<li><a href="#">공지사항</a></li>
	    	<li><a href="${path}/chat/chatRoomList">채팅</a></li>
	       <%--  <li><a href="${path}/board/list?type=1">공지사항</a></li>
	        <li><a href="${path}/board/list?type=2">자유 게시판</a></li>
	        <li><a href="${path}/board/list?type=3">질문 게시판</a></li> --%>	
			<c:forEach var="boardType" items="${boardTypeList}">
				<li><a href="${path}/board/list/${boardType.boardCd}">${boardType.boardName}</a></li>
			</c:forEach>
	    </ul>
	</div>




	<!-- 로그인 클릭시 뜨는 모달( 기존에 안보이다가 버튼클릭시 보임) -->
	<div class="modal fade" id="loginModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- 모달 해더 -->
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<form action="${path}/member/login" method="post">
					<!--  모달 바디 -->
					<div class="modal-body">
						<input type="text" class="form-controll mb-2 mr-sm-2" placeholder="ID" id="userId" name="userId" value="${cookie.saveId.value}" style="width:100%">
						<br>
						<input type="password" class="form-controll mb-2 mr-sm-2" placeholder="Password" id="userPwd" name="userPwd" style="width:100%">
					</div>
					
					<!-- 모달 푸터 -->
					<div class="modal-footer">
					<%-- 쿠키에 saveId가 있는 경우--%>
                        <c:if test="${ !empty cookie.saveId.value}">
                            <%-- chk 변수 생성(page scope)--%>
                            <c:set var="chk" value="checked"/>

                        </c:if>

	                    <label>
                               <!-- checked 속성 : radio/checkbox를 체크하는 속성 -->
	                        <input type="checkbox" name="saveId" ${chk}  id="saveId"> 아이디 저장
	                    </label>
						<button type="submit" class="btn btn-primary">로그인</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>





</body>
</html>