package com.aitech.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.aitech.domain.CustomUser;
import com.aitech.domain.Person;
import com.aitech.service.Metier;
import com.aitech.service.PersonService;
import com.aitech.util.CustomUserDetailsContextMapper;

/**
 * Controller principale de l'application
 * 
 * @author nassim AIT BRAHAM
 *
 */
@Controller
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private PersonService personService;

	@Autowired
	private Metier metier;

	@Autowired
	private CustomUserDetailsContextMapper customUserDetailsContextMapper;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Map<String, Object> map) {
		return new ModelAndView("login", "", "");
	};

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "login";

	}

	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String getPersons(Model model) {

		// Reccuperation du user connecter
		Authentication authentification = SecurityContextHolder.getContext().getAuthentication();

		logger.info("Nom du user : " + authentification.getName());

		// Reccuperation des informations detaillee du user connecte a partir
		// des info du ldap
		CustomUser customUser = customUserDetailsContextMapper.getUserDetails();
		logger.info("Email du user  : " + customUser.getEmail());

		// Reccuperation de la list des roles du user renseignes dans le ldap

		Collection<GrantedAuthority> authorities = customUser.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {

			logger.info("Le user a mes roles suivant  : " + grantedAuthority.getAuthority());

		}

		// Retrieve all persons by delegating the call to PersonService
		List<Person> persons = personService.getAll();

		// Test aop
		metier.jeTravaille();

		// Test cache
		metier.testCache("Test cache");

		// Test de reccuperation d'une personne avec son id

		Person person = personService.getPerson(1);

		System.out.println(person.getFirstName());

		// Attach persons to the Model
		model.addAttribute("persons", persons);

		// This will resolve to /WEB-INF/jsp/pet-tiles.jsp
		return "acceuil-tiles";
	}

}
