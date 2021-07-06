package com.jangjin.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		logger.info("login");
		
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		logger.info("login out");
		
		session.invalidate();
		
		return "redirect:/";
	}
	
}
