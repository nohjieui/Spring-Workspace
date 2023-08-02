import {path} from './common.js';
/* signUp.js
   필수기능 
   * 다음주소 api 연동
   * 아이디값 중복체크기능 -> 버튼따로 만들지 않고, keyup이벤트로 유효성검사 진행할 예정
   
   선택기능
   닉네임 유효성검사,
   비밀번호 유효성검사,
   아이디 유효성검사,
   전화번호 유효성검사
 */
// 유효성 검사 여부를 기록할 객체 생성
const checkObj = { 
    "enrollUserId"  : false, 
    "enrollUserPwd" : false,
    "userPwdCk"     : false,
    "nickName"      : false,
    "phone"         : false
};

// 아이디 유효성 검사
const userId = document.getElementById("enrollUserId");
const emailMessage = document.querySelector("#emailMessage");
userId.addEventListener("input", function(){
    
    const regExp = /^[\w]+@[a-z]+\.[a-z]{2,3}$/;

    if(userId.value.length == 0){
        emailMessage.innerHTML = "아이디로 사용할 이메일을 입력해주세요.";
        emailMessage.classList.remove("confirm", "error");

        checkObj.enrollUserId = false;
        return;
    }
    
    // 아이디 중복확인 체크
    if(regExp.test(userId.value)){
        emailMessage.innerHTML = "";
        $.ajax({
            url : path+"/member/idCheck",
            data : {"userId" : userId.value},
            type : "GET",
            success : function(result){
                if(result == 1){
                    emailMessage.innerHTML = "이미 사용중인 아이디(이메일) 입니다.";
                    emailMessage.classList.add("error");
                    emailMessage.classList.remove("confirm");
                    checkObj.enrollUserId = false;
                }else{
                    emailMessage.innerHTML = "사용 가능한 아이디(이메일) 입니다.";
                    emailMessage.classList.add("confirm");
                    emailMessage.classList.remove("error");
                    checkObj.enrollUserId = true;
                }
            },
            error : function(req, status, error){
                console.log(req.responseText);
            }
        })
    }else{
        emailMessage.innerHTML = "이메일 형식이 유효하지 않습니다.";
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");
        checkObj.enrollUserId = false;
    }
});

// 비밀번호 유효성 검사
const userPwd = document.getElementById("enrollUserPwd");
const userPwdCk = document.getElementById("userPwdCk");
const pwdMessage = document.getElementById("pwdMessage");

userPwd.addEventListener("input",function(){

    if(userPwd.value.length == 0 && userPwdCk.value.length == 0){
        pwdMessage.innerHTML = "영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 작성해주세요.";
        pwdMessage.classList.remove("error","confirm");
        checkObj.enrollUserPwd = false;
        return;
    }

    const regExp = /^[\w!@#-]{6,20}$/;

    if(regExp.test(userPwd.value)){
        
        checkObj.enrollUserPwd = true;
        pwdMessage.innerHTML = "유효한 비밀번호 형식입니다.";
        pwdMessage.classList.add("confirm");
        pwdMessage.classList.remove("error");

        userPwdCk.addEventListener("input", function(){
            if(userPwd.value == userPwdCk.value || regExp.test(userPwd.value)){
                pwdMessage.innerHTML = "비밀번호가 일치합니다.";
                pwdMessage.classList.add("confirm");
                pwdMessage.classList.remove("error");
        
                checkObj.enrollUserPwd = true;
            }else{
                pwdMessage.innerHTML = "비밀번호가 일치하지 않습니다.";
                pwdMessage.classList.add("error");
                pwdMessage.classList.remove("confirm");
        
                checkObj.enrollUserPwd = false;
            }
        });


    }else{
        pwdMessage.innerHTML = "유효한 비밀번호 형식이 아닙니다.";
        pwdMessage.classList.add("error");
        pwdMessage.classList.remove("confirm");
        
        checkObj.enrollUserPwd = false;
    }
});




// function signUpValidate(){
//     let str;

//     for(let key in checkObj){
//         if(!checkObj[key]){
//             switch(key){
//                 case "enrollUserId" : str = "아이디가"; break;
//                 case "enrollUserPwd" : str = "비밀번호가"; break;
//                 case "userPwdCk" : str = "비밀번호 확인이"; break;
//                 case "nickName" : str = "닉네임이"; break;
//                 case "phone" : str = "전화번호가"; break;
//             }

//             str += " 유효하지 않습니다.";

//             alert(str);

//             document.getElementById(key).focus();

//             return false;
//         }
//     }
//     return true;
// };


//document.getElementById("signUp-form").addEventListener("submit", signUpValidate);


// 전화번호 하이픈
var autoHypenPhone = function(str){
    str = str.replace(/[^0-9]/g, '');
    var tmp = '';

    if( str.length < 4){
        return str;
    }else if(str.length < 7){
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3);
        return tmp;
    }else if(str.length < 11){
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3, 3);
        tmp += '-';
        tmp += str.substr(6);
        return tmp;
    }else{              
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3, 4);
        tmp += '-';
        tmp += str.substr(7);
        return tmp;
    }
    return str;
}

var phoneNum = document.getElementById('phone');
phoneNum.onkeyup = function(){
    //console.log(this.value);
    this.value = autoHypenPhone( this.value ) ;  
}