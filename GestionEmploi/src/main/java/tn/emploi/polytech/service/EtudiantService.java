package tn.emploi.polytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.emploi.polytech.entities.Etudiant;
import tn.emploi.polytech.repository.EtudiantRepository;

@Service
public class EtudiantService {
	
	@Autowired
	EtudiantRepository iEtudiantRepo;

	public List<Etudiant> findAll() {
		return iEtudiantRepo.findAll();
	}
	
	public Etudiant findByNomAndPrenomAndAddress(Etudiant e) {
		return iEtudiantRepo.findByNomAndPrenomAndAddress(e.getNom(), e.getPrenom(), e.getAddress());
	}
	
	public Etudiant save(Etudiant e) {
		return iEtudiantRepo.save(e);
	}
	
	public void delete(Etudiant e) {
		iEtudiantRepo.delete(e);
	}
}
