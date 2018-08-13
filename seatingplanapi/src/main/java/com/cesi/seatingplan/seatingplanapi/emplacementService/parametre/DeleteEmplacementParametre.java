package com.cesi.seatingplan.seatingplanapi.emplacementService.parametre;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Emplacement;

public class DeleteEmplacementParametre {

	private Emplacement emplacement;

	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}

	@Override
	public String toString() {
		return "DeleteEmplacementParametre [emplacement=" + emplacement + "]";
	}
	
	
	
}
