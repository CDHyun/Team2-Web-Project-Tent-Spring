package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Notice;

public class NoticeDaoImpl implements NoticeDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.NoticeDao";

	@Override
	public List<Notice> noticeList() throws Exception {
		return sqlSession.selectList(nameSpace + ".noticeList");
	}

	@Override
	public List<Notice> notice_list_byCgNo(int nCgNo) throws Exception {
		return sqlSession.selectList(nameSpace + ".notice_list_byCgNo");
	}

	@Override
	public int write_notice(Notice notice) throws Exception {
		return sqlSession.insert(nameSpace + ".write_notice");
	}

	@Override
	public int increaseNoticeViewCount(int nNo) throws Exception {
		return sqlSession.update(nameSpace + ".increaseNoticeViewCount");
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

}
