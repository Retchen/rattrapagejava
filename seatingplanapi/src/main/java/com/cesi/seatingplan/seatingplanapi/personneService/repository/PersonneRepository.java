package com.cesi.seatingplan.seatingplanapi.personneService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.cesi.seatingplan.seatingplanapi.commun.entity.Personne;

public interface PersonneRepository extends PagingAndSortingRepository<Personne, Integer>{

	//FIXME FSU : Ajouter le WHERE IN DATE 
	//public Integer countByEmplacement_id(Integer idEmplacement);
	
	/**
	 * Retourne le nombre de personne qui occupe actuelement cette emplacement
	 * @param idEmplacement
	 * @return Int
	 */
	@Query("SELECT count(pe.id) FROM personne pe WHERE pe.emplacement.id = ? AND NOW() BETWEEN pe.dateArrivee AND pe.dateSortie")
    public Integer countUtilisateurByEmplacement(Integer idEmplacement);
	
	/**
	 * Retourne la liste des personne sans emplacement  
	 * @return List<Personne>
	 */
	@Query("SELECT new com.cesi.seatingplan.seatingplanapi.commun.entity.Personne(pe.id, pe.nom, pe.prenom, pe.email, pe.telephone, pe.dateArrivee, pe.dateSortie, pe.posteInterne)"
			+ " FROM personne pe WHERE pe.emplacement.id IS NULL")
    public List<Personne> findPersonneSansEmplacement();
	
	/**
	 * Retourne le detail d'une personne par rapport à un emplacement
	 * @param idEmplacement
	 * @return Personne 
	 */
	@Query("SELECT new com.cesi.seatingplan.seatingplanapi.commun.entity.Personne(pe.id, pe.nom, pe.prenom, pe.email, pe.telephone, pe.dateArrivee, pe.dateSortie, pe.posteInterne) FROM personne pe WHERE pe.emplacement.id = ? AND (pe.dateSortie > NOW() OR pe.dateSortie IS NULL)")
    public List<Personne> findPersonneByIdEmplacement(Integer idEmplacement);
	
	public List<Personne> findPersonneByEmplacement_id(Integer idEmplacement);
	
	public Personne findById(Integer id);
	
	//@Query("UPDATE personne pe SET pe.emplacement.id = ? WHERE pe.id = ?")
	//public void saveNewEmplacement(Integer idEmplacement, Integer idPersonne );
	
}
