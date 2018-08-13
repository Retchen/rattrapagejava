package com.cesi.seatingplan.seatingplanapi.planService.validation;

import com.cesi.seatingplan.seatingplanapi.commun.validation.AbstractValidation;
import com.cesi.seatingplan.seatingplanapi.planService.constantes.PlanServiceConstantes;
import com.cesi.seatingplan.seatingplanapi.planService.exception.PlanException;
import com.cesi.seatingplan.seatingplanapi.planService.parametre.SaveOrUpdatePlanParametre;

public class SaveOrUpdatePlanValidation extends AbstractValidation{

	public static void validate(SaveOrUpdatePlanParametre param) throws PlanException {
		
		if(PlanServiceConstantes.STRING_VIDE.equals(param.getPlan().getNom())) throw new PlanException(PlanServiceConstantes.MISSING_PARAM);
	}
}
