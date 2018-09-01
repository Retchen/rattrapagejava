package com.cesi.seatingplan.seatingplanapi.emplacementService.reponse;

import java.util.List;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Plan;
import com.cesi.seatingplan.seatingplanapi.commun.reponse.AbstractReponse;

public class EmplacementsByIdPlanServiceReponse extends AbstractReponse{

	private List<EmplacementDecorateur> emplacement;
	
	private Plan plan;

	public List<EmplacementDecorateur> getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(List<EmplacementDecorateur> emplacement) {
		this.emplacement = emplacement;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "EmplacementsByIdPlanServiceReponse [emplacement=" + emplacement + "]";
	}
	
	
	
}
