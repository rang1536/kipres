package org.kipres.www;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */

@Controller
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
		List<Notice> list = kipresService.selectNotice();
		
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
	
	@RequestMapping(value="/joinStep1", method = RequestMethod.GET)
	public String joinStep1(Model model) {
		return "joinStep1";
	}
	
	@RequestMapping(value="/joinStep2", method = RequestMethod.GET)
	public String joinStep2Get() {
		return "redirect:/joinStep1";
	}
	
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(@RequestParam(value="id", defaultValue="null") String id,
						 @RequestParam(value="password", defaultValue="null") String password,
						 Model model,
						 HttpSession session) {
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
			
			session.setAttribute("authInfo", authInfo);
			
			return "loginSuccess";
		} catch(IdPasswordNotMatchingException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			System.out.println("idOrPwNotMatch 값 : " + errors.get("idOrPwNotMatch"));
			return "login";
		}
	}
	
	@RequestMapping(value="/loginSuccess", method=RequestMethod.POST)
	public String loginSuccess(Model model) {
		return "loginSuccess";
	}
}
