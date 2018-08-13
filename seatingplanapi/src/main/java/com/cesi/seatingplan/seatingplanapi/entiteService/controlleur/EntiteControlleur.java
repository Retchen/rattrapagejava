package com.cesi.seatingplan.seatingplanapi.entiteService.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Entite;
import com.cesi.seatingplan.seatingplanapi.entiteService.constantes.EntiteConstantes;
import com.cesi.seatingplan.seatingplanapi.entiteService.reponse.EntiteGetAllReponse;
import com.cesi.seatingplan.seatingplanapi.entiteService.repository.EntiteRepository;

@RestController
@RequestMapping(EntiteConstantes.PATH_CONTROLLEUR)
public class EntiteControlleur {

	
	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	private EntiteRepository repository;
	
	/**
	 * Permet de récupérer les entite
	 * @return List<Personne>
	 */
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public EntiteGetAllReponse getAllEntite() {

		EntiteGetAllReponse reponse = new EntiteGetAllReponse();
		List<Entite> entites =  repository.findAll();
		
		reponse.setEntite(entites);
		reponse.setMessage((entites.size()>0) ? EntiteConstantes.NO_ERROR_CODE : EntiteConstantes.ERREUR_AUCUN_ENTITE);
		reponse.setStatut(true);
		
		return reponse;

	}

}
