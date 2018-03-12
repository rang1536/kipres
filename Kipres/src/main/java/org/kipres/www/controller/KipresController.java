package org.kipres.www.controller;

import org.kipres.www.domain.Notice;
import org.kipres.www.service.KipresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			
		}else if(result > 0){ //입력성공 - 목록페이지로 이동
			model.addAttribute("insertResult", "success");
		}
		return "news/notice_writeSuccess";
	}
	
}
