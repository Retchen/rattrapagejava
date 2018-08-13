package com.cesi.seatingplan.seatingplanapi.emplacementService.controlleurs;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Emplacement;
import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;
import com.cesi.seatingplan.seatingplanapi.commun.helper.LoggerHelper;
import com.cesi.seatingplan.seatingplanapi.emplacementService.constantes.EmplacementConstantes;
import com.cesi.seatingplan.seatingplanapi.emplacementService.exception.EmplacementException;
import com.cesi.seatingplan.seatingplanapi.emplacementService.parametre.DeleteEmplacementParametre;
import com.cesi.seatingplan.seatingplanapi.emplacementService.parametre.InsertEmplacementParametre;
import com.cesi.seatingplan.seatingplanapi.emplacementService.parametre.UpdateEmplacementPersonnesParametre;
import com.cesi.seatingplan.seatingplanapi.emplacementService.reponse.*;
import com.cesi.seatingplan.seatingplanapi.emplacementService.repository.EmplacementRepository;
import com.cesi.seatingplan.seatingplanapi.emplacementService.validation.DeleteEmplacementValidation;
import com.cesi.seatingplan.seatingplanapi.emplacementService.validation.UpdateEmplacementPersonneValidation;
import com.cesi.seatingplan.seatingplanapi.emplacementService.validation.insertEmplacementValidation;
import com.cesi.seatingplan.seatingplanapi.personneService.repository.PersonneRepository;
import com.cesi.seatingplan.seatingplanapi.planService.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping(EmplacementConstantes.PATH_CONTROLLEUR)
public class EmplacementControlleur{

	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	private EmplacementRepository repository;

	@Autowired
	private PersonneRepository repositoryPersonne;
	
	@Autowired
	private PlanRepository repositoryPlan;
	
	/**
	 * getEmplacement
	 * @param idPlan
	 * @return EmplacementsByIdPlanServiceReponse
	 */
	@GetMapping(EmplacementConstantes.PATH_SERVICE_GETALL)
	@ResponseStatus(HttpStatus.OK)
	public EmplacementsByIdPlanServiceReponse getEmplacement(@PathVariable Integer idPlan) {

		EmplacementsByIdPlanServiceReponse reponse = new EmplacementsByIdPlanServiceReponse();

		List<Emplacement> result = repository.findByPlan_id(idPlan);

		reponse.setEmplacement(mapperEmplacementDecorateur(result));

		//TODO FSU : c'est pas dutout opti
		for (EmplacementDecorateur emplacement : reponse.getEmplacement()) {
			int nbPersonne = repositoryPersonne.countUtilisateurByEmplacement(emplacement.getId());
			emplacement.setOccupe((nbPersonne > 0 ) ? true : false);
		}
		
		reponse.setPlan(repositoryPlan.findOne(idPlan));
		
		reponse.setStatut(true);

		// vérification si la liste retournée est supérieur à 0
		reponse.setMessage((result.size() > 0) ? EmplacementConstantes.NO_ERROR_CODE : EmplacementConstantes.ERREUR_AUCUN_EMPLACEMENT + idPlan);

		LoggerHelper.loggerParamSortie(EmplacementConstantes.PATH_SERVICE_GETALL, reponse.toString());

		return reponse;

	}

	
	/**
	 * Permet de récupérer un emplacement, la personne associer et le matériel grace à son emplacement id
	 * @return EmplacementDetailByIdEmplacementReponse
	 */
	@GetMapping(EmplacementConstantes.PATH_SERVICE_FINDBYIDEMPLACEMENT)
	@ResponseStatus(HttpStatus.OK)
	public EmplacementDetailByIdEmplacementReponse getPersonneByIdEmplacement(@PathVariable Integer idEmplacement) {
		
		LoggerHelper.loggerParamEntree(EmplacementConstantes.PATH_SERVICE_FINDBYIDEMPLACEMENT, idEmplacement.toString());
		
		String message = null;
	
		EmplacementDetailByIdEmplacementReponse reponse = new EmplacementDetailByIdEmplacementReponse();

		List<Personne> personnes = repositoryPersonne.findPersonneByIdEmplacement(idEmplacement);

		Date actuelle = new Date();
		
		reponse.setPersonne(new ArrayList<PersonneGetPersonneByIdEmplacementDecorateur>());
		
		for (Personne personne : personnes) {
			PersonneGetPersonneByIdEmplacementDecorateur tamp_personne = new PersonneGetPersonneByIdEmplacementDecorateur(personne);
			if(tamp_personne.getDateSortie() == null ) {
				tamp_personne.setOccupant(true);	
			}
			else if (tamp_personne.getDateArrivee().compareTo(actuelle) == -1 && tamp_personne.getDateSortie().compareTo(actuelle) == 1 ) {
				tamp_personne.setOccupant(true);
			}
			else {
				tamp_personne.setOccupant(false);
					
			}
			reponse.getPersonne().add(tamp_personne);
			
		}
		
		message += ((personnes.size() > 0) ? EmplacementConstantes.STRING_VIDE : EmplacementConstantes.ERREUR_AUCUNE_PERSONNE);

		//TODO FSU : Gerer le cas ou plusieur message soit retourné
		//message = (EmplacementConstantes.STRING_VIDE.equals(message)) ? EmplacementConstantes.NO_ERROR_CODE : "toto";

		reponse.setStatut(true);
		LoggerHelper.loggerParamSortie(EmplacementConstantes.PATH_SERVICE_FINDBYIDEMPLACEMENT, reponse.toString());

		return reponse;

	}
	
