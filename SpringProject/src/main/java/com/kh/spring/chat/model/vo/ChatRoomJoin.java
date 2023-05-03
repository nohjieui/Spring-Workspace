package com.kh.spring.chat.model.vo;

import lombok.Data;

@Data
public class ChatRoomJoin {
	private int userNo; // Member-userNo
	private int chatRoomNo; // ChatRoom-chatRoomNo
	
	// 식별관계
}
