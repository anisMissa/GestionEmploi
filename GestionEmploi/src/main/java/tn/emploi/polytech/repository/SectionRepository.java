package tn.emploi.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
	public Section findByNomSectionAndNiveauSectionAndNumGroupe(String nomSection, String niveauSection, int numGroupe);
}