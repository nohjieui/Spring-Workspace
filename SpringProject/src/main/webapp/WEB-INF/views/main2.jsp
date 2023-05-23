<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

    <!--bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!-- 부트스트랩 아이콘 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <!-- fontawesome라이브러리추가 다양한 아이콘을 지원함.(EX) 검색용 돋보기 버튼) -->
    <script src="https://kit.fontawesome.com/a2e8ca0ae3.js" crossorigin="anonymous"></script>
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/annual-select.css">

</head>
<body>

    <jsp:include page="/WEB-INF/views/sidebar.jsp" />
    <div class="content-wrap">
        <div class="annual-wrap container">
            <!-- 제목 -->
            <h4 class="title-underline">연차</h4>
    
            <!-- 내용부분 -->
            <div class="annual-content">
                <div>
                    <input type="text" class="form-control box-shadow-put" id="annual-user">
                    <!-- 조회버튼 -->
                    <button type="button" id="user-select-btn" class="my-btn btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">조회</button>
                </div>
                <div class="annual-user-info">
                    <span id="annual-user-name">노지의</span>
                    <span id="annual-dept">IT 운영부</span>
                    <span id="annual-team">개발팀</span>
                    <span id="annual-only-text">입사일</span>
                    <span id="annual-hire-date">2019-02-08</span>
                    <span id="annual-only-text">누적연차</span>
                    <span id="annual-">4.5</span>
                    /
                    <input type="text" value="16">
                    <div class="profile-btn"><button type="button" class="btn btn-outline-primary btn-sm">수정</button></div>
                </div>

                <div>
                    <table class="table table-common">
                        <thead>
                            <tr>
                                <th scope="col">휴가구분</th>
                                <th scope="col">시작일</th>
                                <th scope="col">종료일</th>
                                <th scope="col">휴가일수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>연차</td>
                                <td>2022-04-13</td>
                                <td>2022-04-14</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>총 사용 연차</td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>




</body>
</html>