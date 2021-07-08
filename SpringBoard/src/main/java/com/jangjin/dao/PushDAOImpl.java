package com.jangjin.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jangjin.vo.PushVO;

@Repository
public class PushDAOImpl implements PushDAO {
	
	private static String namespace = "pushMapper";
	
	@Inject
	SqlSession sql;
	
	@Override
	public void pushIn(PushVO vo) throws Exception {
		sql.insert(namespace + ".pushIn", vo);
	}

	@Override
	public int pushCheck(PushVO vo) throws Exception {
		return sql.selectOne(namespace + ".pushCheck", vo);
	}

	@Override
	public int totalPush(PushVO vo) throws Exception {
		return sql.selectOne(namespace + ".totalPush", vo);
	}

	@Override
	public void pushOut(PushVO vo) throws Exception {
		sql.delete(namespace + ".pushOut", vo);

	}

}
