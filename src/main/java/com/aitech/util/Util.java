package com.aitech.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Component;

/**
 * Class util
 * 
 * @author AIT BRAHAM
 *
 */
@Component
public class Util {
	
	
	/**
	 * 
	 * Methode qui permet de reccuperer une photo sous forme d'un byte dans le class path
	 */

	public byte[] getPhoto(Integer id) {
		
		try {
			// recherche de l'image dans le class path
			InputStream is = this.getClass().getResourceAsStream("/bella.jpg");

			// Prepare buffered image
			BufferedImage img = ImageIO.read(is);

			// Create a byte array output stream
			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			// Write to output stream
			ImageIO.write(img, "jpg", bao);

			return bao.toByteArray();

		} catch (IOException e) {

			throw new RuntimeException(e);
		}

	}

}
