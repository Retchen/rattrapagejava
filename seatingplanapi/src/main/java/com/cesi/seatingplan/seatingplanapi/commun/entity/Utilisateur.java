package com.cesi.seatingplan.seatingplanapi.commun.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entité de la table utilisateur
 * @author eliott
 *
 */

@Entity(name="utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String identifiant; 
	
	private String mdp;

	public Utilisateur() {};
	public Utilisateur(Integer id, String identifiant, String mdp) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + id + ", identifiant=" + identifiant + ", mdp=" + mdp + "]";
	}
	
	
}
