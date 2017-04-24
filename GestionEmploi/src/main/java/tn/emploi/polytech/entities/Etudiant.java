package tn.emploi.polytech.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("etudiant")
public class Etudiant extends User{
	@ManyToOne
	@JoinColumn(name="idSection")
	private Section section;

	public Etudiant() {
		super();
	}

	public Etudiant(String nom, String prenom, String address, String telephone, Section section) {
		super(nom, prenom, address, telephone);
		this.section = section;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}
