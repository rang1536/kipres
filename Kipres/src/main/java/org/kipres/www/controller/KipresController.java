package org.kipres.www.controller;

import org.kipres.www.domain.Notice;
import org.kipres.www.domain.Path;
import org.kipres.www.service.KipresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class KipresController {
	
	@Autowired
	private KipresService kipresService;
	
	@RequestMapping(value="/notice_writeArticle", method = RequestMethod.GET)
	public String write(Model model) {
		return "news/notice_writeArticle";
	}
	
	// 공지사항 디비에 입력
	@RequestMapping(value="/notice_writeSuccess", method = RequestMethod.POST)
	public String insert(MultipartHttpServletRequest request, Model model, Notice notice) {
		System.out.println("입력값 확인 : "+ notice);
//		System.out.println("입력값 확인 : "+ path);
		System.out.println("입력값 확인 : "+ request);
		int fResult = kipresService.insertFile(request);//파일 경로 입력
		int bResult = kipresService.addNotice(notice);//제목 및 내용 입력
		
		if(fResult == 0 || bResult == 0) { //입력실패
			model.addAttribute("insertResult", "게시글이 등록되지 않았습니다.");
		} else if(fResult == 0 && bResult == 0){ //입력성공 
			model.addAttribute("insertResult", "게시글이 등록되었습니다.");
		}
		return "news/notice_writeSuccess";
	}
	
	// 공지사항 게시글 상세보기
	@RequestMapping(value="/noticeDetail", method = RequestMethod.GET)
	public String read(@RequestParam(value="ntNum", defaultValue="0")int ntNum, Model model) {
		System.out.println("ntNum의 값 : " + ntNum);
		int resultHit = kipresService.updateNoticeRead(ntNum); // 해당 게시글을 클릭하면 조회수 1 증가
		System.out.println("resultHit의 값 : " + resultHit);
		Notice noticeInfo = kipresService.selectNoticeOne(ntNum); // 해당 게시글 번호와 일치하는 행을 읽어옴
		System.out.println("noticeInfo의 값 : " + noticeInfo);
		
		model.addAttribute("noticeInfo", noticeInfo);
		
		return "news/notice_readArticle";
	}
	
	// 공지사항 게시글 삭제
	@RequestMapping(value="/noticeDelete", method = RequestMethod.GET)
	public String delete(@RequestParam(value="ntNum", defaultValue="0")int ntNum, Model model) {
		System.out.println("ntNum의 값 : " + ntNum);
		
		int result = kipresService.deleteNotice(ntNum);
		
		if(result == 0) { //입력실패
			model.addAttribute("deleteResult", "게시글 삭제에 실패하였습니다.");
			
		} else if(result > 0){ //입력성공 - 목록페이지로 이동
			model.addAttribute("deleteResult", "게시글이 삭제되었습니다.");
		}
		
		return "news/notice_deleteSuccess";
	}
	
	// 공지사항 해당 게시글 출력
	@RequestMapping(value="/noticeModify", method = RequestMethod.GET)
	public String modifyForm(@RequestParam(value="ntNum", defaultValue="0")int ntNum, Model model) {
		System.out.println("ntNum의 값 : " + ntNum);
		
		Notice modifyNotice = kipresService.selectNoticeOne(ntNum);
		
		model.addAttribute("modifyNotice", modifyNotice);

		return "news/notice_modifyNotice";
	}
	
	//공지사항 수정
	@RequestMapping(value="/modifySuccess", method = RequestMethod.POST)
	public String modify(@RequestParam(value="ntNum", defaultValue="0")int ntNum, Model model, Notice notice) {
		System.out.println("ntNum의 값 : " + ntNum);
		
		int result = kipresService.modifyNotice(notice);
		
		if(result == 0) { //수정실패
			model.addAttribute("modifyResult", "게시글 수정이 실패하였습니다.");
			
		} else if(result > 0){ //수정성공 - 목록페이지로 이동
			model.addAttribute("modifyResult", "게시글이 수정되었습니다.");
		}

		return "news/notice_modifySuccess";
	}
}
