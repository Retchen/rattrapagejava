package com.cesi.seatingplan.seatingplanapi.commun.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("deprecation")
@Entity(name="personne")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class Personne {
	
	@Id
	@GeneratedValue
	private Integer id;

	private String nom;
	
	private String prenom; 
	
	private String email; 
	

	@Column(name="telephone", nullable=true)
	private Integer telephone;
	

	@Column(name="date_arrivee")
	private Date dateArrivee;

	@Column(name="date_sortie")
	private Date dateSortie;
	

	@Column(name="poste_interne")
	private Integer posteInterne;


	@ManyToOne
	@JoinColumn(name = "id_emplacement")
	private Emplacement emplacement;
	
	public Personne() {}
	public Personne(Integer id, String nom, String prenom, String email, Integer telephone, Date dateArrivee,
			Date dateSortie, Integer posteInterne) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.dateArrivee = dateArrivee;
		this.dateSortie = dateSortie;
		this.posteInterne = posteInterne;
	}

	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Integer getPosteInterne() {
		return posteInterne;
	}

	public void setPosteInterne(Integer posteInterne) {
		this.posteInterne = posteInterne;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + ", dateArrivee=" + dateArrivee + ", dateSortie=" + dateSortie + ", posteInterne="
				+ posteInterne + ", emplacement=" + emplacement + "]";
	}
	
	
	
}