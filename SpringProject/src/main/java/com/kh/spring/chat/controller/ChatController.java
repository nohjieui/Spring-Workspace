package com.kh.spring.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.chat.model.service.ChatService;
import com.kh.spring.chat.model.vo.ChatMessage;
import com.kh.spring.chat.model.vo.ChatRoom;
import com.kh.spring.chat.model.vo.ChatRoomJoin;
import com.kh.spring.member.model.vo.Member;

@Controller
@SessionAttributes({"loginUser", "chatRoomNo"})
/* @RequestMapping("/chat") */
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	// 채팅방 목록 조회
	@GetMapping("/chat/chatRoomList")
	public String selectChatRoomList(Model model) {
		List<ChatRoom> crList = chatService.selectChatRoomList();
		// request scope에 저장
		model.addAttribute("chatRoomList", crList);
		
		return "chat/chatRoomList";
	}
	
	// 채팅방만들기
	@PostMapping("/chat/openChatRoom")
	public String openCahtRoom(@ModelAttribute("loginUser") Member loginUser,
								// @ModelAttribute안에있는 ("loginUser")와 @SessionAttributes({"loginUser"})에서의 일치하는 key값이 있다면
								// session scope안에 있는 loginUser를 Member loginUser에 셋팅시켜줌
							   Model model,
							   ChatRoom room,
							   RedirectAttributes ra) {
		room.setUserNo(loginUser.getUserNo());
		
		int chatRoomNo = chatService.openChatRoom(room); // (db에 생성된)생성된 채팅방 번호
		// dao에서 return값으로 chatRoom.getChatRoomNo()넘겨줬음

		String path = "redirect:/chat/";
		
		if(chatRoomNo > 0) { // 제대로 생성됨
			ra.addFlashAttribute("alertMsg", "채팅방 생성 성공");
			//path += "chatRoomList";
			path += "room/"+chatRoomNo; // 상세화면 구현 후 변경 예정으로 주석처리했었음
		}else {
			ra.addFlashAttribute("alertMsg", "채팅방 생성 실패");
			path += "chatRoomList";
		}
		return path;
	}
	
	// 채팅방 입장
	@GetMapping("/chat/room/{chatRoomNo}")
	public String joinChatRoom(@ModelAttribute("loginUser") Member loginUser,
								// sessionScope에 있는 loginUser를 넣어준다
								// 단, SessionAttribute로 등록이 되어있는 경우
							   Model model,
							   @PathVariable("chatRoomNo") int chatRoomNo,
							   ChatRoomJoin join,
							   RedirectAttributes ra) {
		join.setUserNo(loginUser.getUserNo());
		List<ChatMessage> list = chatService.joinChatRoom(join);
		
		if(list != null) {
			model.addAttribute("list", list);
			model.addAttribute("chatRoomNo", chatRoomNo);// session scope에 자동으로 올라감
			
			return "chat/chatRoom"; // jsp페이지로 이동
		}else {
			ra.addFlashAttribute("alertMsg", "채팅방이 존재하지 않습니다.");
			return "redirect:../chatRoomList";
		}
	}
	
	
	// 채팅방 나가기
	@GetMapping("/chat/exit")
	@ResponseBody
	public int exitChatRoom(@ModelAttribute("loginUser") Member loginUser,
							ChatRoomJoin join) {
		join.setUserNo(loginUser.getUserNo());
		
		return chatService.exitChatRoom(join);
	}
}















