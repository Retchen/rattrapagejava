package com.cesi.seatingplan.seatingplanapi.emplacementService.validation;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;
import com.cesi.seatingplan.seatingplanapi.emplacementService.constantes.EmplacementConstantes;
import com.cesi.seatingplan.seatingplanapi.emplacementService.exception.EmplacementException;
import com.cesi.seatingplan.seatingplanapi.emplacementService.parametre.UpdateEmplacementPersonnesParametre;

public class UpdateEmplacementPersonneValidation {

	public static void validate(UpdateEmplacementPersonnesParametre param) throws EmplacementException {
		
		if(param.getEmplacement().getId() == null) throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);
		
		for(Personne personne : param.getPersonnes()) {
			if(personne.getId() == null) throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);
		}
	}
	
}
