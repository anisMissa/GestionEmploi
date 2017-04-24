package tn.emploi.polytech.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Section {
	@Id
	@GeneratedValue
	private int idSection;
	@Column(length = 100)
	private String nomSection;
	@Column(length = 100)
	private String niveauSection;
	private int numGroupe;

	@OneToMany
	@JoinTable(name = "emploi", joinColumns = @JoinColumn(name = "idSection", referencedColumnName = "idSection"), inverseJoinColumns = @JoinColumn(name = "idSeance", referencedColumnName = "idSeance"))
	private Set<Seance> emploi = new HashSet<Seance>();

	public Section() {
		super();
	}

	public Section(String nomSection, String niveauSection, int numGroupe) {
		super();
		this.nomSection = nomSection;
		this.niveauSection = niveauSection;
		this.numGroupe = numGroupe;
	}

	public int getIdSection() {
		return idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}

	public String getNomSection() {
		return nomSection;
	}

	public void setNomSection(String nomSection) {
		this.nomSection = nomSection;
	}

	public String getNiveauSection() {
		return niveauSection;
	}

	public void setNiveauSection(String niveauSection) {
		this.niveauSection = niveauSection;
	}

	public int getNumGroupe() {
		return numGroupe;
	}

	public void setNumGroupe(int numGroupe) {
		this.numGroupe = numGroupe;
	}

}
