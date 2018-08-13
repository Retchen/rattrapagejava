package com.cesi.seatingplan.seatingplanapi.personneService.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;
import com.cesi.seatingplan.seatingplanapi.commun.helper.LoggerHelper;
import com.cesi.seatingplan.seatingplanapi.emplacementService.constantes.EmplacementConstantes;
import com.cesi.seatingplan.seatingplanapi.personneService.constantes.PersonneConstantes;
import com.cesi.seatingplan.seatingplanapi.personneService.exception.PersonneException;
import com.cesi.seatingplan.seatingplanapi.personneService.parametre.DeleteEmplacementPersonneParametre;
import com.cesi.seatingplan.seatingplanapi.personneService.parametre.SaveOrUpdatePersonneParametre;
import com.cesi.seatingplan.seatingplanapi.personneService.reponse.DeleteEmplacementPersonneReponse;
import com.cesi.seatingplan.seatingplanapi.personneService.reponse.PersonneSansEmplacementReponse;
import com.cesi.seatingplan.seatingplanapi.personneService.reponse.SaveOrUpdatePersonneReponse;
import com.cesi.seatingplan.seatingplanapi.personneService.repository.PersonneRepository;
import com.cesi.seatingplan.seatingplanapi.personneService.validation.SaveOrUpdatePersonneValidation;

@RestController
@RequestMapping(PersonneConstantes.PATH_CONTROLLEUR)
public class PersonneControlleur {

	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	private PersonneRepository repository;
	
	/**
	 * Permet de récupérer les personnes sans emplacement
	 * @return List<Personne>
	 */
	@GetMapping(PersonneConstantes.PATH_SERVICE_SANSEMPLACEMENT)
	@ResponseStatus(HttpStatus.OK)
	public PersonneSansEmplacementReponse getPersonneSansEmplacement() {

		PersonneSansEmplacementReponse reponse = new PersonneSansEmplacementReponse();

		List<Personne> result = repository.findPersonneSansEmplacement();
				
		// vérification si la liste retournée est supérieur à 0
		reponse.setMessage((result.size() > 0) ? PersonneConstantes.NO_ERROR_CODE : PersonneConstantes.ERREUR_AUCUNE_PERSONNE);
		reponse.setPersonne(result);
		reponse.setStatut(true);
		LoggerHelper.loggerParamSortie(EmplacementConstantes.PATH_SERVICE_GETALL, reponse.toString());

		return reponse;

	}
	
	@PostMapping(PersonneConstantes.PATH_SERVICE_SANSEMPLACEMENT)
 	@ResponseStatus(HttpStatus.OK)
	public DeleteEmplacementPersonneReponse deleteEmplacementPersonne(@RequestBody DeleteEmplacementPersonneParametre param) {
		
		DeleteEmplacementPersonneReponse reponse = new DeleteEmplacementPersonneReponse();
		
		try {
			
			Personne personne = repository.findById(param.getPersonne().getId());
			
			if(personne == null) throw new PersonneException (PersonneConstantes.ERREUR_AUCUNE_PERSONNE);

			personne.setEmplacement(null);
			repository.save(personne);
		
			reponse.setMessage(PersonneConstantes.NO_ERROR_CODE);
			reponse.setStatut(true);
		}
		catch (PersonneException e) {
			reponse.setMessage(e.toString());
			reponse.setStatut(false);
		}
		
		return reponse;		
	}

	@PostMapping(PersonneConstantes.STRING_VIDE)
 	@ResponseStatus(HttpStatus.OK)
	public SaveOrUpdatePersonneReponse saveOrUpdatePersonne(@RequestBody SaveOrUpdatePersonneParametre param) {
		
		SaveOrUpdatePersonneReponse reponse = new SaveOrUpdatePersonneReponse();
		
		try {
			
			SaveOrUpdatePersonneValidation.validate(param);
			
			repository.save(param.getPersonne());
			
			reponse.setMessage(PersonneConstantes.NO_ERROR_CODE);
			reponse.setStatut(true);
		}
		catch (PersonneException e) {
			reponse.setMessage(e.toString());
			reponse.setStatut(false);
			
			
		}
		
		return reponse; 
		
	}
}
