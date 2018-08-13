package com.cesi.seatingplan.seatingplanapi.emplacementService.reponse;

import java.util.ArrayList;
import java.util.List;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;
import com.cesi.seatingplan.seatingplanapi.commun.reponse.AbstractReponse;

public class EmplacementDetailByIdEmplacementReponse extends AbstractReponse{

	private ArrayList<PersonneGetPersonneByIdEmplacementDecorateur> personne;
	
	public ArrayList<PersonneGetPersonneByIdEmplacementDecorateur> getPersonne() {
		return personne;
	}

	public void setPersonne(ArrayList<PersonneGetPersonneByIdEmplacementDecorateur> personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "EmplacementDetailByIdEmplacementReponse [personne=" + personne + "]";
	}


	

}
