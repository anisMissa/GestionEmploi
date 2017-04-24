package tn.emploi.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findByIdUser(int idUser);
}
