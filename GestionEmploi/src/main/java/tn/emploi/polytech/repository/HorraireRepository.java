package tn.emploi.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Horraire;

@Repository
public interface HorraireRepository extends JpaRepository<Horraire, Long> {
	
	public Horraire findByHeureDebAndHeureFin(String HeureDeb,String HeureFin);

}
