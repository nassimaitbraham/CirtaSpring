package com.aitech.service;


/**
 * Interface du service Metier (Test)
 * 
 * @author Nassim AIT BRAHAM
 *
 */

public interface Metier {
	
	/**
	 * Methode de test jeTravail
	 * @return int
	 */
	
	int jeTravaille();
	
	/**
	 * Methode pour tester si apres un deuxiemme appel a cette methode avec les memes paramettre les donnees seront recherchees dans le cache
	 * @param value
	 * @return
	 */
	
	String testCache(String value);

}
