package tn.emploi.polytech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.emploi.polytech.entities.Matiere;
import tn.emploi.polytech.service.MatiereService;


@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	MatiereService vMatiereService;

	@GetMapping()
	public ModelAndView afficher(@RequestParam(name = "err", defaultValue = "") String err,
			@RequestParam(name = "success", defaultValue = "false") boolean success) {

		List<Matiere> mat = vMatiereService.findAll();
		ModelAndView m = new ModelAndView("matiere/affiche");
		m.addObject("err", err);
		m.addObject("success", success);
		m.addObject("matieres", mat);
		return m;
	}

	@PostMapping()
	public ModelAndView Ajout(@ModelAttribute("matiere") Matiere mat) {
		RedirectView redirectView = new RedirectView("/matiere");

		if (vMatiereService.checkExistance(mat.getNomMatiere(), mat.getSpecialite())) {
			ModelAndView m = new ModelAndView(redirectView);
			m.addObject("err", "Matière existante !");
			return m;
		}

		ModelAndView m = new ModelAndView(redirectView);
		m.addObject("success", "true");
		vMatiereService.save(mat);
		return m;
	}

}
