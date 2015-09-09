package com.aitech.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aitech.domain.Person;
import com.aitech.pojo.PersonPojo;
import com.aitech.service.PersonService;
import com.aitech.util.Util;

/**
 * Controller qui permet de fournir des web service de type RESTfull
 * 
 * @author Nassim AIT BRAHAM
 *
 */

@Controller
@RequestMapping("/Provider")
public class RestProviderController {

	
	@Autowired
	private PersonService personService;
	@Autowired
	private Util util;

	/**
	 * Reccupertion des donnees voulu sous un format xml ou json
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody PersonPojo getPerson(@PathVariable("id") Integer id) {

		Person person = personService.getPerson(id);

		PersonPojo personPojo = new PersonPojo();
		personPojo.setFirstName(person.getFirstName());
		personPojo.setLastName(person.getLastName());
		personPojo.setMoney(person.getMoney());
		personPojo.setPhoto(util.getPhoto(id));

		return personPojo;

	}

	/**
	 * Cette methode reccupere directement une photo
	 * 
	 * @param id
	 * @return byte
	 */

	@RequestMapping(value = "/photo/{id}", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
	public @ResponseBody byte[] getPhoto(@PathVariable("id") Long id) {

		try {
			// reccuperation de l'image dans le classpath
			InputStream is = this.getClass().getResourceAsStream("/voiture.jpg");

			// Preparation du buffered image
			BufferedImage img = ImageIO.read(is);

			// Creation du byte array output stream
			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			// ecriture dans le output stream
			ImageIO.write(img, "jpg", bao);

			return bao.toByteArray();

		} catch (IOException e) {

			throw new RuntimeException(e);
		}
	}

}
