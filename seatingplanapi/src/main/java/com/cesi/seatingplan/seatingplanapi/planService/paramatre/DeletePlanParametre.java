package com.cesi.seatingplan.seatingplanapi.planService.paramatre;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Plan;

public class DeletePlanParametre {

	private Plan plan;

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "DeletePlanParametre [plan=" + plan + "]";
	}
	
	
	
}
