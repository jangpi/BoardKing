package com.jangjin.service;

import com.jangjin.vo.PushVO;

public interface PushService {
	
	// 추천하기
	public void pushIn(PushVO vo) throws Exception;
	
	// 추천글 확인
	public int pushCheck(PushVO vo) throws Exception;
	
	// 총 추천수
	public int totalPush(PushVO vo) throws Exception;
	
	// 추천회수
	public void pushOut(PushVO vo) throws Exception;
}
