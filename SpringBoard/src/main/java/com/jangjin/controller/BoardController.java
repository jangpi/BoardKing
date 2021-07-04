package com.jangjin.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jangjin.service.BoardService;
import com.jangjin.service.ReplyService;
import com.jangjin.vo.BoardVO;
import com.jangjin.vo.PageMaker;
import com.jangjin.vo.ReplyVO;
import com.jangjin.vo.SearchCriteria;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@Autowired
	ReplyService replyservice;
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO vo) throws Exception{
		logger.info("write");
		
		service.write(vo);
		
		return "redirect:/board/list";
	}
	
	// 게시판 리스트
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		logger.info("list");
		
		model.addAttribute("list",service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/list";
	
	}
	// 게시판 글 상세보기
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVO vo, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
		logger.info("read");
		
		model.addAttribute("read", service.read(vo.getBno()));
		model.addAttribute("scri", scri);
		
		List<ReplyVO> replyList = replyservice.readReply(vo.getBno());
		model.addAttribute("replyList", replyList);
		
		return "board/readView";
	
	}
	
	// 게시판 수정 뷰
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO vo, Model model) throws Exception{
		logger.info("updateView");
		
		model.addAttribute("update", service.read(vo.getBno()));
		
		return "board/updateView";
		
	}
	
	// 게시판 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		logger.info("update");
		
		service.update(vo);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("pageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
		
	}
	// 게시판 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVO vo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		
		service.delete(vo.getBno());
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("pageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
		
	}
	
		// 댓글 작성하기
		@RequestMapping(value = "/board/replyWrite", method = RequestMethod.POST)
		public String replyWrite(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception{
			logger.info("reply Write");
			
			replyservice.writeReply(vo);
			
			rttr.addAttribute("bno",vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/readView";	
		}
	
		//댓글 수정 GET
		@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception {
			logger.info("reply Write");
			
			model.addAttribute("replyUpdate", replyservice.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			
			return "board/replyUpdateView";
		}
		
		//댓글 수정 POST
		@RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
		public String replyUpdate(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("reply Write");
			
			replyservice.updateReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/readView";
		}
	
		// 댓글 삭제 GET
		@RequestMapping(value = "/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(ReplyVO vo, Model model, SearchCriteria scri) throws Exception{
			logger.info("replyDeleteView");
			
			model.addAttribute("replydelete", replyservice.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			
			return "board/replyDeleteViews";
		}
	
		// 댓글 삭제 POST
		@RequestMapping(value = "/replyDelete", method = RequestMethod.POST)
		public String replyDelete(ReplyVO vo, Model model, SearchCriteria scri, RedirectAttributes rttr) throws Exception{
			logger.info("replyDelete");
			
			replyservice.deleteReply(vo);
			
			rttr.addAttribute(rttr);
			
			return "redirect:/board/readView";
		}
	
}