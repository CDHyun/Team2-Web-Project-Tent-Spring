package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Notice;

public interface NoticeService {
	
	// 공지사항 전체 리스트 불러오기
	public List<Notice> noticeList() throws Exception;
	
	// 선택된 카테고리 번호의 공지사항 불러오기
	public List<Notice> notice_list_byCgNo(int nCgNo) throws Exception;
	
	// 공지사항 작성하기
	public int write_notice(Notice notice) throws Exception;
	
	// 공지사항 조회수 증가
	public int increaseNoticeViewCount(int nNo) throws Exception;
	
	// 공지사항 삭제
	public int delete_notice(int nNo) throws Exception;
	
	// 공지사항 수정
	public int modify_notice(int nNo) throws Exception;

}	// End Class
