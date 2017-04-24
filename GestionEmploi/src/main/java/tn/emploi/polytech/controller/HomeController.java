package tn.emploi.polytech.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping()
	public String home() {
		return "home/affiche";
	}
}
