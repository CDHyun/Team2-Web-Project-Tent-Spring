package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/*
 23/06/17 : Board 페이지 구현 시작 -> 23/06/17 : 리스트 출력, 검색, 페이징 구현 완료.
 23/06/17 : 게시판 글 상세보기, 조회수 증가 구현 시작 -> 23/06/17 : 완료.
 23/06/17 : 게시판 글 작성, 삭제, 수정 구현 시작 -> 23/06/17 : 완료.
 23/06/17 : 댓글 리스트 불러오기 구현 시작 -> 23/06/17 : 리스트 출력, 페이징 구현 완료.
 23/06/17 : 댓글 달기 (무한댓글로직) 구현 시작 -> 23/06/18 : 구현 완료.
 23/06/18 : 댓글 수정, 삭제 구현 시작 ->
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.Board;
import com.springlec.base.model.Comment;
import com.springlec.base.service.BoardService;
import com.springlec.base.service.CommentService;
import com.springlec.base.util.BoardPageMaker;
import com.springlec.base.util.CommentPageMaker;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	CommentService commentService;
	
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
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		Board board = boardService.board_detail(bNo);
		String pageNoParam = request.getParameter("pageNo");
		int pageNo;
		if (pageNoParam != null) {
		    pageNo = Integer.parseInt(pageNoParam);
		} else {
		    pageNo = 1;
		}
		int commentCount = commentService.commentCount(bNo);
		CommentPageMaker commentPageMaker = new CommentPageMaker();
		commentPageMaker.setPage(pageNo);
		commentPageMaker.setTotalCount(commentCount);
		List<Comment> commentList = commentService.commentList(bNo, pageNo);
		model.addAttribute("board", board);
		model.addAttribute("commentList", commentList);
		model.addAttribute("pageMaker", commentPageMaker);
		model.addAttribute("commentCount", commentCount);
		return "board/board_detail";
	}
	
	@RequestMapping("delete_board")
	@ResponseBody
	public int delete_board(HttpServletRequest request) throws Exception {
		int result = boardService.delete_board(Integer.parseInt(request.getParameter("bNo")));
		return result;
	}
	
	@RequestMapping("modify_board")
	@ResponseBody
	public int modify_board(Board board) throws Exception {
		int result = boardService.modify_board(board);
		return result;
	}
	
	@RequestMapping("write_parent_comment")
	public String write_parent_comment(Comment comment, HttpServletRequest request, HttpSession session) throws Exception {
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		comment.setUid((String)session.getAttribute("SUID"));
		comment.setuNickName((String)session.getAttribute("SUNICKNAME"));
		comment.setbNo(bNo);
		commentService.write_parent_comment(comment);
		return "redirect:board_detail?bNo=" + bNo;
	}
	
	@RequestMapping("write_child_comment")
	public String write_child_comment(Comment comment, HttpServletRequest request, HttpSession session) throws Exception {
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String uid = (String)session.getAttribute("SUID");
		String uNickName = (String)session.getAttribute("SUNICKNAME");
		String cmContent = request.getParameter("cmContent");
		int cmParentNo = Integer.parseInt(request.getParameter("cmNo"));
		commentService.saveReply(bNo, uid, uNickName, cmContent, cmParentNo);
		return "redirect:board_detail?bNo=" + bNo;
	}
	
	@RequestMapping("delete_comment")
	@ResponseBody
	public int delete_comment(HttpServletRequest request) throws Exception {
		int result = commentService.delete_comment(Integer.parseInt(request.getParameter("cmNo")), Integer.parseInt(request.getParameter("bNo")));
		return result;
	}
	
	@RequestMapping("modify_comment")
	@ResponseBody
	public int modify_comment(HttpServletRequest request) throws Exception {
		int result = commentService.modify_comment(Integer.parseInt(request.getParameter("cmNo")), Integer.parseInt(request.getParameter("bNo")), request.getParameter("cmContent"));
		return result;
	}
	
	
}	// End Class
