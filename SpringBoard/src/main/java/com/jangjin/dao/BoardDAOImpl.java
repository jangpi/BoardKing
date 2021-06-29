package com.jangjin.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jangjin.vo.BoardVO;
import com.jangjin.vo.Criteria;
import com.jangjin.vo.SearchCriteria;


@Repository	// -> DB에 접근 하는 모든 코드가 모여 있다.
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	SqlSession sqlsession;
	
	private static String namespace = "boardMapper";
	
	//글 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		sqlsession.insert(namespace +".insert" , vo);

	}
	
	//글 리스트
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return sqlsession.selectList(namespace + ".listPage", scri);
	}
	
	//글 목록보기
	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlsession.selectOne(namespace + ".read", bno);
		
	}
	
	// 글 수정하기
	@Override
	public void update(BoardVO vo) throws Exception {
		sqlsession.update(namespace + ".update", vo);
		
	}
	
	// 글 삭제하기
	@Override
	public void delete(int bno) throws Exception {
		sqlsession.delete(namespace + ".delete", bno);
		
	}

	// 글 총 게시물
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return sqlsession.selectOne(namespace + ".listCount", scri);
	}

}
