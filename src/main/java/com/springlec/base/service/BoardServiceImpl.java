package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.BoardDao;
import com.springlec.base.model.Board;
import com.springlec.base.util.BoardPageMaker;
@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Board> boardList(String query, int pageNo) throws Exception {
		if(query == null) {
			query = "";
		}
		BoardPageMaker boardPageMaker = new BoardPageMaker();
        int startNum = (pageNo-1)*boardPageMaker.getDisplayRow()+1;
        int endNum = pageNo*boardPageMaker.getDisplayRow();
		
        return boardDao.boardList(query, startNum, endNum);
	}

	@Override
	public int boardCount(String query) throws Exception {
		if(query == null) {
			query = "";
		}
		return boardDao.boardCount(query);
	}

	@Override
	public int write_board(Board board) throws Exception {
		return boardDao.write_board(board);
	}

	@Override
	public Board board_detail(int bNo) throws Exception {
		boardDao.increaseViewCount(bNo);
		return boardDao.board_detail(bNo);
	}

	@Override
	public int delete_board(int bNo) throws Exception {
		return boardDao.delete_board(bNo);
	}

	@Override
	public int modify_board(Board board) throws Exception {
		return boardDao.modify_board(board);
	}


}	// End Class
