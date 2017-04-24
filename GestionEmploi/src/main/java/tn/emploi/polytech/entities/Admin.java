package tn.emploi.polytech.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{
	private String poste;

	public Admin() {
		super();
	}
	public Admin(String nom, String prenom, String address, String telephone, String poste) {
		super(nom, prenom, address, telephone);
		this.poste = poste;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

}
