package tn.emploi.polytech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.emploi.polytech.entities.Enseignant;
import tn.emploi.polytech.entities.Horraire;
import tn.emploi.polytech.entities.JourSeance;
import tn.emploi.polytech.entities.Matiere;
import tn.emploi.polytech.entities.Salle;
import tn.emploi.polytech.entities.Seance;
import tn.emploi.polytech.entities.Section;
import tn.emploi.polytech.service.EnseignantService;
import tn.emploi.polytech.service.MatiereService;
import tn.emploi.polytech.service.SeanceService;
import tn.emploi.polytech.service.SectionService;

@RestController
@RequestMapping("/seance")
public class SeanceController {

	@Autowired
	SeanceService vSeanceService;
	@Autowired
	SectionService vSectionService;
	@Autowired
	EnseignantService vEnseignantService;
	@Autowired
	MatiereService vMatiereService;

	@GetMapping()
	public ModelAndView index() {
		List<Section> ls = vSectionService.findAll();
		ModelAndView m = new ModelAndView("emploi/home");
		m.addObject("sections", ls);
		return m;
	}

	@GetMapping("/get/{idSection}")
	public ModelAndView getSectionEmploi(@PathVariable("idSection") int id) {
		Section s = new Section();
		s.setIdSection(id);
		List<Seance> lundi = vSeanceService.findEmploiParSection(s, JourSeance.LUNDI);
		List<Seance> mardi = vSeanceService.findEmploiParSection(s, JourSeance.MARDI);
		List<Seance> mercredi = vSeanceService.findEmploiParSection(s, JourSeance.MERCREDI);
		List<Seance> jeudi = vSeanceService.findEmploiParSection(s, JourSeance.JEUDI);
		List<Seance> vendredi = vSeanceService.findEmploiParSection(s, JourSeance.VENDREDI);
		List<Seance> samedi = vSeanceService.findEmploiParSection(s, JourSeance.SAMEDI);

		lundi.add(2, null);
		mardi.add(2, null);
		mercredi.add(2, null);
		jeudi.add(2, null);
		vendredi.add(2, null);
		samedi.add(2, null);
		
		ModelAndView m = new ModelAndView("/emploi/section");
		m.addObject("mardi", mardi);
		m.addObject("lundi", lundi);
		m.addObject("mercredi", mercredi);
		m.addObject("jeudi", jeudi);
		m.addObject("vendredi", vendredi);
		m.addObject("samedi", samedi);

		return m;
	}
	
	@GetMapping("/availableEnseignant/{jour}/{idHorraire}")
	public ModelAndView availableEnseignant(@PathVariable("jour") JourSeance jour, @PathVariable("idHorraire") int idHorraire) {
		Horraire h = new Horraire();
		h.setIdHorraire(idHorraire);
		List<Integer> ens_id = vSeanceService.findEnseignantLibre(jour, h);
		List<Enseignant> ens = new ArrayList<Enseignant>();
		
		for (int i = 0; i < ens_id.size(); i++) {
			ens.add(vEnseignantService.findByIdUser(ens_id.get(i)));
		}
		
		ModelAndView m = new ModelAndView("emploi/enseignants");
		m.addObject("enseignants", ens);
		return m;
	}
	
	@GetMapping("/availableMatiere")
	public ModelAndView availableMatiere() {
		
		List<Matiere> matieres = vMatiereService.findAll();
		
		ModelAndView m = new ModelAndView("emploi/matieres");
		m.addObject("matieres", matieres);
		return m;
	}
	
	@GetMapping("/findSalleLibre/{jour}/{idHorraire}")
	public ModelAndView findSalleLibre(@PathVariable("jour") JourSeance jour, @PathVariable("idHorraire") int idHorraire) {
		
		Horraire h = new Horraire();
		h.setIdHorraire(idHorraire);
		List<Salle> salles = vSeanceService.findSalleLibre(jour, h);
		
		ModelAndView m = new ModelAndView("emploi/salles");
		m.addObject("salles", salles);
		return m;
	}

	@GetMapping("/verifier/{idUser}/{jour}/{idH}")
	public Seance getList(@PathVariable("idUser") int idUser, @PathVariable("jour") String jour,
			@PathVariable("idH") int idH) {

		Horraire h = new Horraire();
		h.setIdHorraire(idH);
		Enseignant e = new Enseignant();
		e.setIdUser(idUser);

		return vSeanceService.verifierEnseignant(e, JourSeance.valueOf(jour), h);
	}
	
	@PostMapping("/add")
	public ModelAndView ajouter(@ModelAttribute("seance") Seance s)
	{
		vSeanceService.save(s);
		RedirectView v=new RedirectView("/seance");
		ModelAndView m=new ModelAndView(v);
		return m;
	}
	
}
