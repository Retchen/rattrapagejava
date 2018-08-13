package com.cesi.seatingplan.seatingplanapi.commun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="plan")
public class Plan {

	@Id
	@GeneratedValue
	private Integer id;

	private String nom; 
	
	private String image;
	
	@Column(name="echelle_pixel")
	private Integer echellePixel;
	
	@Column(name="echelle_cm")
	private Integer echelleCm;

	@Column(name="image_longueur")
	private Integer imageLongueur;

	@Column(name="image_largeur")
	private Integer imageLargeur;

	public Plan() {}	

	
	public Plan(Integer id, String nom, String image, Integer echellePixel, Integer echelleCm, Integer imageLongueur,
			Integer imageLargeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.image = image;
		this.echellePixel = echellePixel;
		this.echelleCm = echelleCm;
		this.imageLongueur = imageLongueur;
		this.imageLargeur = imageLargeur;
	}


	public Integer getImageLongueur() {
		return imageLongueur;
	}
	public void setImageLongueur(Integer imageLongueur) {
		this.imageLongueur = imageLongueur;
	}
	public Integer getImageLargeur() {
		return imageLargeur;
	}
	public void setImageLargeur(Integer imageLargeur) {
		this.imageLargeur = imageLargeur;
	}
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getEchellePixel() {
		return echellePixel;
	}

	public void setEchellePixel(Integer echellePixel) {
		this.echellePixel = echellePixel;
	}

	public Integer getEchelleCm() {
		return echelleCm;
	}

	public void setEchelleCm(Integer echelleCm) {
		this.echelleCm = echelleCm;
	}


	@Override
	public String toString() {
		return "Plan [id=" + id + ", nom=" + nom + ", image=" + image + ", echellePixel=" + echellePixel
				+ ", echelleCm=" + echelleCm + ", imageLongueur=" + imageLongueur + ", imageLargeur=" + imageLargeur
				+ "]";
	}


	
	
}
