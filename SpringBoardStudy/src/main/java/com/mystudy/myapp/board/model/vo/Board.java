package com.mystudy.myapp.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자
public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCd;
	private int boardWriter;
	private int count;
	private String createDate;
	private String status;
}
