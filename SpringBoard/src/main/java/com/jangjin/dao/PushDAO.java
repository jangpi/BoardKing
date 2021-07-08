package com.jangjin.dao;

import com.jangjin.vo.PushVO;

public interface PushDAO {
	
	public void pushIn(PushVO vo) throws Exception;
	
	public int pushCheck(PushVO vo) throws Exception;
	
	public int totalPush(PushVO vo) throws Exception;
	
	public void pushOut(PushVO vo) throws Exception;
}
