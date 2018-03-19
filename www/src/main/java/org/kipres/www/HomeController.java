package org.kipres.www;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kipres.www.domain.Notice;
import org.kipres.www.service.KipresService;
import org.kipres.www.util.AlreadyExistingMemberException;
import org.kipres.www.util.AuthInfo;
import org.kipres.www.util.IdPasswordNotMatchingException;
import org.kipres.www.util.RegisterRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("authInfo")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private KipresService kipresService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting(Model model) {
		return "introduce/greeting";
	}
	
	@RequestMapping(value = "/outline", method = RequestMethod.GET)
	public String outline(Model model) {
		return "introduce/outline";
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String history(Model model) {
		return "introduce/history";
	}
	
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart(Model model) {
		return "introduce/chart";
	}
	
	@RequestMapping(value = "/committee", method = RequestMethod.GET)
	public String committee(Model model) {
		return "introduce/committee";
	}
	
	@RequestMapping(value = "/rule", method = RequestMethod.GET)
	public String rule(Model model) {
		return "introduce/rule";
	}
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Model model) {
//		System.out.println("authInfo 값 : " + authInfo);
		List<Notice> list = kipresService.selectNotice();
//		model.addAttribute("authInfo", authInfo);
		model.addAttribute("list", list);
		return "news/notice";
	}
	
//	@RequestMapping(value = "/notice", method = RequestMethod.GET)
//	public String notice(BPaging bPaging, ModelMap modelMap) throws Exception {
//    	bPaging.pageCalculate(kipresService.selectCount()); // startRow, endRow
//
//    	List<?> listview   = kipresService.selectNotice2(bPaging);
//        
//    	modelMap.addAttribute("listview", listview);
//		modelMap.addAttribute("bPaging", bPaging);
//		return "news/notice";
//	}
	
	@RequestMapping(value = "/reference", method = RequestMethod.GET)
	public String reference(Model model) {
		return "news/reference";
	}
	
	@RequestMapping(value = "/guide", method = RequestMethod.GET)
	public String guide(Model model) {
		return "jounal/guide";
	}
	
	@RequestMapping(value = "/paperContribution", method = RequestMethod.GET)
	public String paperContribution(Model model) {
		return "jounal/paperContribution";
	}
	
	@RequestMapping(value = "/paperSearch", method = RequestMethod.GET)
	public String paperSearch(Model model) {
		return "jounal/paperSearch";
	}
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String schedule(Model model) {
		return "event/schedule";
	}
	
	@RequestMapping(value = "/conference", method = RequestMethod.GET)
	public String conference(Model model) {
		return "event/conference";
	}
	
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String gallery(Model model) {
		return "event/gallery";
	}
	
	@RequestMapping(value = "/direction", method = RequestMethod.GET)
	public String direction(Model model) {
		return "directions/direction";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/joinStep2", method = RequestMethod.POST)
	public String joinStep2(@RequestParam(value="agree", defaultValue="false")Boolean agree) {
		if(!agree) {
			return "joinStep1";
		}
		return "joinStep2";
	}
	
	//회원가입 약관 동의
	@RequestMapping(value="/joinStep1", method = RequestMethod.GET)
	public String joinStep1(Model model) {
		return "joinStep1";
	}
	
	//약관 동의없이 회원가입 창으로 주소를 입력할 경우 약관동의창으로 리다이렉트
	@RequestMapping(value="/joinStep2", method = RequestMethod.GET)
	public String joinStep2Get() {
		return "redirect:/joinStep1";
	}
	
	//회원정보 입력에 오류가 없을 시 회원가입 완료
	@RequestMapping(value="/joinStep3", method = RequestMethod.POST)
	public String joinStep3(RegisterRequest regReq, Model model) {
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		model.addAttribute("errors", errors);
		
		System.out.println("regReq 값: " + regReq);
		
		regReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return "joinStep2";
		}
		
		try {
			kipresService.regist(regReq);
			return "joinStep3";
		} catch(AlreadyExistingMemberException aeme) {
			errors.put("duplicateId", Boolean.TRUE);
			return "joinStep2";
		}
	}
	
	//로그인 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(@RequestParam(value="id", defaultValue="null") String id,
						 @RequestParam(value="password", defaultValue="null") String password,
						 Model model) {
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		model.addAttribute("errors", errors);
		System.out.println("id 값 : " + id);
		System.out.println("pw 값 : " + password);
		
		if(id == null || id.isEmpty()) {
			errors.put("id", Boolean.TRUE);
			System.out.println("resultId 값 : " + errors.get("id"));
		} 
		if(password == null || password.isEmpty()) {
			errors.put("password", Boolean.TRUE);
			System.out.println("resultPw 값 : " + errors.get("password"));
		}
		
//		System.out.println("resultId 값 : " + resultId);
//		System.out.println("resultPw 값 : " + resultPw);
		
		if(!errors.isEmpty()) {
			
			return "login";
		}
		
		try {
			AuthInfo authInfo = kipresService.login(id, password);
			
			model.addAttribute("authInfo", authInfo);
			
			return "loginSuccess";
		} catch(IdPasswordNotMatchingException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			System.out.println("idOrPwNotMatch 값 : " + errors.get("idOrPwNotMatch"));
			return "login";
		}
	}
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/main";
	}
	
	/*
	 * KipresController 
	 */
	
	// 공지사항 게시글 등록창
	@RequestMapping(value="/notice_writeArticle", method = RequestMethod.GET)
	public String write(Model model, AuthInfo authInfo) {
		if(authInfo.getId() == null || authInfo.getId() == "") {
			return "login";
		}
		return "news/notice_writeArticle";
	}
	
	// 공지사항 게시글 등록 
	@RequestMapping(value="/notice_writeSuccess", method = RequestMethod.POST)
	public String insert(MultipartHttpServletRequest request, Model model, Notice notice, AuthInfo authInfo) {
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
	public String read(@RequestParam(value="ntNum", defaultValue="0")int ntNum, Model model, AuthInfo authInfo) {
		System.out.println("ntNum의 값 : " + ntNum);
		int resultHit = kipresService.updateNoticeRead(ntNum); // 해당 게시글을 클릭하면 조회수 1 증가
		System.out.println("resultHit의 값 : " + resultHit);
		Notice noticeInfo = kipresService.selectNoticeOne(ntNum); // 해당 게시글 번호와 일치하는 행을 읽어옴
		System.out.println("noticeInfo의 값 : " + noticeInfo);
		
		model.addAttribute("noticeInfo", noticeInfo);
		model.addAttribute("authInfo", authInfo);
		
		return "news/notice_readArticle";
	}
	
	// 공지사항 게시글 삭제
	@RequestMapping(value="/noticeDelete", method = RequestMethod.GET)
	public String delete(@RequestParam(value="ntNum", defaultValue="0")int ntNum, Model model/*, AuthInfo authInfo*/) {

		int result = kipresService.deleteNotice(ntNum);
//		if(authInfo.getId() == null || authInfo.getId() == "") {
//			return "login";
//		}
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
