package org.kipres.www.controller;

import org.springframework.stereotype.Controller;

@Controller
public class KipresController {
	
/*	@Autowired
	private KipresService kipresService;
	
	// 공지사항 게시글 등록창
	@RequestMapping(value="/notice_writeArticle", method = RequestMethod.GET)
	public String write(Model model, @ModelAttribute AuthInfo authInfo) {
		System.out.println("authInfo : " + authInfo);
		if(authInfo == null) {
			return "redirect:/login";
		}
		return "news/notice_writeArticle";
	}
	
	// 공지사항 게시글 등록 
	@RequestMapping(value="/notice_writeSuccess", method = RequestMethod.POST)
	public String insert(MultipartHttpServletRequest request, Model model, Notice notice) {
//		System.out.println("입력값 확인 : "+ notice);
		
		
		int bResult = kipresService.addNotice(notice);//제목 및 내용 입력
//		System.out.println("bResult 값 : " + bResult);
		int fResult = kipresService.insertFile(request);//파일 경로 입력	
//		System.out.println("fResult 값 : " + fResult);
		if(fResult == 0 || bResult == 0) { // 하나라도 실패 시 입력실패
			model.addAttribute("insertResult", "게시글이 등록되지 않았습니다.");
		} else if(fResult == 1 && bResult == 1){ // 둘 다 성공 시 입력성공 
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
	}*/
	
}
