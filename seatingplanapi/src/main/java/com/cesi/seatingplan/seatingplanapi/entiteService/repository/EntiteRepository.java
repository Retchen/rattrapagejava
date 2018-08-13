package com.cesi.seatingplan.seatingplanapi.entiteService.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Entite;

public interface EntiteRepository extends PagingAndSortingRepository<Entite, Integer>{

	/**
	 * Retourne toute la liste des entité 
	 * @return List<Entite>
	 */
	public List<Entite> findAll();
	
}
