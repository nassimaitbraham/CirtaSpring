package com.aitech.service;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.googlecode.ehcache.annotations.Cacheable;

/**
 * Implementation du service Metier (Test)
 * 
 * @author Nassim AIT BRAHAM
 *
 */

@Service
public class MetierImpl implements Metier {
	static final Logger logger = Logger.getLogger(MetierImpl.class);
	int res = 20;
	

	/**
	 * Implementationd de la methode de test jeTravail
	 * @return int
	 */

	public int jeTravaille() {

		logger.info("debut traitement metiers");
		try {
			// traitements métiers
			logger.info("traitement metiers en cours");
			res++;
			Thread.sleep(3500);

		
			//Users user = userDao.findByUserName("nasnet");
		} catch (InterruptedException e) {
			logger.error("Erreur lors du traitement métier");
			return 0;
		}

		logger.info("Fin traitement metiers");
		return 10;
	}
	
	/**
	 * Implementationd e la methode pour tester si apres un deuxiemme appel a cette methode avec les memes paramettre les donnees seront recherchees dans le cache
	 * @param value
	 * @return
	 */

	@Cacheable(cacheName = "messageCache")
	public String testCache(String value){
		System.out.println("testCache()");
		return value;
	}
	

}
