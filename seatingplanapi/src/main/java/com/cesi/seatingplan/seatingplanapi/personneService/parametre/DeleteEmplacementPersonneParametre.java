package com.cesi.seatingplan.seatingplanapi.personneService.parametre;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;

public class DeleteEmplacementPersonneParametre {

	private Personne personne;

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "DeleteEmplacementPersonneParametre [personne=" + personne + "]";
	}
	
	
	
}
