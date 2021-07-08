package com.jangjin.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jangjin.dao.PushDAO;
import com.jangjin.vo.PushVO;

@Service
public class PushServiceImpl implements PushService {
	
	@Inject
	PushDAO dao;
	
	@Override
	public void pushIn(PushVO vo) throws Exception {
		dao.pushIn(vo);

	}

	@Override
	public int pushCheck(PushVO vo) throws Exception {
		return dao.pushCheck(vo);
	}

	@Override
	public int totalPush(PushVO vo) throws Exception {
		return dao.totalPush(vo);
	}

	@Override
	public void pushOut(PushVO vo) throws Exception {
		dao.pushOut(vo);
	}

}
