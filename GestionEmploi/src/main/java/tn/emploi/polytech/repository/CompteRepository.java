package tn.emploi.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

	public Compte findByEmailAndPassword(String email, String password);
}
