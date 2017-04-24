package tn.emploi.polytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.emploi.polytech.entities.Compte;
import tn.emploi.polytech.repository.CompteRepository;

@Service
public class CompteService {
	
	@Autowired
	CompteRepository iCompteRepo;

	public List<Compte> findAll() {
		return iCompteRepo.findAll();
	}

	public Compte find(String email, String password) {
		return iCompteRepo.findByEmailAndPassword(email, password);
	}
	
	public Compte save(Compte e) {
		return iCompteRepo.save(e);
	}
	
	public void delete(Compte e) {
		iCompteRepo.delete(e);
	}
}
