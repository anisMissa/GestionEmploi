package tn.emploi.polytech.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Compte implements Serializable{
	@Id
	@GeneratedValue(generator= "newGenerator")
	@GenericGenerator(name= "newGenerator", strategy = "foreign", parameters= { @Parameter(value= "user", name= "property") })
	private int idCompte;
	private String email;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUser")
	private User user = new User();

	public Compte() {
		super();
	}

	public Compte(User user, String email, String password) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
