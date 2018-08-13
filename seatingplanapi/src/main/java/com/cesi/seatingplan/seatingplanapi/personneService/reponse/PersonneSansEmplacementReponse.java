package com.cesi.seatingplan.seatingplanapi.personneService.reponse;

import java.util.List;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;
import com.cesi.seatingplan.seatingplanapi.commun.reponse.AbstractReponse;

 public class PersonneSansEmplacementReponse extends AbstractReponse{
	  
	private List<Personne> personne; 


	public List<Personne> getPersonne() {
		return personne;
	}


	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}


	@Override
	public String toString() {
		return super.toString() + "PersonneSansEmplacementReponse [personne=" + personne + "]";
	}

	
}
