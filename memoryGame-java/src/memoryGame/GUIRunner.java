package memoryGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.UnaryOperator;

import javax.swing.*;



/**
 * Runner class for the memory game
 * 
 * @author grupp2
 *
 */
public class GUIRunner {
	ArrayList<JButton> myAllButtons;

	GUIGameSettings settings;
	ArrayList<Player> players;
	MemoryBoard mainBoard;
	ArrayList<Brick> clickedButton;
	int currentPlayer;
	int totalPlayers;
	PlayerPanel playerPanel;

	GUIRunner() {
		players = new ArrayList<Player>();
		clickedButton = new ArrayList<Brick>();
		Player player1 = new Player("Erik");
		Player player2 = new Player("Abdi");
		AIGenius genius = new AIGenius("genius", 2);
		players.add(player1);
		players.add(player2);
		players.add(genius);

		settings = new GUIGameSettings();
		settings.setGridRows(4);
		settings.setGridColumns(4);
		settings.setTheme(1);

		settings.setPlayers(players);
		myAllButtons = new ArrayList<JButton>();

		mainBoard = new MemoryBoard(this);
		playerPanel = new PlayerPanel(this);
		totalPlayers = settings.getPlayers().size();
		currentPlayer = 0;
	}

	public static void main(String[] args) {
		GUIRunner runner = new GUIRunner();

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(runner.playerPanel, BorderLayout.SOUTH);
		f.add(runner.mainBoard);
		// f.add( new FlavorsPanel());
		f.setSize(500, 500);
		f.setVisible(true);
		runner.startGame(f);
	}

	private void startGame(JFrame f ) {

		while (mainBoard.hasUnturnedTiles()) {


			
			if (settings.getPlayers().get(currentPlayer) instanceof AIGenius) {
				// JOptionPane.showMessageDialog (f, "Message", "Title", JOptionPane.ERROR_MESSAGE);
				
				moveToNextPlayer();	 
			} else {
				waitBuddy(100);
				getButton(settings.getPlayers().get(currentPlayer).getName())
						.requestFocus();

				if (clickedButton.size() == 2) {

					if (clickedButton.get(0).value
							.equals(clickedButton.get(1).value)) {
						settings.getPlayers().get(currentPlayer)
								.increaseNumOfMatches();
						clickedButton = new ArrayList<Brick>();

						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								playerPanel.lblName.setText(updateScore());
							}
						});

						mainBoard.refreshGrid();

					} else {
						turnBackOpendBriks(clickedButton);
						waitBuddy(500);
						mainBoard.refreshGrid();
						waitBuddy(500);
						moveToNextPlayer();

					}
				}

			}

		}// whilehasUnturnedTiles()) {

	}

	String updateScore() {
		String score = "Score";
		for (Player p : settings.getPlayers()) {

			score = score + " : " + p.getNumOfMatches();
		}
		return score;
	}

	private void turnBackOpendBriks(ArrayList<Brick> clickedButton2) {
		for (Brick b : clickedButton) {
			b.setFaceUp(false);

		}

	}

	private void moveToNextPlayer() {
		currentPlayer++;

		if (currentPlayer == totalPlayers) {
			currentPlayer = 0;
		}
		clickedButton = new ArrayList<Brick>();

	}

	void waitBuddy(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updatePlayer() {

	}

	// getButton(currentPlayer.getName()).getText().
	// MemoryBoard game = new MemoryBoard(runner.settings);
	// game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	// game.setSize(1000,800);

	// game.setVisible(true);
	JButton getButton(String name) {
		for (JButton b : myAllButtons) {
			if (b.getText().equals(name)) {
				return b;
			}

		}
		return null;

	}
}

class PlayerPanel extends JPanel {

	public JLabel lblName;

	public PlayerPanel() {

	}

	public PlayerPanel(GUIRunner runner) {
		// this.setl
		String score = "Score";
		for (Player p : runner.settings.getPlayers()) {
			JButton b1 = new JButton(p.getName());
			runner.myAllButtons.add(b1);
			add(b1);
			score = score + " : " + p.getNumOfMatches();
		}

		lblName = new JLabel(score);
		// lblName.add
		add(lblName);
	}
}
