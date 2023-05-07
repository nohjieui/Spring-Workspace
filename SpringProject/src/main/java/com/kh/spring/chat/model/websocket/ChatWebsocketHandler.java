package com.kh.spring.chat.model.websocket;

import java.sql.Date;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kh.spring.chat.model.service.ChatService;
import com.kh.spring.chat.model.vo.ChatMessage;

public class ChatWebsocketHandler extends TextWebSocketHandler{ //TextWebSocketHandler : 문자열 형태의 데이터만 주고받을 수 있는 통신 프로그램을 만들 수 있는 객체
	
	// 채팅서비스 주입
	@Autowired
	private ChatService chatService;
	
	/*
	 * WebSocketHandler 인터페이스 : 웹소켓을 위한 메소드를 지원하는 인터페이스
	 * -> WebSocketHandler 인터페이스를 구현하는 클래스(TextWebSocketHandler)를 이용해서 웹소켓 기능을 구현할 예정
	 * 
	 * * 웹소켓 핸들러 주요 메서드 *
	 * 
	 * void handlerMassage(WebSocketSession session, WebSocketMessage message)
	 * - 클라이언트로부터 메세지가 도착했을시 실행
	 * 
	 * void afterConnectionEstablished(WebSocketSession session)
	 * - 클라이언트와 연결이 완료되고 통신할 준비가 완료되면 실행
	 * 
	 * void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
	 * - 클라이언트와 연결이 종료되면 실행
	 * 
	 * void handlerTransportError(WebSocketSession session, Throwble execption)
	 * - 메세지 전송 에러발생하면 실행
	 */
	
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	// 중복을 허용하지 않는  Set객체에 저장 -> 동일한 사용자가 접속했다면 중복처리가 되어 먼저들어가있던 요소는 삭제되거나 덮어씌워지게됨
	// synchronizedSet : 동기화된 Set객체 반환
	// -> 멀티스레드환경에서 하나의 컬렉션 요소에 여러스레드가 동시에 접근하면 충돌이 발생할 수 있으므로 동기화를 진행
	
	// 클라이언트와 연결이 수립(chatRoom.jsp -> new SockJS 객체 생성하면 연결이 된것)되고,
	// 통신준비가 완료되면 수행되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		
		// WebSocketSession : 웹소켓에 접속/요청한 클라이언트의 세션 정보
		System.out.println(session.getId()+"가 연결함=====================================");
		
		sessions.add(session); // 전달받은 session을 set에 추가
	}
	
	// 클라이언트와 연결이 종료되면 수행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
		// 웹소켓 연결이 종료되는 경우, sessions안에 저장되어있던 session정보를 삭제
	}
	
	// 클라이언트로부터 텍스트 메세지를 전달받았을 때 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		// TextMessage : 웹소켓을 이용해 전달된 텍스트가 담겨있는 객체
		
		// Payload : 전송되는 데이터(json객체), Payload 필드 안에있는 데이터를 가져오는 getter 함수
		System.out.println("전달된 메세지 : "+message.getPayload());
		
		// JackSon라이브러리 : java에서 json을 다루기위한 라이브러리
		
		// JackSon-databind -> ObjectMapper를 이용해서 JSON형태로 넘어온 데이터를 특정 VO필드에 맞게 자동 매핑됨
		ObjectMapper objectMapper = new ObjectMapper();
		
		ChatMessage chatMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
		
		chatMessage.setCreateDate(new Date(System.currentTimeMillis()));
		
		// 전달받은 채팅메세지를 db에 삽입
		System.out.println(chatMessage);
		
		int result = chatService.insertMessage(chatMessage);
		
		if(result > 0) {
			// 같은 방에 접속중인 클라이언트에게 전달받은 메세지 뿌리기
			for(WebSocketSession s :sessions) {
				
				// 현재 반복을 진행중인 WebSocketSession안에 담겨있는 방번호 == 메세지 안에 담겨있는 방번호가 일치하는 경우 메세지 뿌리기
				int chatRoomNo = (int)s.getAttributes().get("chatRoomNo");
				
				// 메세지에 담겨있는 채팅방 번호와 chatRoomNo가 일치하는지 비교
				if(chatMessage.getChatRoomNo() == chatRoomNo) {
					// 같은방 클라이언트에게 JSON형태로 메세지를 보냄
					// s.sendMessage(new TextMessage( JSON객체 ));
					s.sendMessage(new TextMessage(new Gson().toJson(chatMessage)));
				}
				
			}
		}
	}
}










