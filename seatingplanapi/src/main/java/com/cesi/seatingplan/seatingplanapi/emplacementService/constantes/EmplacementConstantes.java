package com.cesi.seatingplan.seatingplanapi.emplacementService.constantes;

import com.cesi.seatingplan.seatingplanapi.commun.constantes.CommunConstantes;

public interface EmplacementConstantes extends CommunConstantes{

	public static final String PATH_CONTROLLEUR = "/emplacement";
	
	public static final String PATH_SERVICE_GETALL = "/{idPlan}";
	
	public static final String ERREUR_AUCUN_EMPLACEMENT = "Aucun emplacement n'a été trouvé pour l'idPlan = ";

	public static final String PATH_SERVICE_FINDBYIDEMPLACEMENT = "detail/{idEmplacement}";

	public static final String ERREUR_AUCUNE_PERSONNE = "Aucune personne n'a été trouvé à cet emplacement";
	
	public static final String ERREUR_AUCUNE_MATERIEL = "Aucun materiel n'a été trouvé à cet emplacement";
	
	public static final String ERREUR_NAMEMATERIEL_DEJAPRESENT= "Un matériel saisie est deja present";	

	public static final String PATH_SERVICE_ADDEMPLACEMENTPERSONNE = "/addPersonnes";

	public static final String ERREUR_AUCUNE_EMPLACEMENT = "Aucun emplacement n'a été trouvé";


}
