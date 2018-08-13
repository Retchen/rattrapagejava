package com.cesi.seatingplan.seatingplanapi.emplacementService.validation;

import java.util.List;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Emplacement;
import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;
import com.cesi.seatingplan.seatingplanapi.commun.validation.AbstractValidation;
import com.cesi.seatingplan.seatingplanapi.emplacementService.constantes.EmplacementConstantes;
import com.cesi.seatingplan.seatingplanapi.emplacementService.exception.EmplacementException;
import com.cesi.seatingplan.seatingplanapi.emplacementService.parametre.InsertEmplacementParametre;

public class insertEmplacementValidation extends AbstractValidation {

	public static void validate (InsertEmplacementParametre param) throws EmplacementException{
		
		
		// ==========================================================
		// ============== Validation de l'emplacement ===============
		// ==========================================================
		 
		Emplacement e = param.getEmplacement();
		
		if (e.getPosX() == null) {
			throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);
		}
		
		if(e.getPosY() == null ) {
			throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);	
		}
		
		if(EmplacementConstantes.STRING_VIDE.equals(e.getOrientation())) {
			throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);		
		}
		
		if(e.getEntite().getId() == null) {
			throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);	
		}
		
		if(e.getPlan().getId() == null) {
			throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);
		}
		
		// ==========================================================
		// ============== Validation des personnes 	  ===============
		// ==========================================================
		 
		List<Personne> ps = param.getPersonnes();
		
		for(Personne p : ps) {
			if(p.getId() == null) {
				throw new EmplacementException(EmplacementConstantes.MISSING_PARAM);	
			}
		}
	
	}
	
}
