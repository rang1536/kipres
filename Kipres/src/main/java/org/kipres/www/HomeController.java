package org.kipres.www;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		return "news/notice";
	}
	
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
	
	
}
