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
* https://youtu.be/VpH33Uw-_0E?si=SbVotLRtpfPfBtjA		- aided in update function
*
* Version: 2025-11-03
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Purpose: The reponsibility of GameState is ...
 *
 * GameState is-a ...
 * GameState is ...
 */
public class GameState extends JPanel implements KeyListener, Runnable
{
	
	private Thread gameThread;
	private ArrayList<Sprite> gameSprites = new ArrayList<Sprite>();
	private final int universalScale = 4;
	private int updatesPerSecond = 0;
	public static Player rblox;
	

	public GameState() {
		run();
		setDoubleBuffered(true);
		setBackground(Color.white);
		
		rblox = new Player(550, 300);
		addKeyListener(rblox);
		add(rblox);
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		updatesPerSecond++;
		if (updatesPerSecond == 61)
			updatesPerSecond = 0;
		//System.out.println(updatesPerSecond);
		
		for (Sprite sprite : gameSprites) {
			sprite.update(updatesPerSecond);
		}
		
	}
	
	/*
	 * Handles the game to run at 60 FPS
	 */
	public void run()
	{
		double drawInterval = 1000000000 / 60.0;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null) {
			update();
			repaint();
			
			try
			{
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void add(Sprite sprite) {
		gameSprites.add(sprite);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		//g2d.drawImage(spriteSheet, Main.gameWidth/2-spriteSheet.getTileWidth(), Main.gameHeight/2-spriteSheet.getTileHeight(), 35*3, 40*3, null);
		for (Sprite sprite : gameSprites) {
			g2d.drawImage(sprite.getBufferedImage(), sprite.getX(), sprite.getY(), 
					sprite.getWidth()*universalScale, sprite.getHeight()*universalScale, null);
		}
		//g2d.fillRect(100, 100, 200, 200);
		g2d.dispose();
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
		System.out.println("game");
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
