package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/*
 23/06/17 : Board 페이지 구현 시작 ->
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.Board;
import com.springlec.base.service.BoardService;
import com.springlec.base.util.BoardPageMaker;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("board_list")
	public String boardList(HttpServletRequest request, Model model) throws Exception {
		BoardPageMaker boardPageMaker = new BoardPageMaker();
		String pageNoParam = request.getParameter("pageNo");
		int pageNo;
		if (pageNoParam != null) {
		    pageNo = Integer.parseInt(pageNoParam);
		} else {
		    pageNo = 1;
		}
		int boardCount = boardService.boardCount(request.getParameter("query"));
		boardPageMaker.setPage(pageNo);
		boardPageMaker.setTotalCount(boardCount);
		List<Board> boardList = boardService.boardList(request.getParameter("query"), pageNo);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageMaker", boardPageMaker);
		return "board/board";
	}
	
	@RequestMapping("write_board")
	public String write_board(Board board, HttpSession session) throws Exception {
		board.setUid((String)session.getAttribute("SUID"));
		board.setuNickName((String)session.getAttribute("SUNICKNAME"));
		boardService.write_board(board);
		return "redirect:board_list";
	}
	
	@RequestMapping("board_detail")
	public String board_detail(HttpServletRequest request, Model model) throws Exception {
		Board board = boardService.board_detail(Integer.parseInt(request.getParameter("bNo")));
		model.addAttribute("board", board);
		return "board/board_detail";
	}
	
	@RequestMapping("increaseViewCount")
	public void increaseViewCount(HttpServletRequest request) throws Exception {
		boardService.increaseViewCount(Integer.parseInt(request.getParameter("bNo")));
	}
	
	
	
	
	
	
}	// End Class
