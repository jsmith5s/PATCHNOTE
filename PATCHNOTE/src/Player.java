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
* Version: 2025-12-16
*/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Purpose: The reponsibility of Player is ...
 *
 * Player is-a ...
 * Player is ...
 */
public class Player extends Sprite implements KeyListener
{
	private String direction = "";
	private Boolean walkUp = false, walkLeft = false, walkDown = false, walkRight = false;
	private Set<Integer> pressedKeys = new HashSet<Integer>();
	private int walkSpeed = 6;

	/**
	 * Purpose: 
	 * @param x
	 * @param y
	 */
	public Player(int x, int y)
	{
		super(x, y);
		
		loadFromSheet("assets/rbloxtale-rblox");
		addAnimAtlas("walkF");
		addAnimAtlas("walkH");
		addAnimAtlas("walkB");
		
		setFrame("walkF 0");
	}
	
	@Override
	public void update(int UPS) {
		super.update(UPS);
		
		if (walkUp)
			y -= walkSpeed;
		if (walkLeft)
			x -= walkSpeed;
		if (walkDown)
			y += walkSpeed;
		if (walkRight)
			x += walkSpeed;
		
		//System.out.println(pressedKeys);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!pressedKeys.contains(e.getKeyCode())) {
			pressedKeys.add(e.getKeyCode());
			//put code here to run it once on a specific key press
			
			if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
				direction = "up";
				playAnim("walkB", 4);
			}
			if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
				direction = "left";
				playAnim("walkH", 4);
				flip();
			}
			if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
				direction = "down";
				playAnim("walkF", 4);
				//setFrame("walkF 0");
			}
			if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				direction = "right";
				playAnim("walkH", 4);
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
			walkUp = true;
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
			walkLeft = true;
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
			walkDown = true;
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
			walkRight = true;
		
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			walkSpeed = 8;
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		pressedKeys.remove(e.getKeyCode());
		
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			walkUp = false;
			setFrame("walkB 2");
		}
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			walkLeft = false;
			setFrame("walkH 0");
			flip();
		}
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			walkDown = false;
			setFrame("walkF 0");
		}
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			walkRight = false;
			setFrame("walkH 0");
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			walkSpeed = 6;
		
	}

}
