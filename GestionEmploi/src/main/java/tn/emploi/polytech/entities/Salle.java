package tn.emploi.polytech.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Salle implements Serializable{
	@Id
	@GeneratedValue
	private int idSalle;
	@Column(length=10)
	private String nomSalle;
	@Column(length=10)
	private String blocSalle;
	
	public Salle() {
		super();
	}

	public Salle(String nomSalle, String blocSalle) {
		super();
		this.nomSalle = nomSalle;
		this.blocSalle = blocSalle;
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public String getBlocSalle() {
		return blocSalle;
	}

	public void setBlocSalle(String blocSalle) {
		this.blocSalle = blocSalle;
	}
	
}
