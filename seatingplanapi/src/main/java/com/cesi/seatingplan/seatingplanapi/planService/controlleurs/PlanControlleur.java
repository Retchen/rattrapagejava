package com.cesi.seatingplan.seatingplanapi.planService.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Emplacement;
import com.cesi.seatingplan.seatingplanapi.commun.entity.Plan;
import com.cesi.seatingplan.seatingplanapi.commun.helper.LoggerHelper;
import com.cesi.seatingplan.seatingplanapi.emplacementService.constantes.EmplacementConstantes;
import com.cesi.seatingplan.seatingplanapi.emplacementService.controlleurs.EmplacementControlleur;
import com.cesi.seatingplan.seatingplanapi.emplacementService.parametre.DeleteEmplacementParametre;
import com.cesi.seatingplan.seatingplanapi.emplacementService.repository.EmplacementRepository;
import com.cesi.seatingplan.seatingplanapi.personneService.constantes.PersonneConstantes;
import com.cesi.seatingplan.seatingplanapi.personneService.repository.PersonneRepository;
import com.cesi.seatingplan.seatingplanapi.planService.constantes.PlanServiceConstantes;
import com.cesi.seatingplan.seatingplanapi.planService.exception.PlanException;
import com.cesi.seatingplan.seatingplanapi.planService.paramatre.DeletePlanParametre;
import com.cesi.seatingplan.seatingplanapi.planService.parametre.SaveOrUpdatePlanParametre;
import com.cesi.seatingplan.seatingplanapi.planService.reponse.DeletePlanReponse;
import com.cesi.seatingplan.seatingplanapi.planService.reponse.PlanReponse;
import com.cesi.seatingplan.seatingplanapi.planService.reponse.SaveOrUpdatePlanReponse;
import com.cesi.seatingplan.seatingplanapi.planService.repository.PlanRepository;
import com.cesi.seatingplan.seatingplanapi.planService.validation.SaveOrUpdatePlanValidation;

@RestController
@RequestMapping(PlanServiceConstantes.PATH_CONTROLLEUR)
public class PlanControlleur {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private PlanRepository repository;
	
	@Autowired
	private EmplacementRepository repositoryEmplacement;
	
	@Autowired
	private PersonneRepository repositoryPersonne;
	
	
	@GetMapping(PlanServiceConstantes.PATH_SERVICE_GETONE)
	@ResponseStatus(HttpStatus.OK)
	public PlanReponse getOnePlan(){
		
		PlanReponse reponse = new PlanReponse();
		
		List<Plan> result =  repository.findAll();
		reponse.setStatut(true);
		
		reponse.setMessage((result.size() > 0) ? PlanServiceConstantes.NO_ERROR_CODE : PlanServiceConstantes.ERREUR_AUCUN_PLAN);
		reponse.setPlan(result);
		
		LoggerHelper.loggerParamSortie(PlanServiceConstantes.PATH_SERVICE_GETALL, reponse.toString());
		
		return reponse;
	
	}

	
	@PostMapping(PersonneConstantes.STRING_VIDE)
 	@ResponseStatus(HttpStatus.OK)
	public SaveOrUpdatePlanReponse saveOrUpdatePlan(@RequestBody SaveOrUpdatePlanParametre param) {

		SaveOrUpdatePlanReponse reponse = new SaveOrUpdatePlanReponse();
		
		try {
			
			
			SaveOrUpdatePlanValidation.validate(param);
			
			Plan plan = new Plan();
			
			if(param.getPlan().getId() != null) {
				plan = repository.findOne(param.getPlan().getId());
				
				plan.setNom(param.getPlan().getNom());
			} else {
				plan = param.getPlan();
			}
			
			
			repository.save(plan);
			
			reponse.setMessage(PersonneConstantes.NO_ERROR_CODE);
			reponse.setStatut(true);
		}
		catch (PlanException e) {
			reponse.setMessage(e.toString());
			reponse.setStatut(false);
			
			
		}
		
		return reponse; 
	}
	
	
	@DeleteMapping(PersonneConstantes.STRING_VIDE)
 	@ResponseStatus(HttpStatus.OK)
	public DeletePlanReponse deleteEmplacement(@RequestBody DeletePlanParametre param) {
		
		DeletePlanReponse reponse = new DeletePlanReponse();
		
		//try {
			
			//DeletePlanValidation.validate(param);
			
			// on enlève l'id materiel au personne concerné 
			List<Emplacement> emplacement = repositoryEmplacement.findByPlan_id(param.getPlan().getId());
			
			EmplacementControlleur emplacementControlleur = new EmplacementControlleur();
			
			for(int i = 0; i < emplacement.size(); i++) {
				
				DeleteEmplacementParametre deleteEmplacementParametre = new DeleteEmplacementParametre();
				deleteEmplacementParametre.setEmplacement(emplacement.get(i));
				
				emplacementControlleur.deleteEmplacement(deleteEmplacementParametre, repositoryPersonne, repositoryEmplacement);
			}
			
			Plan plan = repository.findOne(param.getPlan().getId());
			
			repository.delete(plan);
			
			reponse.setStatut(true);
			reponse.setMessage(EmplacementConstantes.NO_ERROR_CODE);
		
			
//		} 
//		catch (EmplacementException e) {
//			reponse.setStatut(false);
//			reponse.setMessage(e.toString());
//		}
//		
		return reponse;
	}
	
}
