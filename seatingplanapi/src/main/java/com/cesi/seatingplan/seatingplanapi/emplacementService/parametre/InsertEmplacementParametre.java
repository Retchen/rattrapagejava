package com.cesi.seatingplan.seatingplanapi.emplacementService.parametre;

import java.util.List;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Emplacement;
import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;

public class InsertEmplacementParametre {

	private Emplacement emplacement;

	private List<Personne> personnes;
	
	
	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}	
	
}
