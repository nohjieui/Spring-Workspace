package com.mystudy.myapp.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private int userNo;
	private String userId;
	private String userPwd;
	private String nickName;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	private String profileImg;
}
