package org.kipres.www.service;

import java.util.List;

import org.kipres.www.dao.KipresDao;
import org.kipres.www.domain.Notice;
import org.kipres.www.domain.Path;
import org.kipres.www.util.UtilFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	
	// 공지사항 전체 게시글수
    public Integer selectCount() {
		return kipresDao.selectCount();
    }
    
    // 게시글 상세보기 
    public Notice selectNoticeOne(int param) {
    	Notice notice = kipresDao.selectNoticeOne(param);
    	System.out.println("공지 조회값 확인  : "+notice);
    	return notice;
    }
    
    //게시글 수정
    public int updateNoticeRead(int param) {
    	return kipresDao.updateNoticeRead(param);
    }
	
    //게시글 삭제
    public int deleteNotice(int param) {
    	return kipresDao.deleteNotice(param);
    }
    
    //
    public int modifyNotice(Notice notice) {
    	return kipresDao.modifyNotice(notice);
    }
    
    public int insertFile(MultipartHttpServletRequest request) {
    	UtilFile utilFile = new UtilFile();
    	Path path = utilFile.singleUploadFile(request, "notice", "notice");
    	System.out.println("path 값 : " + path);
    	int result = kipresDao.insertFile(path);
    	System.out.println("result 값 : " + result);
    	return result;
		
    }
//	public List<Notice> selectNotice2(BPaging param) throws Exception {
//		return kipresDao.selectNotice2(param);
//    }
}
