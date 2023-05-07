package com.kh.spring.chat.model.vo;

import lombok.Data;

@Data
public class ChatRoom {
	private int chatRoomNo;
	private String title;
	private String status;
	private int userNo;
	
	private String nickName;
	private int cnt; // 채팅방안에 접속된 사용자 숫자를 저장할 용도
}
