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

import java.awt.Rectangle;
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
public class Sprite
{
	private BufferedImage image;
	private int x, y, width, height;
	private Rectangle collider;
	

	public Sprite(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void loadFromSheet(String path) {
		try
		{
			image = ImageIO.read(new File(path));
			image = image.getSubimage(0, 0, 35, 40);
			
			width = 35;
			height = 40;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFromImage(String path) {
		try
		{
			image = ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addAnimAtlas(String animName) {
		
	}
	
	public void addAnimIndices(String animName, String[] indices) {
		
	}
	
	public void playAnim(String animName) {
		
	}
	
	public void update() {
		
	}
	
	public BufferedImage getBufferedImage() {
		return image;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
