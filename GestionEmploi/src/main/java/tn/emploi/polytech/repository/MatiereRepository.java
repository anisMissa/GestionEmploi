package tn.emploi.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long>{
	public Matiere findByNomMatiereAndSpecialite(String nomMatiere,String specialite);
}
