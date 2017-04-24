package tn.emploi.polytech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.emploi.polytech.entities.Compte;
import tn.emploi.polytech.entities.Enseignant;
import tn.emploi.polytech.entities.Etudiant;
import tn.emploi.polytech.entities.Section;
import tn.emploi.polytech.service.CompteService;
import tn.emploi.polytech.service.EnseignantService;
import tn.emploi.polytech.service.EtudiantService;
import tn.emploi.polytech.service.SectionService;

@Controller
@RequestMapping("/enseignant")
public class EnseignantController {

	@Autowired
	EnseignantService vEnseignantService;
	@Autowired
	CompteService vCompteService;

	@GetMapping("/all")
	public ModelAndView afficher() {

		List<Enseignant> el = vEnseignantService.findAll();
		ModelAndView m = new ModelAndView("enseignant/afficher");
		m.addObject("enseignants", el);

		return m;
	}

	@GetMapping("/add")
	public ModelAndView afficheform() {
		return new ModelAndView("enseignant/ajouter");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PostMapping("/add")
	public ModelAndView Ajout(@ModelAttribute("enseignant") Enseignant e, @ModelAttribute("compte") Compte c) {
		RedirectView redirectView = new RedirectView("/enseignant/all");
		c.setUser(e);
		ModelAndView m = new ModelAndView(redirectView);
		vCompteService.save(c);
		return m;
	}

}
