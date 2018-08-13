package com.cesi.seatingplan.seatingplanapi.planService.parametre;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Plan;

public class SaveOrUpdatePlanParametre {

	private Plan plan;

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "SaveOrUpdatePlanParametre [plan=" + plan + "]";
	}
	
	
	
}
