package com.aitech.service;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.aitech.domain.Person;

/**
 * Interface du service de recherche des personnes
 * 
 * @author Nassim AIT BRAHAM
 *
 */

public interface PersonService {

	/**
	 * Methode du service qui permet de reccuperer tout les users
	 * 
	 * @return Liste des users
	 */
	//L'ajout de l'annotation ci-dessous a cette methode restrint son appel si le user n'a pas les roles suffisant
	@PreAuthorize("hasRole('ROLE_USER')")
	List<Person> getAll();
	
	/**
	 * Methode du service qui permet de reccuperer une personne en fonction de son identifiant
	 * @param id
	 * @return une personne
	 */
	
	Person getPerson(Integer id);
}
