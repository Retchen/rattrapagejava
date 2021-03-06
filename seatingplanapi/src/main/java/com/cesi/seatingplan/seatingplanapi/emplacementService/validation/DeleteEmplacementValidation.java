package com.cesi.seatingplan.seatingplanapi.emplacementService.validation;

import com.cesi.seatingplan.seatingplanapi.commun.validation.AbstractValidation;
import com.cesi.seatingplan.seatingplanapi.emplacementService.constantes.EmplacementConstantes;
import com.cesi.seatingplan.seatingplanapi.emplacementService.exception.EmplacementException;
import com.cesi.seatingplan.seatingplanapi.emplacementService.parametre.DeleteEmplacementParametre;

public class DeleteEmplacementValidation extends AbstractValidation{

	public static void validate(DeleteEmplacementParametre param) throws EmplacementException {
		
		if(param.getEmplacement().getId() == null) throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);
		
	}
	
}
