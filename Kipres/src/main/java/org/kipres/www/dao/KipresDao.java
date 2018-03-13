package org.kipres.www.dao;

import java.util.List;

import org.kipres.www.domain.Notice;
import org.kipres.www.util.BPaging;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KipresDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//공지사항 글쓰기
	public int insertNotice(Notice notice) {
		return sqlSession.insert("KipresDao.insertNotice", notice);
	}
	
	//공지사항 전제 게시글 개수
	public Integer selectCount() {
		return sqlSession.selectOne("KipresDao.selectCount");
	}
	
	//공지사항 지정한 범위 게시글 읽기
	public List<Notice> selectNotice() {
		return sqlSession.selectList("KipresDao.selectNotice");
	}
	
//	public List<Notice> selectNotice2(BPaging param) {
//		return sqlSession.selectList("KipresDao.selectNotice2");
//	}
	
	public Notice selectNoticeOne(int param) {
		return sqlSession.selectOne("KipresDao.selectNoticeOne", param);
	}
	
	public int updateNoticeRead(int param) {
		return sqlSession.update("KipresDao.updateNoticeRead", param);
	}
}
