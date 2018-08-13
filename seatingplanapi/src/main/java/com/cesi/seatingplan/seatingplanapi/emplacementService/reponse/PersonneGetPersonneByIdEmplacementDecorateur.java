package com.cesi.seatingplan.seatingplanapi.emplacementService.reponse;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;

public class PersonneGetPersonneByIdEmplacementDecorateur extends Personne{

	private boolean occupant;

	public PersonneGetPersonneByIdEmplacementDecorateur (Personne personne) {
		this.setId(personne.getId());
		this.setNom(personne.getNom());
		this.setPrenom(personne.getPrenom());
		this.setEmail(personne.getEmail());
		this.setTelephone(personne.getTelephone());
		this.setDateArrivee(personne.getDateArrivee());
		this.setDateSortie(personne.getDateSortie());
		this.setPosteInterne(personne.getPosteInterne());
	}
	
	
	public boolean isOccupant() {
		return occupant;
	}

	public void setOccupant(boolean occupant) {
		this.occupant = occupant;
	}
	
	
	
}
