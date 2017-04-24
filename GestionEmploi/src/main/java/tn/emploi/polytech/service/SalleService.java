package tn.emploi.polytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.emploi.polytech.entities.Salle;
import tn.emploi.polytech.repository.SalleRepository;


@Service
public class SalleService {
	
	@Autowired
	SalleRepository iSalleRepo;
	
	
	public boolean checkExistance(String nom, String bloc){
		return (iSalleRepo.findByNomSalleAndBlocSalle(nom, bloc) != null);
	}

	public List<Salle> findAll() {
		return iSalleRepo.findAll();
	}
	
	public Salle save(Salle e) {
		return iSalleRepo.save(e);
	}
	
	public void delete(Salle e) {
		iSalleRepo.delete(e);
	}
}
