/**
 * 다음 주소 API
 */
//클릭시 팝업이 뜰 버튼에 : id="seach-address"
//주소가 들어갈 input에 : id="user-address"
//상세 주소 input에 : id="user-address-dtail"

window.onload = function () {
    document.getElementById("seach-address").addEventListener("click", function () {
        //아이콘 클릭시
        //카카오 지도 발생
        DaumAddressAPI();
    });
  
    document.getElementById("user-address").addEventListener("click", function () {
        //주소입력칸을 클릭하면
        //카카오 지도 발생
        DaumAddressAPI();
    });
};
  
function DaumAddressAPI() {
    new daum.Postcode({
        oncomplete: function (data) {
            //선택시 입력값 세팅
            document.getElementById("user-address").value = data.address; // 주소 넣기

            const detailAddress = document.getElementById("user-address-dtail");
            detailAddress.value = data.buildingName; // 빌딩이름 있으면 넣어주고
            detailAddress.focus(); //포커스해주기
        },
    }).open();
}
