package tn.emploi.polytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.emploi.polytech.entities.Enseignant;
import tn.emploi.polytech.repository.EnseignantRepository;

@Service
public class EnseignantService {
	
	@Autowired
	EnseignantRepository iEnseignantRepo;

	public List<Enseignant> findAll() {
		return iEnseignantRepo.findAll();
	}
	
	public Enseignant save(Enseignant e) {
		return iEnseignantRepo.save(e);
	}
	
	public void delete(Enseignant e) {
		iEnseignantRepo.delete(e);
	}
	
	public Enseignant findByIdUser(int idUser) {
		return iEnseignantRepo.findByIdUser(idUser);
	}
}
