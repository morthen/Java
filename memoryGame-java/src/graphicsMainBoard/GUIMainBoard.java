package graphicsMainBoard;

import javax.swing.ImageIcon;
import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import javax.swing.JLabel;
import javax.swing.JPanel;

import memoryGame.GUIGameSettings;
import memoryGame.GUISettings;
import memoryGame.Grid;
import memoryGame.Brick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout; //imports GridLayout library
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import memoryGame.Player;

public class GUIMainBoard {

	private JFrame frame; // = new JFrame(); // creates frame
	private JButton[][] buttonGrid; // names the grid of buttons
	private GridButtonAction gridButtonAction;
	List<Player> playerList;

	/**
	 * 
	 * @param height
	 *            number of tiles
	 * @param width
	 *            number of tiles
	 * @param gridButtonAction
	 *            class that handles the value of the button pressed
	 * @param grid
	 * @param players
	 */
	public GUIMainBoard(int height, int width, Grid grid, int players,
			List<Player> playerList) { // constructor

		gridButtonAction = new GridButtonAction();
		this.playerList = playerList;

		// ----------------- GridBagConstraints---------------
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;

		frame = new JFrame(); // creates frame

		frame.setLayout(new GridBagLayout()); // set layout, GridBagLayout
		frame.setPreferredSize(new Dimension(1000, 1000)); // dimensions of
															// window

		// ------------------------------------------------

		int tilesGridHeight = 950; // height and width of grid board
		int tilesGridWidth = 950;

		// ------------ makes the board square -----------

		if (height > width) {
			tilesGridWidth = (tilesGridHeight / height) * width;
		}

		else if (height < width) {
			tilesGridHeight = (tilesGridWidth / width) * height;
		}
		
	

		// ------------------------------------------------

		JPanel tilesGrid = new JPanel(new GridLayout(height, width)); // creates
																		// panel
																		// to
																		// hold
																		// Grid

		tilesGrid.setPreferredSize(new Dimension(tilesGridWidth,
				tilesGridHeight)); // sets size of tilesGrid

		frame.add(tilesGrid); // adds grid layout to frame

		// --------- add buttons to tilesGrid -------------------------

		buttonGrid = new JButton[height][width]; // allocate the size of grid
		for (int y = 0; y < width; y++) { // outer loop start
			for (int x = 0; x < height; x++) { // innter loop start
				buttonGrid[x][y] = new JButton("(" + x + "," + y + ")"); // creates
																			// new
																			// button
				tilesGrid.add(buttonGrid[x][y]); // adds button to grid
				this.addActionListener(x, y, grid.getBrick(x, y)); // adds
																	// action
																	// listener

			} // inner loop end

		} // outer loop end

		// ------- create Players layout ---------------------------------

		JPanel playerBanner = new JPanel(new GridLayout(1, players)); // second
																		// digit
																		// should
																		// be
																		// number
																		// of
																		// players

		c.ipady = 0; // reset to default
		c.gridy = 1; // third row

		frame.add(playerBanner, c); // adds banner to frame

		JLabel[][] playerIcons = new JLabel[1][players]; // creates buttons
		for (int i = 0; i < players; i++) { // loop start
			playerIcons[0][i] = new JLabel(playerList.get(i).getName()
					+ ": POINTS"); // text of label
			playerIcons[0][i].setFont(new Font("Serif", Font.BOLD, 15)); // font
																			// of
																			// label
			playerBanner.add(playerIcons[0][i]); // adds label to playerBanner

		} // loop end

		// ---------------------------------------------------------------

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// sets what happens when you close window

		frame.pack(); // sets appropriate size for frame
		frame.setResizable(false); // makes so that you can't change size of
									// frame
		frame.setVisible(true); // makes frame visible
	}

	// adds image
	public void addBackImages(GUISettings settings) {
		
		for (int x = 0; x < settings.getGridRows(); x++) {
			for (int y = 0; y < settings.getGridColumns(); y++) {
				this.addImageCorrectSize("images\\1\\back.png", x, y);
			}
		}

	}

	public void turnTileFaceUp(Grid grid, int[] coordinates) {
		
		System.out.println(grid.getBrick(coordinates[0], coordinates[1]).getValue());
		
		grid.getBrick(coordinates[0], coordinates[1]).setFaceUp(true);
		this.addImageCorrectSize("images\\1\\"+
				grid.getBrick(coordinates[0], coordinates[1]).getValue()
				+".png"
				
				
				, coordinates[0], coordinates[1]);

	}

	public void turnTileFaceDown(Grid grid, int[] coordinates) {

		//TODO: change filepath to match theme, change to settings
		this.addImageCorrectSize("images\\1\\back.png", coordinates[0],
				coordinates[1]);
		grid.getBrick(coordinates[0], coordinates[1]).setFaceUp(false);

	}

	// adds image with correct size
	public void addImageCorrectSize(String imageLocation, int gridWidth,
			int gridHeight) {
		// Adds image to grid
		buttonGrid[gridWidth][gridHeight].setIcon(new ImageIcon(
				((new ImageIcon(imageLocation).getImage().getScaledInstance(
						buttonGrid[gridWidth][gridHeight].getWidth(),
						buttonGrid[gridWidth][gridHeight].getHeight(),
						java.awt.Image.SCALE_SMOOTH)))));
	}

	public void addActionListener(int x, int y, Brick brick) {

		buttonGrid[x][y].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gridButtonAction.preformAction(x, y, brick);

			}
		});

	}

	public GridButtonAction getGridButtonAction() {
		return gridButtonAction;
	}

	/**
	 * 
	 * @param playerNumber
	 * @return color to add to player icon of the player
	 */

}