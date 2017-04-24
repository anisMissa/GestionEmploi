package tn.emploi.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Enseignant;


@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	public Enseignant findByIdUser(int idUser);
}
