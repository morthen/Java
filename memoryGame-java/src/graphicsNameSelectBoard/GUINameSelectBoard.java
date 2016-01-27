package graphicsNameSelectBoard;

import graphicsMainBoard.GUIMainBoard;
import graphicsMainBoard.GridButtonAction;
import graphicsMenuBoard.GUIMenuActions;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import memoryGame.Brick;
import memoryGame.GUIGameSettings;
import memoryGame.GUISettings;
import memoryGame.Grid;
import memoryGame.Player;

public class GUINameSelectBoard {

	private JFrame frame;
	private ArrayList<Player> playerList;
	private GUISettings settings;
	private boolean startButtonClicked = false;

	public GUINameSelectBoard(GUISettings settings2) {
		
		this.settings = settings2;
		ArrayList<Player> playerList = new ArrayList();

		// ----------------- GridBagConstraints---------------
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.1;

		// ------------------- create frame -------------------
		
		frame = new JFrame(); // creates frame
		frame.setLayout(new GridBagLayout());
		frame.setPreferredSize(new Dimension(300, 200 + settings2.getNumberOfPlayers() * 20)); // sets size (changes when more players)
		frame.setLocationRelativeTo(null); // puts frame in center of screen

		// ---------- create labels and field -------------------
		
		JLabel[] playerText = new JLabel[settings2.getNumberOfPlayers()];
		JTextField[] playerName = new JTextField[settings2.getNumberOfPlayers()];
		
		for (int i = 0; i < settings2.getNumberOfPlayers(); i++){ // loop start
			c.gridx = 0; // sets gridx to 0
			c.anchor = GridBagConstraints.CENTER; // centers field
			c.weightx = 0.1; // adds a litte space between parts on x axis
			
		// ---------- add player text ------------------------
			
			playerText[i] = new JLabel("Player "+ (i+1) + " name: "); // text of label
			playerText[i].setFont(new Font("Serif", Font.BOLD, 20)); // font of label
			frame.add(playerText[i], c); // adds text with font to label
			c.gridx++; // adds 1 to x on gridlayout
			
			// add input field
			c.weightx = 1; // adds weight to x
			playerName[i] = new JTextField(); // creates textfield
			frame.add(playerName[i], c); // adds field to the right of label
			
			c.gridy++; // adds to y axis of grid layout. "next row"
		} // loop end
		
		
		// ---------- start button ---------------------------------
		
		JButton startButton = new JButton(); // creates start button
		
		// ---------add action listener-------------
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				for (int i = 0; i < settings2.getNumberOfPlayers(); i++){ // loop start
					playerList.add(new Player(playerName[i].getText()));
				} // loop end
				
				
				//adds playernames to settings
				settings2.setPlayers(playerList);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); // closes window
				graphicsMainBoard.GUIMainLayoutTest.createGrid(playerList);
				
				
				// ----------------- button clicked -----------------------
				
				startButtonClicked = true;
					
			}
		});
		
		
		//-----------------------------------------
		
		
		startButton.setText("Start Game"); // set text
		frame.add(startButton, c); // add button to frame
	
		
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// sets what happens when you close window

		frame.pack(); // sets appropriate size for frame
		frame.setResizable(false); // makes so that you can't change size of
									// frame
		frame.setVisible(true); // makes frame visible

	}
	
	public boolean buttonPressed(){
		return startButtonClicked;
	}
	
	

}
