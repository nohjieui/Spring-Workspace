package com.kh.spring.chat.model.vo;

import lombok.Data;

@Data
public class ChatRoomJoin { // 채팅방에 몇명의 사용자가 있는지 확인할 vo클래스
	private int userNo; 	// Member->userNo pk값을 Foreign Key값으로 얻어옴
	private int chatRoomNo; // ChatRoom->chatRoomNo pk값을 Foreign Key값으로 얻어옴
	// 특정채팅방에 몇명의 사용자가 있는지 체크할 용도의 식별관계 테이블
}
