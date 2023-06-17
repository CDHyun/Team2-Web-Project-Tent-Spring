package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.CommentDao;
import com.springlec.base.model.Comment;
import com.springlec.base.util.CommentPageMaker;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentDao commentDao;

	@Override
	public int commentCount(int bNo) throws Exception {
		return commentDao.commentCount(bNo);
	}

	@Override
	public List<Comment> commentList(int bNo, int pageNo) throws Exception {
		CommentPageMaker commentPageMaker = new CommentPageMaker();
        int startRow = (pageNo-1)*commentPageMaker.getDisplayRow()+1;
        int endRow = pageNo*commentPageMaker.getDisplayRow();
		
		return commentDao.commentList(bNo, startRow, endRow);
	}

}
