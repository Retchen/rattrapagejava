package com.cesi.seatingplan.seatingplanapi.planService.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Plan;

public interface PlanRepository extends PagingAndSortingRepository<Plan, Integer>{

	public List<Plan> findAll();
	
}
