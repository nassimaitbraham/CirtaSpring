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

	/**
	 * Retrieves the add page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		logger.debug("Received request to show add page");

		// Create new Person and add to model
		// This is the formBackingOBject
		model.addAttribute("personAttribute", new Person());

		// This will resolve to /WEB-INF/jsp/addpage.jsp
		return "addpage";
	}

	/**
	 * Adds a new person by delegating the processing to PersonService. Displays
	 * a confirmation JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("personAttribute") Person person) {
		logger.debug("Received request to add new person");

		// The "personAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// Call PersonService to do the actual adding
		// personService.add(person);

		// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "addedpage";
	}

	/**
	 * Deletes an existing person by delegating the processing to PersonService.
	 * Displays a confirmation JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {

		logger.debug("Received request to delete existing person");

		// Call PersonService to do the actual deleting
		// personService.delete(id);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "deletedpage";
	}

	/**
	 * Retrieves the edit page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
	public String getEdit(@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to show edit page");

		// Retrieve existing Person and add to model
		// This is the formBackingOBject
		// model.addAttribute("personAttribute", personService.get(id));

		// This will resolve to /WEB-INF/jsp/editpage.jsp
		return "editpage";
	}

	/**
	 * Edits an existing person by delegating the processing to PersonService.
	 * Displays a confirmation JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("personAttribute") Person person,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to update person");

		// The "personAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the
		// ModelAttribute
		person.setId(id);

		// Delegate to PersonService for editing
		// personService.edit(person);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}

}
