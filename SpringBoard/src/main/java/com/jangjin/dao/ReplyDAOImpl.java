package com.jangjin.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jangjin.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	private static String namespace = "replyMapper";
	
	@Inject
	SqlSession sql;
	
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return sql.selectList(namespace + ".readReply", bno);
	}

	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		sql.insert(namespace + ".writeReply", vo);
		
	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		sql.update(namespace + ".updateReply", vo);
		
	}

	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		sql.delete(namespace + ".deleteReply", vo);
		
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {
		return sql.selectOne(namespace + ".selectReply", rno);
	}

}
