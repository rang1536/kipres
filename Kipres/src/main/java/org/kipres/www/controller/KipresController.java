package org.kipres.www.controller;

import org.kipres.www.domain.Notice;
import org.kipres.www.service.KipresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KipresController {
	
	@Autowired
	private KipresService kipresService;
	
	@RequestMapping(value="/notice_writeArticle", method = RequestMethod.GET)
	public String write(Model model) {
		return "news/notice_writeArticle";
	}
	
	// 공지 디비에 입력
	@RequestMapping(value="/notice_writeSuccess", method = RequestMethod.POST)
	public String insert(Model model, Notice notice) {
		System.out.println("입력값 확인 : "+notice);
		int result = kipresService.addNotice(notice);
		
		if(result == 0) { //입력실패
			model.addAttribute("insertResult", "fail");
			
		} else if(result > 0){ //입력성공 - 목록페이지로 이동
			model.addAttribute("insertResult", "success");
		}
		return "news/notice_writeSuccess";
	}
	
	
	@RequestMapping(value="/noticeDetail", method = RequestMethod.GET)
	public String read(@RequestParam(value="ntNum", defaultValue="0")int ntNum, Model model) {
		System.out.println("nuNum의 값 : " + ntNum);
		int resultHit = kipresService.updateNoticeRead(ntNum); // 해당 게시글을 클릭하면 조회수 1 증가
		System.out.println("resultHit의 값 : " + resultHit);
		Notice noticeInfo = kipresService.selectNoticeOne(ntNum); // 해당 게시글 번호와 일치하는 행을 읽어옴
		System.out.println("noticeInfo의 값 : " + noticeInfo);
		
		model.addAttribute("noticeInfo", noticeInfo);
		
		return "news/notice_readArticle";
	}
	
}
