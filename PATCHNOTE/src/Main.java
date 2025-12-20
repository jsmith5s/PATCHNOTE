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
	public static final int gameWidth = 1280;
	public static final int gameHeight = 960;
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PATCHNOTE");
		setSize(gameWidth, gameHeight);
		setLocationRelativeTo(null);
		
		gameState = new GameState();
		gameState.startGameThread();
		addKeyListener(GameState.rblox);
		add(gameState);
		
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Main();
	}

}
