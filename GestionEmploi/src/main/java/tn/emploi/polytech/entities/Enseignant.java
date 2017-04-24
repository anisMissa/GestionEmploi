package tn.emploi.polytech.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("enseignant")
public class Enseignant extends User{
	private String specialite;
	private String grade;
	
	public Enseignant(){
		super();
	}

	public Enseignant(String nom, String prenom, String address, String telephone, String specialite, String grade) {
		super(nom, prenom, address, telephone);
		this.specialite = specialite;
		this.grade = grade;
	}
	

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
