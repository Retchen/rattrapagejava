package com.cesi.seatingplan.seatingplanapi.entiteService.reponse;

import java.util.List;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Entite;
import com.cesi.seatingplan.seatingplanapi.commun.reponse.AbstractReponse;

public class EntiteGetAllReponse extends AbstractReponse {

	private List<Entite> entite;

	public List<Entite> getEntite() {
		return entite;
	}

	public void setEntite(List<Entite> entite) {
		this.entite = entite;
	}

	@Override
	public String toString() {
		return "EntiteGetAllReponse [entite=" + entite + "]";
	}
	
	
}
