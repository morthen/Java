package graphicsMenuBoard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import memoryGame.GUISettings;
import memoryGame.Player;

public class GUIMainMenuBoard {

	private boolean startButtonPressed = false;
	private JFrame frame;
	private JPanel playerButtons, gridSizeSelect, themeSelect;
	private JButton[] playerButton, gridButtons, themeButtons;
	private GUIMenuActions menuAction;
	private GUISettings settings;

	public GUIMainMenuBoard(GUISettings settings) {
		this.settings = settings;
		menuAction = new GUIMenuActions();

		// ----------------- GridBagConstraints---------------
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;

		// ------------------- create frame -------------------

		frame = new JFrame(); // creates frame
		frame.setLayout(new GridBagLayout());
		frame.setPreferredSize(new Dimension(500, 500)); // sets size (changes
															// when more
															// players)
		frame.setLocationRelativeTo(null); // puts frame in center of screen

		// ------------------- player buttons -------------------

		playerButtons = new JPanel();

		playerButtons.setLayout(new GridLayout(1, 6)); // 1 row, 6 players
		playerButtons.setPreferredSize(new Dimension(500, 100));
		frame.add(playerButtons, c);

		playerButton = new JButton[6];

		for (int i = 0; i < 6; i++) {

			playerButton[i] = new JButton("OFF");
			playerButton[i].setBackground(Color.RED);
			playerButtons.add(playerButton[i], c);

			this.addPlayerButtonActionListener(playerButton[i], i);

			c.gridx++;
		}
		
		playerButton[0].doClick();
		
		c.gridx = 0;
		c.weighty = 1;
		c.gridy += 2;

		// -------------------- grid size ----------------------------

		gridSizeSelect = new JPanel();
		gridSizeSelect.setLayout(new GridLayout(1, 4));
		gridSizeSelect.setPreferredSize(new Dimension(500, 100));

		gridButtons = new JButton[2];

		JLabel gridLabels[] = new JLabel[2];

		gridLabels[0] = new JLabel();
		gridLabels[0].setText("Select size:"); // text of label
		gridLabels[0].setFont(new Font("Serif", Font.BOLD, 20)); // font of
																	// label
		gridLabels[1] = new JLabel();
		gridLabels[1].setText("          X "); // text of label
		gridLabels[1].setPreferredSize(new Dimension(20, 20));
		gridLabels[1].setFont(new Font("Serif", Font.BOLD, 20)); // font of
																	// label

		for (int i = 0; i < 2; i++) {
			gridButtons[i] = new JButton();
			gridButtons[i].setText("4");
			this.addGridSelectActionListener(gridButtons, i);
		}

		gridSizeSelect.add(gridLabels[0]);
		gridSizeSelect.add(gridButtons[0]);
		gridSizeSelect.add(gridLabels[1]);
		gridSizeSelect.add(gridButtons[1]);

		frame.add(gridSizeSelect, c);

		// -------------- theme select -----------------------------

		c.gridy = 3;

		themeSelect = new JPanel();
		themeSelect.setLayout(new GridLayout(1, 4));
		themeSelect.setPreferredSize(new Dimension(500, 100));

		themeButtons = new JButton[3];

		JLabel themeLabel = new JLabel();
		themeLabel.setText("Select theme:"); // text of label
		themeLabel.setFont(new Font("Serif", Font.BOLD, 20)); // font of label

		for (int i = 0; i < 3; i++) {

			themeButtons[i] = new JButton();
			this.addThemeActionListener(themeButtons, i);

		}

		themeButtons[0].setText("Pokémon");
		themeButtons[1].setText("Symbols");
		themeButtons[2].setText("50 shades");
		
		themeButtons[0].doClick();

		themeSelect.add(themeLabel);

		for (int i = 0; i < 3; i++) {
			themeSelect.add(themeButtons[i]);
		}

		frame.add(themeSelect, c);

		// ---------- start button ---------------------------------

		JButton continueButton = new JButton(); // creates start button

		// ---------add action listener-------------

		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.dispatchEvent(new WindowEvent(frame,
						WindowEvent.WINDOW_CLOSING)); // closes window

				
				// ------- adds settings to GUISettings class -----------------
				settings.setTheme(menuAction.getThemeSelected());
				
				
				
				
				// sets that the button is clicked
				startButtonPressed = true;

			}
		});

		// -----------------------------------------

		continueButton.setText("Continiue to Name Select"); // set text
		c.gridy = 4;
		frame.add(continueButton, c); // add button to frame

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// sets what happens when you close window

		frame.pack(); // sets appropriate size for frame
		frame.setResizable(false); // makes so that you can't change size of
									// frame
		frame.setVisible(true); // makes frame visible

	}
	
	public GUIMenuActions getActions (){
		return menuAction;
	}
	

	public void addPlayerButtonActionListener(JButton button, int playerID) {

		playerButton[playerID].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuAction.playerButtonAction(button, playerID);

			}
		});

	}

	public void addThemeActionListener(JButton[] buttons, int buttonID) {

		themeButtons[buttonID].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuAction.themeButtonAction(buttons, buttonID);

			}
		});

	}

	public void addGridSelectActionListener(JButton[] buttons, int buttonID) {

		gridButtons[buttonID].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuAction.gridButtonAction(buttons, buttonID);

			}
		});

	}

	public boolean buttonPressed() {
		return startButtonPressed;
	}

}
