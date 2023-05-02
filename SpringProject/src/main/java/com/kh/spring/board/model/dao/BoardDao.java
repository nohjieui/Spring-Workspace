package com.kh.spring.board.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.board.model.vo.BoardType;
import com.kh.spring.common.model.vo.PageInfo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<BoardType> selectBoardTypeList(){
		return (ArrayList)sqlSession.selectList("boardMapper.selectBoardTypeList");
	}
	
	// 게시글 목록 조회
	public int selectBoardListCount(String boardCode) {
		return sqlSession.selectOne("boardMapper.selectBoardListCount", boardCode);
	}
	// 게시글 목록 조회
	public ArrayList<Board> selectBoardList(PageInfo pi, String boardCode){
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectBoardList", boardCode, rowBounds); 
	}
	
	
	// 게시글 검색 목록 조회
	public int selectBoardListCount(Map<String, Object> parammap) {
		return sqlSession.selectOne("boardMapper.searchBoardListCount", parammap);
	}
	// 게시글 검색 목록 조회
	public ArrayList<Board> selectBoardList(PageInfo pi, Map<String, Object> parammap){
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.searchBoardList", parammap, rowBounds); 
	}
	
	
	
	public Board selectBoardDetail(int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoardDetail", boardNo);
		
	}
	
	public int updateReadCount(int boardNo) {
		return sqlSession.update("boardMapper.updateReadCount",boardNo);
	}
	

	// 1) 게시글 등록
	public int insertBoard(Board b) {
		int result = sqlSession.insert("boardMapper.insertBoard", b);
		
		if(result > 0) {
			result = b.getBoardNo();
			// 게시글 삽입 성공시 selectKey태그를 이용해서 세팅한 boardNo값을 b객체안에 담아서 반환시켜줌
		}
		return result;
	}
	
	public int insertBoardImgList(List<BoardImg> boardImageList) {
		return sqlSession.insert("boardMapper.insertBoardImgList", boardImageList);
	}
	
	public int updateBoard(Board b) {
		return sqlSession.update("boardMapper.updateBoard",b);
	}
	
	public int updateBoardImg(BoardImg img) {
		return sqlSession.update("boardMapper.updateBoardImg",img);
		
	}
	
	public int insertBoardImg(BoardImg img) {
		return sqlSession.insert("boardMapper.insertBoardImg",img);
		
	}
	
	public int deleteBoardImage(Map<String, Object> map) {
		return sqlSession.delete("boardMapper.deleteBoardImage",map);
	}
}
