package com.cesi.seatingplan.seatingplanapi.utilisateurService.validation;

import com.cesi.seatingplan.seatingplanapi.commun.validation.AbstractValidation;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.constantes.ConnexionConstantes;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.exceptions.UtilisateurException;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.parametre.ConnexionParametre;

public class ConnexionValidation extends AbstractValidation{
	
	public static void validate(ConnexionParametre param) throws UtilisateurException {
		
		if(!isInferieurNbCarac(param.getIdentifiant(), ConnexionConstantes.NB_CAR_IDENTIFIANT_IN)) {
			throw new UtilisateurException(ConnexionConstantes.ERROR_NB_CAR_IDENTIFIANT);
		}
		
		if(!isInferieurNbCarac(param.getMdp(), ConnexionConstantes.NB_CAR_MDP_IN)) {
			throw new UtilisateurException(ConnexionConstantes.ERROR_NB_CAR_MDP);
		}
		
	}
	
}
