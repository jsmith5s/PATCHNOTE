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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Purpose: The reponsibility of GameState is ...
 *
 * GameState is-a ...
 * GameState is ...
 */
public class GameState extends JPanel
{
	
	BufferedImage spriteSheet;
	int temp;

	public GameState() {
		setDoubleBuffered(true);
		setBackground(Color.red);
		
		try
		{
			spriteSheet = ImageIO.read(new File("C:/Users/mastahype/git/PATCHNOTE/PATCHNOTE/assets/rbloxtale-rblox.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(spriteSheet, 100, 100, null);
		System.out.println(temp++);
		//g2d.fillRect(100, 100, 200, 200);
	}
	
}
