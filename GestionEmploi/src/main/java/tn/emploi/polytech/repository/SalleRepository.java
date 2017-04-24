package tn.emploi.polytech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
	public Salle findByNomSalleAndBlocSalle(String nomSalle, String blocSalle);

	@Query(value = "select * from salle s WHERE s.id_salle not in(select s.id_salle from salle s join seance se on s.id_salle=se.id_salle AND se.jour = ?1 AND se.id_horraire = ?2)", nativeQuery = true)
	public List<Salle> findSalleLibre( int j, int h);
}
