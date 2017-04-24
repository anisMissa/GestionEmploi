package tn.emploi.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.emploi.polytech.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}