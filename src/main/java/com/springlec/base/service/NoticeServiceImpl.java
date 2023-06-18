package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.NoticeDao;
import com.springlec.base.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao noticeDao;

	@Override
	public List<Notice> noticeList() throws Exception {
		return noticeDao.noticeList();
	}

	@Override
	public List<Notice> notice_list_byCgNo(int nCgNo) throws Exception {
		return noticeDao.notice_list_byCgNo(nCgNo);
	}

	@Override
	public int write_notice(Notice notice) throws Exception {
		return noticeDao.write_notice(notice);
	}

	@Override
	public int increaseNoticeViewCount(int nNo) throws Exception {
		return noticeDao.increaseNoticeViewCount(nNo);
	}

	@Override
	public int delete_notice(int nNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify_notice(int nNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}	// End Class
