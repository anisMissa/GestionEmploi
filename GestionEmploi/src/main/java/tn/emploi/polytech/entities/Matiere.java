package tn.emploi.polytech.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Matiere implements Serializable{
	@Id
	@GeneratedValue
	private int idMatiere;
	@Column(length=50)
	private String nomMatiere;
	@Column(length=50)
	private String specialite;

	public Matiere() {
		super();
	}

	public Matiere(int idMatiere, String nomMatiere, String specialite) {
		super();
		this.idMatiere = idMatiere;
		this.nomMatiere = nomMatiere;
		this.specialite = specialite;
	}

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

}
