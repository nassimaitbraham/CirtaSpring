package com.aitech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aitech.dao.PersonDao;
import com.aitech.domain.Person;


/**
 * Implementation du service de recherche des personnes
 * 
 * @author Nassim AIT BRAHAM
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	/**
	 * Implementation de la methode du service qui permet de reccuperer tout les users
	 * 
	 * @return Liste des users
	 */

	public List<Person> getAll() {

		System.out.println("La methode getAll() du service PersonService est appelee");

		List<Person> list = personDao.getAll();

		return list;
	}


	/**
	 * Implementation de la methode du service qui permet de reccuperer une personne en fonction de son identifiant
	 * @param id
	 * @return une personne
	 */
	public Person getPerson(Integer id) {
		
		Person person = (Person) personDao.getPerson(id);
		return person;
	}
}
