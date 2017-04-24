package tn.emploi.polytech.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Seance implements Serializable {
	@Id
	@GeneratedValue
	private int idSeance;
	@ManyToOne
	@JoinColumn(name = "idHorraire")
	private Horraire horraire;

	@ManyToOne
	@JoinColumn(name = "idSection")
	private Section section;

	@ManyToOne
	@JoinColumn(name = "idSalle")
	private Salle salle;
	@ManyToOne
	@JoinColumn(name = "idUser")
	private Enseignant enseignant;
	@ManyToOne
	@JoinColumn(name = "idMatiere")
	private Matiere matiere;
	private JourSeance jour;

	public Seance() {
		super();
	}

	public Seance(Horraire horraire, Section section, Salle salle, Enseignant enseignant, Matiere matiere,
			JourSeance jour) {
		super();
		this.horraire = horraire;
		this.section = section;
		this.salle = salle;
		this.enseignant = enseignant;
		this.matiere = matiere;
		this.jour = jour;
	}

	public Horraire getHorraire() {
		return horraire;
	}

	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public void setHorraire(Horraire horraire) {
		this.horraire = horraire;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public JourSeance getJour() {
		return jour;
	}

	public void setJour(JourSeance jour) {
		this.jour = jour;
	}

	@Override
	public String toString() {
		return "Seance [idSeance=" + idSeance + ", horraire=" + horraire + ", section=" + section + ", salle=" + salle
				+ ", enseignant=" + enseignant + ", matiere=" + matiere + ", jour=" + jour + "]";
	}

	
}
