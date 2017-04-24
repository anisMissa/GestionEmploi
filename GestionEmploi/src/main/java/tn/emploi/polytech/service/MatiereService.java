package tn.emploi.polytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.emploi.polytech.entities.Matiere;
import tn.emploi.polytech.repository.MatiereRepository;

@Service
public class MatiereService {
	
	@Autowired
	MatiereRepository iMatiereRepo;
	
	public boolean checkExistance(String nomMatiere,String specialite) {
		return (iMatiereRepo.findByNomMatiereAndSpecialite(nomMatiere, specialite) != null);
	}

	public List<Matiere> findAll() {
		return iMatiereRepo.findAll();
	}
	
	public Matiere save(Matiere s) {
		return iMatiereRepo.save(s);
	}
	
	public void delete(Matiere s) {
		iMatiereRepo.delete(s);
	}
}
