package com.kh.spring.common.scheduling;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.BoardImg;

@Component
public class FileDeleteScheduler {
	
	private Logger logger = LoggerFactory.getLogger(FileDeleteScheduler.class);
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private BoardService service;
	
	// db에는 존재하지 않지만 resources/uploadFile에 존재하는 파일들은 삭제처리할것
	// 1. BOARD_IMG 테이블 안에있는 이미지 목록들을 모두 조회하여
	// 2. images/boardT 디렉토리 안에 있는 이미지들과 대조하여
	// 3. 일치하지 않는 이미지 파일들을 삭제(db에는 없는 데이터인데 , boardT안에는 존재하는 경우)
	// 4. 우선 5초간격으로 테스트 후 정상적으로 작동한다면 매달 1일 정시에 실행되는 스케줄러로 만들기
	
	//@Scheduled(fixedDelay = 5000) // import org.springframework.scheduling.annotation.Scheduled;
	@Scheduled(cron = "0 0 0 1 * *") // import org.springframework.scheduling.annotation.Scheduled;
	public void deleteFile() {
		logger.info("파일 삭제 시작");
		
		// 1. BOARD_IMG 테이블 안에 있는 목록들을 모두 조회
		ArrayList<BoardImg> list = service.selectBoardImgList();
		
		// 2. images/boardT폴더 아래에 존재하는 모든 이미지 파일목록 조회(File클래스 활용)
		File path = new File(application.getRealPath("/resources/images/boardT"));
		// path가 참조하고 있는 폴더에 들어가서 모든 파일을 File 배열로 얻어오기
		File[] pathList = path.listFiles(); // listFiles() : 디렉토리의 파일목록(디렉토리 포함)을 File배열로 반환한다.
		// pathList 에는 주소값이 들어있음
		
		// [방법1]반복문 돌리면서 pathList에 들어있는 값 하나씩 빼기
		for(File serverFile: pathList) {
			String fileName = serverFile.getName(); // getName() : 경로 이름으로 표시된 파일 또는 디렉터리의 이름을 반환
			//System.out.println(serverFile);   // 경로를 모두 포함한 파일 ex) C:\Spring-Workspace\SpringProject\src\main\webapp\resources\images\boardT\2023050214151283161.jpg
			//System.out.println(fileName); // 파일이름 ex) 2023050214151283161.jpg
			
			boolean isTrue = false;
			
			// 3. 두 목록을 비교해서 일치하지 않는 파일 삭제(삭제시 File클래스의 delete()활용)
			//    -> 1.배열, 2.배열을 반복문돌리면서 일치여부 확인
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getChangeName().equals(fileName)) {
					isTrue =true;
				}
			}
			if(!isTrue) {
				serverFile.delete();
				logger.info(fileName+"파일 삭제함");
			}
		}
		
//		// [방법2] 배열을 컬렉션으로 맞추기
//		List<File> fileList = Arrays.asList(pathList);
//		logger.info(list.toString());
//		logger.info(fileList.toString()); // 풀경로가 저장되어있음
//		
//		// 3. 두 목록을 비교해서 일치하지 않는 파일 삭제(삭제시 File클래스의 delete()활용)
//		if(!list.isEmpty()) {
//			// server : C:\Spring-Workspace\SpringProject\src\main\webapp\resources\images\boardT\2023050212110628123.jpg
//			// list : 2023050212110628123.jpg
//			
//			for(File serverFile  : fileList) {
//				String fileName = serverFile.getName(); // 파일명만 얻어오는 메서드
//
//				// [방법2] indexOf or contains 이용
//				// List.indexOf(value) : List에 value과 같은 값이 있으면 인덱스를 반환/ 없으면 -1을 반환
//				if(list.indexOf(fileName) == -1) {
//					// select해온 db목록에는 없는데, 실제 웹서버에는 저장된 파일인경우
//					logger.info(fileName+"파일 삭제함");
//					serverFile.delete();
//				}
//				
//			}
//			
//		}

		logger.info("서버 파일 삭제 작업 끝");
	}
}






















