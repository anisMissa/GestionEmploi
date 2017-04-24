package tn.emploi.polytech.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Horraire implements Serializable {
	@Id
	private int idHorraire;
	@Column(length=10)
	private String heureDeb;
	@Column(length=10)
	private String heureFin;

	public Horraire() {
		super();
	}

	public Horraire(int id, String heureDeb, String heureFin) {
		super();
		this.idHorraire = id;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
	}

	public int getIdHorraire() {
		return idHorraire;
	}

	public void setIdHorraire(int id) {
		this.idHorraire = id;
	}

	public String getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

}