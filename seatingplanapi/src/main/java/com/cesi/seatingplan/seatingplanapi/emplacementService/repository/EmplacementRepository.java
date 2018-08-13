package com.cesi.seatingplan.seatingplanapi.emplacementService.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Emplacement;
import com.cesi.seatingplan.seatingplanapi.emplacementService.reponse.EmplacementDecorateur;

public interface EmplacementRepository extends PagingAndSortingRepository<Emplacement, Integer>{

	public List<Emplacement> findByPlan_id(Integer idPlan);

	public Emplacement findById(Integer id);
	
}
