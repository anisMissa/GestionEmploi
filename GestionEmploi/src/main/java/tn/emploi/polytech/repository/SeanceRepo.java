package tn.emploi.polytech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Enseignant;
import tn.emploi.polytech.entities.Horraire;
import tn.emploi.polytech.entities.JourSeance;
import tn.emploi.polytech.entities.Salle;
import tn.emploi.polytech.entities.Seance;
import tn.emploi.polytech.entities.Section;

@Repository
public interface SeanceRepo extends JpaRepository<Seance, Long> {

	public List<Seance> findByJour(JourSeance jour);

	public Seance findByEnseignantAndJourAndHorraire(Enseignant e, JourSeance j, Horraire h);

	public Seance findBySalleAndJourAndHorraire(Salle s, JourSeance j, Horraire h);

	public Seance findBySectionAndJourAndHorraire(Section s, JourSeance j, Horraire h);

	public List<Seance> findBySectionAndJour(Section s, JourSeance j);

	@Query(value = "SELECT * FROM seance s RIGHT JOIN horraire h ON s.id_horraire = h.id_horraire AND jour = ?2 AND id_section=?1", nativeQuery = true)
	List<Seance> findEmploiParSection(int section, int jour);
	
	@Query(value = "select id_user from user u  WHERE u.type_user='enseignant' and u.id_user not in(select u.id_user from user u  join seance s on u.id_user=s.id_user AND u.type_user='enseignant' AND s.jour = ?1 AND s.id_horraire = ?2)", nativeQuery = true)
	public List<Integer> findEnseignantLibre( int j, int h);
	//public List<Seance> findEnseignantByJourNotAndHorraireNot( JourSeance j, Horraire h);
	
	
}
