package com.kh.spring.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class Utils {

	// 변경된 이름을 돌려주면서, 원본파일을 변경된 파일 이름으로 서버에 저장 시키는 메소드
	static public String saveFile(MultipartFile upfile, String savePath) throws IllegalStateException, IOException {
		
		String originName = upfile.getOriginalFilename(); // "user.jpg"
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		int random = (int)(Math.random() * 90000 + 10000);
		
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime+random+ext;
		
		// upfile의 경로를 이동시켜줌
		upfile.transferTo(new File(savePath+changeName));
		
		return changeName;
	}
}
