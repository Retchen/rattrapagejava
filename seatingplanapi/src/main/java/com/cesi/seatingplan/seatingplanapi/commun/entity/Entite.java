package com.cesi.seatingplan.seatingplanapi.commun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="entite")
public class Entite {

	@Id
	@GeneratedValue
	private Integer id;

	private String nom;
	
	private Double largeur;
	
	private Double longueur;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getLargeur() {
		return largeur;
	}

	public void setLargeur(Double largeur) {
		this.largeur = largeur;
	}

	public Double getLongueur() {
		return longueur;
	}

	public void setLongueur(Double longueur) {
		this.longueur = longueur;
	}
	
	@Override
	public String toString() {
		return "Entite [id=" + id + ", nom=" + nom + 
				", largeur=" + largeur + ", longueur="
				+ longueur + "]";
	}

}
