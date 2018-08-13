package com.cesi.seatingplan.seatingplanapi.personneService.validation;

import javax.persistence.PersistenceException;

import com.cesi.seatingplan.seatingplanapi.commun.validation.AbstractValidation;
import com.cesi.seatingplan.seatingplanapi.personneService.constantes.PersonneConstantes;
import com.cesi.seatingplan.seatingplanapi.personneService.exception.PersonneException;
import com.cesi.seatingplan.seatingplanapi.personneService.parametre.SaveOrUpdatePersonneParametre;

public class SaveOrUpdatePersonneValidation extends AbstractValidation{

	public static void validate(SaveOrUpdatePersonneParametre param) throws PersonneException {
		
		if(PersonneConstantes.STRING_VIDE.equals(param.getPersonne().getNom())) throw new PersonneException(PersonneConstantes.ERREUR_PARAM_OBLIGATOIRE_ABSENT);
		
		if(PersonneConstantes.STRING_VIDE.equals(param.getPersonne().getPrenom())) throw new PersonneException(PersonneConstantes.ERREUR_PARAM_OBLIGATOIRE_ABSENT);
		
	}
	
}
