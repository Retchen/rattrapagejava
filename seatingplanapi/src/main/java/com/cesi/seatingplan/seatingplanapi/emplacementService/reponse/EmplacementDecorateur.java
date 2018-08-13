package com.cesi.seatingplan.seatingplanapi.emplacementService.reponse;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Emplacement;

public class EmplacementDecorateur extends Emplacement {

	private Boolean occupe;

	public EmplacementDecorateur(Emplacement emplacement) {
		setId			(emplacement.getId());
		setPosX			(emplacement.getPosX());
		setPosY			(emplacement.getPosY());
		setOrientation	(emplacement.getOrientation());
		setEntite		(emplacement.getEntite());
		setPlan			(emplacement.getPlan());
	}

	public Boolean getOccupe() {
		return occupe;
	}

	public void setOccupe(Boolean occupe) {
		this.occupe = occupe;
	}

	@Override
	public String toString() {
		return "Emplacement [id=" + super.getId() + ", posX=" + super.getPosX() + ", posY=" + super.getPosY() + ", orientation=" + super.getOrientation()
				+ ", entite=" + super.getEntite() + ", plan=" + super.getPlan() + ", occupe=" + occupe + "]";
	}
	
	
	

}
