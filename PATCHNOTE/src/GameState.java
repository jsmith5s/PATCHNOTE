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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Purpose: The reponsibility of GameState is ...
 *
 * GameState is-a ...
 * GameState is ...
 */
public class GameState extends JPanel implements ActionListener, KeyListener
{
	
	private Boolean running = true;
	BufferedImage spriteSheet;
	Graphics2D g2d;;

	public GameState() {
		run();
		Timer t = new Timer(16, this);
		t.start();
		setDoubleBuffered(true);
		setBackground(Color.red);
		System.out.println("success");
		
		try
		{
			spriteSheet = ImageIO.read(new File("C:/Users/mastahype/git/PATCHNOTE/PATCHNOTE/assets/rbloxtale-rblox.png"));
			spriteSheet = spriteSheet.getSubimage(0, 0, 35, 40);
			
			//spriteSheet.getScaledInstance(spriteSheet.getWidth(), spriteSheet.getHeight(), 0); spriteSheet.
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		//repaint();
	}
	
	public void run()
	{
		long lastTime = System.nanoTime();
		double delta = 0.0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if (delta >= 1.0) {
				update();
				updates++;
				delta--;
			}
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " UPS, " + frames + " FPS");
				updates = frames = 0;
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(spriteSheet, 600, 300, 35*3, 40*3, null);
		//g2d.fillRect(100, 100, 200, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
