package com.cesi.seatingplan.seatingplanapi.planService.reponse;

import java.util.List;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Plan;
import com.cesi.seatingplan.seatingplanapi.commun.reponse.AbstractReponse;

public class PlanReponse extends AbstractReponse{
	
	private List<Plan> plan;

	public List<Plan> getPlan() {
		return plan;
	}

	public void setPlan(List<Plan> plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "PlanReponse [plan=" + plan + "]";
	}

	

}
