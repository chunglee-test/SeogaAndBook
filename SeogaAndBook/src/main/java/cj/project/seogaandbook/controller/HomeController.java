package cj.project.seogaandbook.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "welcome";
		}
		
		return "home";
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
}
