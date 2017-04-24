package tn.emploi.polytech.controller;

import java.util.List;

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

import tn.emploi.polytech.entities.Salle;
import tn.emploi.polytech.service.SalleService;

@Controller
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	SalleService vSalleService;
	@Autowired
	HttpSession session;

	@GetMapping()
	public ModelAndView afficher(@RequestParam(name = "err", defaultValue = "") String err,
			@RequestParam(name = "success", defaultValue = "false") boolean success) {

		List<Salle> sl = vSalleService.findAll();
		ModelAndView m = new ModelAndView("salle/affiche");
		m.addObject("err", err);
		m.addObject("success", success);
		m.addObject("salles", sl);
		return m;
	}

	@PostMapping()
	public ModelAndView Ajout(@ModelAttribute("salle") Salle s) {
		RedirectView redirectView = new RedirectView("/salle");

		if (vSalleService.checkExistance(s.getNomSalle(), s.getBlocSalle())) {
			ModelAndView m = new ModelAndView(redirectView);
			m.addObject("err", "Salle existante !");
			return m;
		}

		ModelAndView m = new ModelAndView(redirectView);
		m.addObject("success", "true");
		vSalleService.save(s);
		return m;
	}

}