package com.cesi.seatingplan.seatingplanapi.utilisateurService.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Utilisateur;
import com.cesi.seatingplan.seatingplanapi.commun.helper.LoggerHelper;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.constantes.ConnexionConstantes;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.constantes.UtilisateurServiceConstantes;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.exceptions.UtilisateurException;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.parametre.ConnexionParametre;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.reponse.ConnexionReponse;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.repository.UtilisateurRepository;
import com.cesi.seatingplan.seatingplanapi.utilisateurService.validation.ConnexionValidation;

@RestController
@RequestMapping(UtilisateurServiceConstantes.PATH_CONTROLLEUR)
public class UtilisateurControlleur {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private UtilisateurRepository repository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Utilisateur> getUtilisateurs(){
		List<Utilisateur> result =  repository.findAll();
		
		return result;
	}
	
	@GetMapping(UtilisateurServiceConstantes.PATH_SERVICE_CONNEXION)
	@ResponseStatus(HttpStatus.OK)
	public ConnexionReponse connexion(@RequestParam String identifiant, @RequestParam String mdp){
		
		
		ConnexionParametre param = new ConnexionParametre();
		param.setIdentifiant(identifiant);
		param.setMdp(mdp);
		
		ConnexionReponse reponse = new ConnexionReponse();
		
		LoggerHelper.loggerParamEntree(UtilisateurServiceConstantes.PATH_SERVICE_CONNEXION, param.toString());
		
		try {
			ConnexionValidation.validate(param);
			
			Utilisateur result = repository.findByIdentifiantAndMdp(param.getIdentifiant(), param.getMdp());
			
			if(result != null) {
				
				reponse.setMessage(ConnexionConstantes.NO_ERROR_CODE);
				reponse.setStatut(true);
				reponse.setUtilisateur(result);				
				LoggerHelper.loggerParamSortie(UtilisateurServiceConstantes.PATH_SERVICE_CONNEXION, reponse.toString());
				
			}
			else {
				reponse.setMessage(ConnexionConstantes.ERROR_AUCUN_UTILISATEUR);
				reponse.setStatut(false);
			}

		} catch (UtilisateurException e) {
			reponse.setStatut(false);
			reponse.setMessage(e.getMessage());
		}
		
		return reponse;		
		
	}
	
	
	
}
