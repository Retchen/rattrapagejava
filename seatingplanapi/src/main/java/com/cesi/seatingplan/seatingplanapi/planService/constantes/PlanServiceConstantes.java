package com.cesi.seatingplan.seatingplanapi.planService.constantes;

import com.cesi.seatingplan.seatingplanapi.commun.constantes.CommunConstantes;

public interface PlanServiceConstantes extends CommunConstantes{

	public static final String PATH_CONTROLLEUR = "/plan";
	
	public static final String PATH_SERVICE_GETALL = "/getAll";
	
	public static final String PATH_SERVICE_GETONE= "/{id}";
	
	
	public static final String ERREUR_AUCUN_PLAN = "Aucun plan n'a été trouvé"; 
	
}
