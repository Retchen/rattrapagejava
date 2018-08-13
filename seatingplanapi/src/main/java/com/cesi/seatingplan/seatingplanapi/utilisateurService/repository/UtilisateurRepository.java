package com.cesi.seatingplan.seatingplanapi.utilisateurService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Utilisateur;

public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Integer>{

	public List<Utilisateur> findAll();
	
	public Utilisateur findByIdentifiantAndMdp(String identifiant, String mdp);
	
	
}
