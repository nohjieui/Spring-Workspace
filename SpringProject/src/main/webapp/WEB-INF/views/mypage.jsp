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

    <link rel="stylesheet" href="resources/css/mypage.css">
    <link rel="stylesheet" href="resources/css/common.css">

</head>
<body>

    <jsp:include page="/WEB-INF/views/sidebar.jsp" />
    <div class="content-wrap">
        <div class="mypage-wrap container">
            <!-- 제목 -->
            <h4 class="title-underline">마이페이지</h4>

            <div class="container mypage-content">

                <!-- 이미지부분 -->
                <div class="mypage-left">
                    <div class="mypage-profile-box">
                        <img class="mypage-profile" src="resources/images/basic_profile.png">
                    </div>
                    <div class="profile-btn"><button type="button" class="btn btn-outline-primary btn-sm">변경</button></div>
                </div>

                <!-- 내용부분 -->
                <div class="mypage-right">

                    <!-- 사번 -->
                    <div class="mb-4 row">
                        <label for="mypage-no" class="col-sm-3 col-form-label">사번</label>
                        <div class="col-sm-9">
                            <div class="inline-block form-control-plaintext" id="mypage-no">230522</div>
                            <!-- <input type="text" readonly class="form-control-plaintext" id="mypage-no" value="230522"> -->
                        </div>
                    </div>

                    <!-- 이름 / 직급 -->
                    <div class="mb-4 row">
                        <label for="mypage-name" class="col-sm-3 col-form-label">이름 / 직급</label>
                        <div class="col-sm-9">
                            <div class="inline-block form-control-plaintext" id="mypage-name">노지의</div>
                            /
                            <div class="inline-block form-control-plaintext" id="mypage-dept">사원</div>
                            <!-- <input type="text" readonly class="form-control-plaintext" id="mypage-name" value="노지의 / 사원"> -->
                        </div>
                    </div>

                    <!-- 부서 / 팀 -->
                    <div class="mb-4 row">
                        <label for="mypage-team" class="col-sm-3 col-form-label">부서 / 팀</label>
                        <div class="col-sm-9">                            
                            <div class="inline-block form-control-plaintext" id="mypage-dept">IT</div>
                            /
                            <div class="inline-block form-control-plaintext" id="mypage-team">개발 1팀</div>
                            <!-- <input type="text" readonly class="form-control-plaintext" id="mypage-team" value="IT / 개발 1팀"> -->
                        </div>
                    </div>

                    <!-- 연락처 -->
                    <div class="row mb-4">
                        <label for="mypage-phone" class="col-sm-3 col-form-label">연락처</label>
                        <div class="col-sm-9">
                            <input type="tel" id="mypage-pnohe" class="mypage-input form-control box-shadow-put" required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="13">
                        </div>
                    </div>

                    <!-- 내선번호 -->
                    <div class="row mb-4">
                        <label for="mypage-call" class="col-sm-3 col-form-label">내선번호</label>
                        <div class="col-sm-9">
                            <input type="text" id="mypage-call" class="mypage-input form-control box-shadow-put" required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="13">
                        </div>
                    </div>

                    <!-- 주소 -->
                    <div class="row mb-4">
                        <label for="mypage-address" class="col-sm-3 col-form-label">주소</label>
                        <div class="col-sm-9">
                            <input type="text" id="mypage-address" class="mypage-input form-control box-shadow-put">
                        </div>
                    </div>

                    <!-- 이메일 -->
                    <div class="row mb-4">
                        <label for="mypage-email" class="col-sm-3 col-form-label">이메일</label>
                        <div class="col-sm-9">
                            <input type="email" id="mypage-email" class="mypage-input form-control box-shadow-put" pattern=".+@gmail\.com">
                        </div>
                    </div>

                    <!-- 입사일 -->
                    <div class="mb-4 row">
                        <label for="mypage-date" class="col-sm-3 col-form-label">입사일</label>
                        <div class="col-sm-9">
                            <div class="inline-block form-control-plaintext" id="mypage-date">2023-05-22</div>
                        </div>
                    </div>

                </div>

            </div>


            <div class="container text-center">
                <div class="row justify-content-start">
                    <div class="col-4" style="text-align: start;">
                        <!-- Button trigger modal -->
                        <button type="button" class="pass-re btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">비밀번호 변경</button>
                    </div>
                    <div class="col-4">
                        <button type="button" class="my-btn btn btn-primary">정보변경</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

  
    <!-- 비밀번호 변경 Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">비밀번호 변경</h1>
                </div>
                <div class="change-pwd-div modal-body">
                    <form>
                        <div class="row mb-3">
                            <label for="origin-pwd" class="col-sm-4 col-form-label">현재 비밀번호</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control box-shadow-put" id="origin-pwd">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="change-pwd" class="col-sm-4 col-form-label">새 비밀번호</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control box-shadow-put" id="change-pwd">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="change-pwd-ck" class="col-sm-4 col-form-label">새 비밀번호 확인</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control box-shadow-put" id="change-pwd-ck">
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





    <script>
        function autoHypenTel(str) {
            str = str.replace(/[^0-9]/g, '');
            var tmp = '';

            if (str.substring(0, 2) == 02) {
                // 서울 전화번호일 경우 10자리까지만 나타나고 그 이상의 자리수는 자동삭제
                if (str.length < 3) {
                    return str;
                } else if (str.length < 6) {
                    tmp += str.substr(0, 2);
                    tmp += '-';
                    tmp += str.substr(2);
                    return tmp;
                } else if (str.length < 10) {
                    tmp += str.substr(0, 2);
                    tmp += '-';
                    tmp += str.substr(2, 3);
                    tmp += '-';
                    tmp += str.substr(5);
                    return tmp;
                } else {
                    tmp += str.substr(0, 2);
                    tmp += '-';
                    tmp += str.substr(2, 4);
                    tmp += '-';
                    tmp += str.substr(6, 4);
                    return tmp;
                }
            } else {
                // 핸드폰 및 다른 지역 전화번호 일 경우
                if (str.length < 4) {
                    return str;
                } else if (str.length < 7) {
                    tmp += str.substr(0, 3);
                    tmp += '-';
                    tmp += str.substr(3);
                    return tmp;
                } else if (str.length < 11) {
                    tmp += str.substr(0, 3);
                    tmp += '-';
                    tmp += str.substr(3, 3);
                    tmp += '-';
                    tmp += str.substr(6);
                return tmp;
                } else {
                    tmp += str.substr(0, 3);
                    tmp += '-';
                    tmp += str.substr(3, 4);
                    tmp += '-';
                    tmp += str.substr(7);
                    return tmp;
                }
            }

            return str;
        }

        $('#mypage-pnohe,#mypage-call').keyup(function (event) {
            event = event || window.event;
            var _val = this.value.trim();
            this.value = autoHypenTel(_val);
        });

    </script>




</body>
</html>