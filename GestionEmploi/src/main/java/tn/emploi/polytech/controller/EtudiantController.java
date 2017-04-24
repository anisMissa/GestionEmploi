package tn.emploi.polytech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.emploi.polytech.entities.Compte;
import tn.emploi.polytech.entities.Etudiant;
import tn.emploi.polytech.entities.Section;
import tn.emploi.polytech.repository.SectionRepository;
import tn.emploi.polytech.service.CompteService;
import tn.emploi.polytech.service.EtudiantService;
import tn.emploi.polytech.service.SectionService;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

	@Autowired
	EtudiantService vEtudiantService;
	@Autowired
	CompteService vCompteService;
	@Autowired
	SectionService vSectionService;

	@GetMapping("/all")
	public ModelAndView afficher() {

		List<Etudiant> el = vEtudiantService.findAll();
		ModelAndView m = new ModelAndView("etudiant/afficher");
		m.addObject("etudiants", el);

		return m;
	}

	@GetMapping("/add")
	public ModelAndView afficheform() {
		
		List<Section> sections = vSectionService.findAll();
		ModelAndView m = new ModelAndView("etudiant/ajouter");
		m.addObject("sections", sections);

		return m;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PostMapping("/add")
	public ModelAndView Ajout(@ModelAttribute("etudiant") Etudiant e, @ModelAttribute("compte") Compte c,
			@ModelAttribute("section") Section s) {
		RedirectView redirectView = new RedirectView("/etudiant/all");

		e.setSection(s);

		c.setUser(e);

		ModelAndView m = new ModelAndView(redirectView);
		vCompteService.save(c);
		return m;
	}

}
