package com.aitech.dao;

import java.util.List;
import com.aitech.domain.Person;

/**
 * Interface de la couche DAO Person
 * 
 * @author nassim AIT BRAHAM
 *
 */
public interface PersonDao {
	
	/**
	 *  Methode pour reccuperer toute les personnes
	 * @return List de personnes
	 */
	
	List<Person> getAll();
	
	/**
	 * Methode pour reccuperer une seule personne en fonction de son identifiant
	 * @param  identifiant d'une personne
	 * @return une personne
	 */
	
	Person getPerson(Integer id);
}
