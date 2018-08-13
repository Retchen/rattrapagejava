package com.cesi.seatingplan.seatingplanapi.personneService.constantes;

import com.cesi.seatingplan.seatingplanapi.commun.constantes.CommunConstantes;

public interface PersonneConstantes extends CommunConstantes {

	public static final String PATH_CONTROLLEUR = "/personne";

	public static final String PATH_SERVICE_SANSEMPLACEMENT = "/sansEmplacement";

	public static final String ERREUR_AUCUNE_PERSONNE = "Aucune personne n'a été trouvé sans emplacement";

	public static final String ERREUR_PARAM_OBLIGATOIRE_ABSENT = "Un paramètre obligatoire est absent";
}

