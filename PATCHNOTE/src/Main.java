import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

/**
 * Purpose: The reponsibility of GameState is ...
 *
 * GameState is-a ...
 * GameState is ...
 */
public class Main extends JFrame
{
	GameState gameState;
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("PATCHNOTE");
		setSize(1280, 960);
		setLocationRelativeTo(null);
		
		gameState = new GameState();
		add(gameState);
		
	}

	public static void main(String[] args)
	{
		new Main();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		gameState.paint(g2d);
		//g2d.fillRect(100, 100, 200, 200);
	}

}
