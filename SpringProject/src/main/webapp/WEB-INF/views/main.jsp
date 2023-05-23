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
    <link rel="stylesheet" href="resources/css/annual.css">

</head>
<body>

    <jsp:include page="/WEB-INF/views/sidebar.jsp" />
    <div class="content-wrap">
        <div class="annual-wrap container">
            <!-- 제목 -->
            <h4 class="title-underline">총 연차 관리</h4>
    
            <!-- 내용부분 -->
            <div class="annual-content container">
                <!-- 수정버튼 -->
                <div class="modify-btn">
                    <!-- Button trigger modal -->
                    <button type="button" class="my-btn btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">수정</button>
                </div>
                
                <!-- 표 -->
                <div class="row annual-table-div">


                    <div class="col-md-6">
                        <table class="annual-table table table-common">
                            <thead>
                                <tr>
                                    <th scope="col">근로기간</th>
                                    <th scope="col">연차 유급휴가 발생</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="annual-year" rowspan="2">1년 미만</td>
                                    <td class="annual-count" rowspan="2">0</td>
                                </tr>
                                <tr>
    
                                </tr>
                                <tr>
                                    <td class="annual-year">1년</td>
                                    <td class="annual-count">15</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">2년</td>
                                    <td class="annual-count">15</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">3년</td>
                                    <td class="annual-count">16</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">4년</td>
                                    <td class="annual-count">16</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">5년</td>
                                    <td class="annual-count">17</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">6년</td>
                                    <td class="annual-count">17</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">7년</td>
                                    <td class="annual-count">18</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">8년</td>
                                    <td class="annual-count">18</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">9년</td>
                                    <td class="annual-count">19</td>
                                </tr>
                                <tr>
                                    <td class="annual-year">10년</td>
                                    <td class="annual-count">19</td>
                                </tr>
                            </tbody>          
    
                        </table>
                    </div>
                    <div class="col-md-6">
                        <table class="annual-table table table-common">
                            <thead>
                                <tr>
                                    <th scope="col">근로기간</th>
                                    <th scope="col">연차 유급휴가 발생</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="annual-year" scope="row">11년</td>
                                    <td class="annual-count">20</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">12년</td>
                                    <td class="annual-count">20</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">13년</td>
                                    <td class="annual-count">21</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">14년</td>
                                    <td class="annual-count">21</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">15년</td>
                                    <td class="annual-count">22</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">16년</td>
                                    <td class="annual-count">22</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">17년</td>
                                    <td class="annual-count">23</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">18년</td>
                                    <td class="annual-count">23</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">19년</td>
                                    <td class="annual-count">24</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">20년</td>
                                    <td class="annual-count">24</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">21년</td>
                                    <td class="annual-count">25</td>
                                </tr>
                                <tr>
                                    <td class="annual-year" scope="row">22년</td>
                                    <td class="annual-count">25</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- 연차 수정 Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">총 연차 변경</h1>
                </div>
                <div class="annual-modify-modal modal-body">
                    <form>
                        <div class="row mb-3">
                            <label for="annual-year-select" class="col-sm-4 col-form-label">근로기간</label>
                            <div class="col-sm-8">
                                <select class="form-select box-shadow-put" aria-label="Default select example">
                                    <option selected>근로기간 선택</option>
                                    <option value="1">1년 미만</option>
                                    <option value="1">1년</option>
                                    <option value="2">2년</option>
                                    <option value="3">3년</option>
                                    <option value="3">4년</option>
                                    <option value="3">5년</option>
                                    <option value="3">6년</option>
                                    <option value="3">7년</option>
                                    <option value="3">8년</option>
                                    <option value="3">9년</option>
                                    <option value="3">10년</option>
                                    <option value="3">11년</option>
                                    <option value="3">12년</option>
                                    <option value="3">13년</option>
                                    <option value="3">14년</option>
                                    <option value="3">15년</option>
                                    <option value="3">16년</option>
                                    <option value="3">17년</option>
                                    <option value="3">18년</option>
                                    <option value="3">19년</option>
                                    <option value="3">20년</option>
                                    <option value="3">21년</option>
                                    <option value="3">22년</option>

                                </select>
                            </div>
                        </div>


                        
                        <div class="row mb-3">
                            <label for="annual-count-modify" class="col-sm-4 col-form-label">연차 유급휴가</label>
                            <div class="col-sm-8">
                                <input type="number" class="form-control box-shadow-put" id="annual-count-modify">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="my-btn btn btn-primary">확인</button>
                    <button type="button" class="my-btn btn btn-outline-primary" data-bs-dismiss="modal" aria-label="Close">취소</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>