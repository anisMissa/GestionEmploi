package tn.emploi.polytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.emploi.polytech.entities.Enseignant;
import tn.emploi.polytech.entities.Horraire;
import tn.emploi.polytech.entities.JourSeance;
import tn.emploi.polytech.entities.Salle;
import tn.emploi.polytech.entities.Seance;
import tn.emploi.polytech.entities.Section;
import tn.emploi.polytech.entities.User;
import tn.emploi.polytech.repository.SalleRepository;
import tn.emploi.polytech.repository.SeanceRepo;

@Service
public class SeanceService {

	@Autowired
	SeanceRepo vSeanceRepo;
	@Autowired
	SalleRepository vSalleRepository;
	

	public Seance verifierEnseignant(Enseignant e,JourSeance j,Horraire h)
	{
		return vSeanceRepo.findByEnseignantAndJourAndHorraire(e, j, h);
	}
	
	public List<Seance> findBySectionAndJour(Section s,JourSeance j)
	{
		return vSeanceRepo.findBySectionAndJour(s, j);
	}
	
	public List<Seance> findEmploiParSection(Section s,JourSeance j)
	{
		return vSeanceRepo.findEmploiParSection(s.getIdSection(), j.ordinal());
	}
	
	public List<Integer> findEnseignantLibre(JourSeance j,Horraire h)
	{
		List<Integer> list= vSeanceRepo.findEnseignantLibre(j.ordinal(), h.getIdHorraire());
		System.out.println(list.size());
		return list;
	}
	
	public List<Salle> findSalleLibre(JourSeance j,Horraire h)
	{
		return vSalleRepository.findSalleLibre(j.ordinal(), h.getIdHorraire());
	}
	
	public void save(Seance s)
	{
		vSeanceRepo.save(s);
	}
}
