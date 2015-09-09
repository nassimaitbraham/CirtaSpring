package com.aitech.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 *  Exemple d'un profiler AOP
 * @author nassim AIT BRAHAM
 *
 */
@Aspect
@Component
public class MetierProfiler {
	static final Logger logger = Logger.getLogger(MetierProfiler.class);

	@Pointcut("execution(* com.aitech.service.*.*(..))")
	public void fonctionMetier() {
	}

	@Around("fonctionMetier()")
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
		long debut = System.currentTimeMillis();

		
		logger.info("Apelle de la fonction ...");
		Object sortie = joinPoint.proceed();

		logger.info("Fonction executee avec succees ...");
		long tempsPasse = System.currentTimeMillis() - debut;

		logger.info("Temps d'execution de la fonction: " + tempsPasse
				+ " milliseconds.");
		
		System.out.println("Temps d'execution de la fonction: " + tempsPasse + " milliseconds.");

		return sortie;
	}

}