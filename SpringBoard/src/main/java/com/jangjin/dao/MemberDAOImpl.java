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

}
