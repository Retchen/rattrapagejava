package com.cesi.seatingplan.seatingplanapi.utilisateurService.constantes;

import com.cesi.seatingplan.seatingplanapi.commun.constantes.CommunConstantes;

public interface ConnexionConstantes extends CommunConstantes{

	public final static int NB_CAR_IDENTIFIANT_IN = 100;
	
	public final static String ERROR_NB_CAR_IDENTIFIANT = "L'indentifiant doit etre en dessous de 100 caractères";
	
	public final static int NB_CAR_MDP_IN = 255;
	
	public final static String ERROR_NB_CAR_MDP = "Le mot de passe doit etre en dessous de 100 caractères";
	
	public final static String ERROR_AUCUN_UTILISATEUR = "Aucun utilisateur trouvé";
	
	
}


