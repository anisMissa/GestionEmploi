package tn.emploi.polytech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.emploi.polytech.entities.Section;
import tn.emploi.polytech.service.SectionService;


@Controller
@RequestMapping("/section")
public class SectionController {

	@Autowired
	SectionService vSectionService;

	@GetMapping()
	public ModelAndView afficher(@RequestParam(name = "err", defaultValue = "") String err,
			@RequestParam(name = "success", defaultValue = "false") boolean success) {

		List<Section> sec = vSectionService.findAll();
		ModelAndView m = new ModelAndView("section/affiche");
		m.addObject("err", err);
		m.addObject("success", success);
		m.addObject("sections", sec);
		return m;
	}

	@PostMapping()
	public ModelAndView Ajout(@ModelAttribute("section") Section s) {
		RedirectView redirectView = new RedirectView("/section");

		if (vSectionService.checkExistance(s.getNomSection(), s.getNiveauSection(), s.getNumGroupe())) {
			ModelAndView m = new ModelAndView(redirectView);
			m.addObject("err", "Section existante !");
			return m;
		}

		ModelAndView m = new ModelAndView(redirectView);
		m.addObject("success", "true");
		vSectionService.save(s);
		return m;
	}

}
