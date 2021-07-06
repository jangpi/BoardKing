package com.jangjin.dao;

import java.util.List;

import com.jangjin.vo.BoardVO;
import com.jangjin.vo.Criteria;
import com.jangjin.vo.SearchCriteria;

public interface BoardDAO {
	
	// 글 작성
	public void write(BoardVO vo) throws Exception;
	
	// 글 리스트
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	// 글 총 개수
	public int listCount(SearchCriteria scri) throws Exception;
	
	// 글 목록보기
	public BoardVO read(int bno) throws Exception;
	
	// 글 수정
	public void update(BoardVO vo) throws Exception;
	
	// 글 삭제
	public void delete(int bno) throws Exception;
}
