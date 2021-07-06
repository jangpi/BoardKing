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
	
	/* 회원정보 수정이라는 버튼을 통해 RequestMapping(value = "/memberUpdateView") 로 가게 해주어야한다.  
	 * registerUpdateView에는 파라미터를 받지 않게 되어있는데 값들을 memberUpdateView.jsp 에서 쓸 수 있는데
	 * 로그인을 하면 이미 Member값들을 session에서 이미 받고 있기 때문에 쓸 수가 있다.
	 * 회원정보 수정 페이지에서 수정버튼을 누르면 /memberUpdate 요청을 하게 되고, 파라미터들을
	 * session.invalidate()로 세션을 끊고 로그인 페이지로 redirect 해준다.
	 * */
	
	@RequestMapping(value="/memberUpdateView", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception{
		
		return "member/memberUpdateView";
	}

	@RequestMapping(value="/memberUpdate", method = RequestMethod.POST)
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		
		service.memberUpdate(vo);
		
		session.invalidate();
		
		return "redirect:/";
	}
	
}
