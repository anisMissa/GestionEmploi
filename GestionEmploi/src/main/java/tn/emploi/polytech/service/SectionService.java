package tn.emploi.polytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.emploi.polytech.entities.Section;
import tn.emploi.polytech.repository.SectionRepository;

@Service
public class SectionService {
	
	@Autowired
	SectionRepository iSectionRepo;
	
	public boolean checkExistance(String nomSection, String niveauSection, int numGroupe) {
		return (iSectionRepo.findByNomSectionAndNiveauSectionAndNumGroupe(nomSection, niveauSection, numGroupe) != null);
	}

	public List<Section> findAll() {
		return iSectionRepo.findAll();
	}
	
	public Section save(Section s) {
		return iSectionRepo.save(s);
	}
	
	public void delete(Section s) {
		iSectionRepo.delete(s);
	}
}
