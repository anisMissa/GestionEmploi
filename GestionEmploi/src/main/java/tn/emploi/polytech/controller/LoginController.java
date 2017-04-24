package tn.emploi.polytech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.emploi.polytech.entities.Admin;
import tn.emploi.polytech.entities.Compte;
import tn.emploi.polytech.repository.AdminRepository;
import tn.emploi.polytech.service.CompteService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	CompteService vCompteService;
	@Autowired
	AdminRepository vAdminRepo;
	@Autowired
	HttpSession session;

	@GetMapping()
	public ModelAndView index(@RequestParam(name = "err", defaultValue = "") String err) {
		ModelAndView m = new ModelAndView("auth/login");
		m.addObject("err", err);
		return m;
	}

	@PostMapping()
	public ModelAndView login(@ModelAttribute("compte") Compte c) {
		RedirectView redirectView = new RedirectView("/login");
		ModelAndView m = new ModelAndView(redirectView);

		Compte compte = vCompteService.find(c.getEmail(), c.getPassword());
		if (compte == null) {
			m.addObject("err", "Email ou mot de passe incorrect !");
			return m;

		} else {
			if (vAdminRepo.findByIdUser(compte.getIdCompte()) == null) {
				m.addObject("err", "Vous n'avez pas le droit d'accéder !");
				return m;

			} else {
				RedirectView redirectView1 = new RedirectView("/home");
				ModelAndView m1 = new ModelAndView(redirectView1);
				session.setAttribute("user", c.getUser());
				return m1;
			}
		}
	}

	@GetMapping("/out")
	public ModelAndView logout() {
		
		session.removeAttribute("user");
		session.invalidate();
		
		RedirectView v = new RedirectView("/login");
		ModelAndView m = new ModelAndView(v);
		return m;
	}
}
