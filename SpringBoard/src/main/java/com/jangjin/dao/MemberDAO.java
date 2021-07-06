package com.jangjin.dao;

import com.jangjin.vo.MemberVO;

public interface MemberDAO {
	
	// 회원 가입
	public void register(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	// 회원정보 수정
	public void memberUpdate(MemberVO vo) throws Exception;
}
