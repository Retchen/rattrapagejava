package com.cesi.seatingplan.seatingplanapi.utilisateurService.reponse;

import org.hibernate.annotations.Parent;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Utilisateur;
import com.cesi.seatingplan.seatingplanapi.commun.reponse.AbstractReponse;

public class ConnexionReponse extends AbstractReponse{

	private Utilisateur utilisateur;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return super.toString() + " ConnexionReponse [utilisateur=" + utilisateur + "]";
	}

	
	
}
