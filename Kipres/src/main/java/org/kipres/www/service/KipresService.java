package org.kipres.www.service;

import java.util.List;

import org.kipres.www.dao.KipresDao;
import org.kipres.www.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KipresService {
	@Autowired
	private KipresDao kipresDao;
	
	// 공지 디비에 입력
	public int addNotice(Notice notice) {
		
		int result = kipresDao.insertNotice(notice);
		return result;
	}
	
	// 공지사항 게시판 리스트
	public List<Notice> selectNotice() {
		return kipresDao.selectNotice();
	}
}
