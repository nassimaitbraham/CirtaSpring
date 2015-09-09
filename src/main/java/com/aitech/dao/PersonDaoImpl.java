package com.aitech.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.aitech.domain.Person;

/**
 * Implementation de l'interface de la couche DAO Person
 * 
 * @author nassim AIT BRAHAM
 *
 */

@Repository 
public class PersonDaoImpl implements PersonDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 *  Implementation de la methode pour reccuperer toute les personnes
	 * @return List de personnes
	 */
	
	public List<Person> getAll() {
		
		
		// Reccuperation de la session courante de Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Creation de la requette Hibernate (HQL)
		Query query = session.createQuery("FROM  Person");
		
		
		return  query.list();
	}
	
	/**
	 * Implementation de la methode pour reccuperer une seule personne en fonction de son identifiant
	 * @param  identifiant d'une personne
	 * @return une personne
	 */

	@Override
	public Person getPerson(Integer id) {
	
		Session session = sessionFactory.getCurrentSession();
		return (Person) session.get(Person.class, id);
	}
	
	
}