	/**
	 * Permet d'ajouter un nouvel emplacement et de mettre à jour les personnes liées à l'emplacement. 
	 * @param param
	 * @return InsertEmplacementReponse
	 */
	@PostMapping(EmplacementConstantes.STRING_VIDE)
 	@ResponseStatus(HttpStatus.OK)
	public InsertEmplacementReponse insertEmplacement(@RequestBody InsertEmplacementParametre param) {
					
		InsertEmplacementReponse reponse = new InsertEmplacementReponse();

		try {
		
			insertEmplacementValidation.validate(param);
			
			
			// Insertion de l'emplacement

			repository.save(param.getEmplacement());

			// Mise à jour des personnes  
			
			ArrayList<Personne> personnes = new ArrayList<Personne>();
			
			for (int i=0; i < param.getPersonnes().size(); i++) {
			
				// Pour chaque personne, on trouve son id en BDD et on change son emplacement.
				
				personnes.add(repositoryPersonne.findById(param.getPersonnes().get(i).getId()));
				personnes.get(i).setEmplacement(param.getEmplacement());
				
			}
			
			repositoryPersonne.save(personnes);
			
			reponse.setStatut(true);
			reponse.setMessage(EmplacementConstantes.NO_ERROR_CODE);
			
		}
		catch (EmplacementException e1) {
			
			reponse.setStatut(false);
			reponse.setMessage(e1.toString());
				
		}
		catch (DataIntegrityViolationException e) {
			
			reponse.setStatut(false);
		
		}
		catch (NullPointerException e2) {
			reponse.setStatut(false);
			reponse.setMessage(e2.toString());		
		}
		
		return reponse;
	}
	
	
	
	@DeleteMapping(EmplacementConstantes.STRING_VIDE)
 	@ResponseStatus(HttpStatus.OK)
	public DeleteEmplacementReponse deleteEmplacement(@RequestBody DeleteEmplacementParametre param) {
	DeleteEmplacementReponse reponse = new DeleteEmplacementReponse();
		
		try {
			
			DeleteEmplacementValidation.validate(param);

			List<Personne> personnes = repositoryPersonne.findPersonneByEmplacement_id(param.getEmplacement().getId());
			
			for(int i = 0; i < personnes.size(); i++) {
				personnes.get(i).setEmplacement(null);
			}
			
			repositoryPersonne.save(personnes);
			
			//suppression de l'emplacement
			repository.delete(param.getEmplacement());
			
			reponse.setStatut(true);
			reponse.setMessage(EmplacementConstantes.NO_ERROR_CODE);
		
			
		} 
		catch (EmplacementException e) {
			reponse.setStatut(false);
			reponse.setMessage(e.toString());
		}
		
		return reponse;
	}
	
	
	public DeleteEmplacementReponse deleteEmplacement(DeleteEmplacementParametre param, PersonneRepository per, EmplacementRepository emp) {
	DeleteEmplacementReponse reponse = new DeleteEmplacementReponse();
		
		try {
			
			DeleteEmplacementValidation.validate(param);

			List<Personne> personnes = per.findPersonneByEmplacement_id(param.getEmplacement().getId());
			
			for(int i = 0; i < personnes.size(); i++) {
				personnes.get(i).setEmplacement(null);
			}
			
			per.save(personnes);
			
			// Suppression de l'emplacement
			
			emp.delete(param.getEmplacement());
			
			reponse.setStatut(true);
			reponse.setMessage(EmplacementConstantes.NO_ERROR_CODE);
		
			
		} 
		catch (EmplacementException e) {
			reponse.setStatut(false);
			reponse.setMessage(e.toString());
		}
		
		return reponse;
	}
	
	
	@PostMapping(EmplacementConstantes.PATH_SERVICE_ADDEMPLACEMENTPERSONNE)
 	@ResponseStatus(HttpStatus.OK)
	public UpdateEmplacementPersonnesReponse updateEmplacementPersonnes(@RequestBody UpdateEmplacementPersonnesParametre param){
		
		UpdateEmplacementPersonnesReponse reponse = new UpdateEmplacementPersonnesReponse();
		
		try {
			
			UpdateEmplacementPersonneValidation.validate(param);
			
			Emplacement emplacement = repository.findById(param.getEmplacement().getId());
			
			if(emplacement == null) throw new EmplacementException (EmplacementConstantes.ERREUR_AUCUNE_EMPLACEMENT);
			
			ArrayList<Personne> personnes = new ArrayList<Personne>();
			
			for (Personne p : param.getPersonnes()) {
				Personne tampPersonne = repositoryPersonne.findById(p.getId());
				tampPersonne.setEmplacement(emplacement);
				personnes.add(tampPersonne);
				
			}
			
			repositoryPersonne.save(personnes);
		
			reponse.setStatut(true);
			reponse.setMessage(EmplacementConstantes.NO_ERROR_CODE);
		
		} 
		catch (EmplacementException e) {
			reponse.setStatut(false);
			reponse.setMessage(e.toString());
		}
		
		return reponse;
	}
	
	/**
	 * 
	 * @param listEmplacement
	 * @return Transforme des Emplacement en EmplacementDecorateur
	 */
	private List<EmplacementDecorateur> mapperEmplacementDecorateur(List<Emplacement> listEmplacement){
		ArrayList<EmplacementDecorateur> result = new ArrayList<EmplacementDecorateur>();
		
		for (Emplacement emplacement: listEmplacement) {
			result.add(new EmplacementDecorateur(emplacement));
		}
		
		return result;
	}
	
	
	
}
