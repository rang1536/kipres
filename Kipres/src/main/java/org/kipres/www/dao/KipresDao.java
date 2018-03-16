package org.kipres.www.dao;

import java.util.List;

import org.kipres.www.domain.Notice;
import org.kipres.www.domain.Path;
import org.kipres.www.domain.UserDb;
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
	
	public int deleteNotice(int param) {
		return sqlSession.delete("KipresDao.deleteNotice", param);
	}
	
	public int modifyNotice(Notice notice) {
		return sqlSession.update("KipresDao.modifyNotice", notice);
	}
	
	//업로드 파일 정보 db에 insert
	public int insertFile(Path path) { 
		int daoResult = sqlSession.insert("KipresDao.insertFile", path);
//		System.out.println("daoResult 값 : " + daoResult);
		return daoResult;
	}
	
	//회원가입시 아이디 중복체크
	public UserDb selectUserBefore() {
		return sqlSession.selectOne("KipresDao.selectUserBefore");
	}
	
	//회원가입 정보 DB에 입력
	public int insertUser(UserDb user) {
		return sqlSession.insert("KipresDao.insertUser", user);
	}
	
	//id 중복체크
	public UserDb selectById(String id) {
		UserDb user = sqlSession.selectOne("KipresDao.selectById", id);
		System.out.println("dao user 값 : " + user);
		return user;
	}
	
}
