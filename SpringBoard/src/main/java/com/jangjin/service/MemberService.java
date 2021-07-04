package com.jangjin.service;

import com.jangjin.vo.MemberVO;

public interface MemberService {
	
	// 회원 가입
	public void register(MemberVO vo) throws Exception;
}
