package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/*
 23/06/17 : Board 페이지 구현 시작 ->
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Board;
import com.springlec.base.service.BoardService;
import com.springlec.base.util.BoardPageMaker;

import jakarta.servlet.http.HttpServletRequest;

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
	
}	// End Class
