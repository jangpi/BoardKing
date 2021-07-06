package com.jangjin.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangjin.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static String namespace = "memberMapper";
	
	@Inject
	SqlSession sql;
	
	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".login", vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		 sql.update(namespace + ".memberUpdate", vo);
	}

	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		sql.delete(namespace + ".memberDelete", vo);
		
	}
	
	// 패스워드 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sql.selectOne(namespace + ".passChk", vo);
		return result;
	}
	
	// ID 중복체크
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = sql.selectOne(namespace + ".idChk", vo);
		return result;
	}
	
}
