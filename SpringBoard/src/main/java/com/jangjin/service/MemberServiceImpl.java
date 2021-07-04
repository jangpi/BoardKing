package com.jangjin.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangjin.dao.MemberDAO;
import com.jangjin.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO dao;
	
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

}
