/**
* Lead Author(s):
* @author mastahype; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-11-03
*/

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Purpose: The reponsibility of Sprite is ...
 *
 * Sprite is-a ...
 * Sprite is ...
 */
public class Sprite extends BufferedImage
{
	//BufferedImage spriteSheet;

	public Sprite() {
		super(35, 40, TYPE_INT_ARGB);
		try
		{
			ImageIO.read(new File("C:/Users/mastahype/git/PATCHNOTE/PATCHNOTE/assets/rbloxtale-rblox.png"));
			getSubimage(0, 0, 35, 40);
			
			//spriteSheet.getScaledInstance(spriteSheet.getWidth(), spriteSheet.getHeight(), 0); spriteSheet.
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFromSheet() {
		
	}
}
