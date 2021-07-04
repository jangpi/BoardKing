package com.jangjin.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jangjin.service.MemberService;
import com.jangjin.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// get회원가입
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister(MemberVO vo) throws Exception{
		logger.info("register GET");
	}
	
	// post회원가입
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String poseRegister(MemberVO vo) throws Exception{
		logger.info("register POST");
		
		service.register(vo);
		
		return "redirect:";
	}
}
