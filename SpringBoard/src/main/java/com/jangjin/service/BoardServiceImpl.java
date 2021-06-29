package com.jangjin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jangjin.dao.BoardDAO;
import com.jangjin.vo.BoardVO;
import com.jangjin.vo.Criteria;
import com.jangjin.vo.SearchCriteria;

@Service // -> DB에 접근하는 코드는 REPOSITORY에 위임하고 ,비즈니스 로직과 관련된 모든 코드가 모여있다.
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	// 글 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);

	}
	
	// 글 리스트
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return dao.list(scri);
	}

	// 글 목록보기
	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}
	
	// 글 수정
	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}
	
	// 글 삭제
	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount(scri);
	}
	
}
