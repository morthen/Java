package GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;


import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class GUISettingsBoard extends JFrame {

	ArrayList<String> playerButtonText;
	int[] playerButtonTextID;
	MenuActions action;
	GUIGameSettings settings;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGameSettings settings1 = new GUIGameSettings();
					GUISettingsBoard frame = new GUISettingsBoard(settings1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUISettingsBoard(GUIGameSettings settings) {

		// ---------------- values to be stored by object
		// -------------------------
		this.settings = settings;
		playerButtonText = new ArrayList<String>();
		playerButtonText.add("Human");
		playerButtonText.add("AI Easy");
		playerButtonText.add("AI Medium");
		playerButtonText.add("AI Hard");
		playerButtonText.add("OFF");
		playerButtonTextID = new int[6];
		action = new MenuActions();

		// ------------------------------------------------------------------------

		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 68 };
		gbl_contentPane.rowHeights = new int[] { 51, 43, 31, 51, 45, 43, 6 };
		gbl_contentPane.columnWeights = new double[] { 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0,
				1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel playerButtons = new JPanel();
		playerButtons.setPreferredSize(new Dimension(500, 100));

		// ---------- player buttons -----------------------

		GridBagConstraints gbc_playerButtons = new GridBagConstraints();
		gbc_playerButtons.insets = new Insets(0, 0, 5, 0);
		gbc_playerButtons.fill = GridBagConstraints.BOTH;
		gbc_playerButtons.gridx = 0;
		gbc_playerButtons.gridy = 0;
		contentPane.add(playerButtons, gbc_playerButtons);
		playerButtons.setLayout(new GridLayout(1, 0, 0, 0));

		JButton player1Button = new JButton("Human");
		player1Button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		player1Button.setBackground(Color.GREEN);
		this.addPlayerButtonActionListener(player1Button, 0);
		playerButtons.add(player1Button);
		player1Button.doClick();

		JButton player2Button = new JButton("Easy");
		player2Button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		player2Button.setBackground(Color.BLUE);
		this.addPlayerButtonActionListener(player2Button, 1);
		playerButtons.add(player2Button);
		player2Button.doClick();
		player2Button.doClick();

		JButton player3Button = new JButton("Off");
		player3Button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		player3Button.setBackground(Color.RED);
		this.addPlayerButtonActionListener(player3Button, 2);
		playerButtons.add(player3Button);

		JButton player4Button = new JButton("Off");
		player4Button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		player4Button.setBackground(Color.RED);
		this.addPlayerButtonActionListener(player4Button, 3);
		playerButtons.add(player4Button);

		JButton player5Button = new JButton("Off");
		player5Button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		player5Button.setBackground(Color.RED);
		this.addPlayerButtonActionListener(player5Button, 4);
		playerButtons.add(player5Button);

		JButton player6Button = new JButton("Off");
		player6Button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		player6Button.setBackground(Color.RED);
		this.addPlayerButtonActionListener(player6Button, 5);
		playerButtons.add(player6Button);

		// -------------------- grid size ----------------------------

		JPanel gridSizeSelect = new JPanel();

		GridBagConstraints gbc_gridSizeSelect = new GridBagConstraints();
		gbc_gridSizeSelect.fill = GridBagConstraints.BOTH;
		gbc_gridSizeSelect.insets = new Insets(0, 0, 5, 0);
		gbc_gridSizeSelect.gridx = 0;
		gbc_gridSizeSelect.gridy = 1;
		contentPane.add(gridSizeSelect, gbc_gridSizeSelect);
		gridSizeSelect.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblNewLabel = new JLabel("Select Size:     ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridSizeSelect.add(lblNewLabel);

		JButton btnX = new JButton("4");
		this.addGridSelectActionListener(btnX, 0);
		gridSizeSelect.add(btnX);

		JLabel lblTimes = new JLabel(" x ");
		lblTimes.setHorizontalAlignment(SwingConstants.CENTER);
		gridSizeSelect.add(lblTimes);

		JButton btnY = new JButton("4");
		this.addGridSelectActionListener(btnY, 1);
		gridSizeSelect.add(btnY);

		// -------------- fixed size --------------------------

		JPanel fixedSize = new JPanel();
		fixedSize.setLayout(new GridLayout(1, 4));
		fixedSize.setPreferredSize(new Dimension(500, 100));

		GridBagConstraints gbc_fixedSize = new GridBagConstraints();
		gbc_fixedSize.fill = GridBagConstraints.BOTH;
		gbc_fixedSize.insets = new Insets(0, 0, 5, 0);
		gbc_fixedSize.gridx = 0;
		gbc_fixedSize.gridy = 2;
		contentPane.add(fixedSize, gbc_fixedSize);

		JButton btnSmall = new JButton("Small board");
		this.addFixedSizeAction(btnSmall, 1, btnX, btnY);
		fixedSize.add(btnSmall);

		JButton btnMedium = new JButton("Medium board");
		this.addFixedSizeAction(btnMedium, 2, btnX, btnY);
		fixedSize.add(btnMedium);

		JButton btnLarge = new JButton("Large board");
		this.addFixedSizeAction(btnLarge, 3, btnX, btnY);
		fixedSize.add(btnLarge);

		// -------------------- Theme ----------------------------------------

		JPanel Theme = new JPanel();
		GridBagConstraints gbc_Theme = new GridBagConstraints();
		gbc_Theme.fill = GridBagConstraints.BOTH;
		gbc_Theme.insets = new Insets(0, 0, 5, 0);
		gbc_Theme.gridx = 0;
		gbc_Theme.gridy = 3;
		contentPane.add(Theme, gbc_Theme);
		Theme.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblSelectTheme = new JLabel("Select Theme: ");
		lblSelectTheme.setHorizontalAlignment(SwingConstants.CENTER);
		Theme.add(lblSelectTheme);

		JButton btnPokemon = new JButton("Pokemon");
		Theme.add(btnPokemon);

		JButton btnShadesOf = new JButton("50 Shades");
		Theme.add(btnShadesOf);

		JButton btnFlags = new JButton("Symbols");
		Theme.add(btnFlags);
		
		this.addThemeSelectionActionListener(btnPokemon, btnShadesOf, btnFlags, 1);
		this.addThemeSelectionActionListener(btnShadesOf, btnFlags, btnPokemon, 2);
		this.addThemeSelectionActionListener(btnFlags, btnPokemon, btnShadesOf, 3);
		btnPokemon.doClick();

		JPanel Timer = new JPanel();
		GridBagConstraints gbc_Timer = new GridBagConstraints();
		gbc_Timer.insets = new Insets(0, 0, 5, 0);
		gbc_Timer.fill = GridBagConstraints.BOTH;
		gbc_Timer.gridx = 0;
		gbc_Timer.gridy = 4;
		contentPane.add(Timer, gbc_Timer);
		GridBagLayout gbl_Timer = new GridBagLayout();
		gbl_Timer.columnWidths = new int[] { 112, 0, 318, 0 };
		gbl_Timer.rowHeights = new int[] { 36, 0 };
		gbl_Timer.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Timer.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		Timer.setLayout(gbl_Timer);

		JLabel lblSelectTime = new JLabel("Select Time: ");
		lblSelectTime.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSelectTime = new GridBagConstraints();
		gbc_lblSelectTime.fill = GridBagConstraints.VERTICAL;
		gbc_lblSelectTime.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelectTime.gridx = 0;
		gbc_lblSelectTime.gridy = 0;
		Timer.add(lblSelectTime, gbc_lblSelectTime);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setValue(30);
		scrollBar.setUnitIncrement(5);
		scrollBar.setMaximum(60);
		scrollBar.setMinimum(15);
		
		JLabel lblNewLabel_1 = new JLabel("30");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		Timer.add(lblNewLabel_1, gbc_lblNewLabel_1);
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.fill = GridBagConstraints.BOTH;
		gbc_scrollBar.gridx = 2;
		gbc_scrollBar.gridy = 0;
		Timer.add(scrollBar, gbc_scrollBar);
		
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				action.setTimeSelected((scrollBar.getValue()));
				lblNewLabel_1.setText(""+action.getTimeSelected());
			}
		});

		JPanel ContinueButton = new JPanel();
		GridBagConstraints gbc_ContinueButton = new GridBagConstraints();
		gbc_ContinueButton.gridx = 0;
		gbc_ContinueButton.gridy = 5;
		
		contentPane.add(ContinueButton, gbc_ContinueButton);

		JButton continueButton = new JButton("Continue to Name Select");
		this.addContinueSelectionActionListener(continueButton);
		ContinueButton.add(continueButton);

	}

	private void addFixedSizeAction(JButton button, int buttonID, JButton btnX,
			JButton btnY) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.gridFixedSizeAction(button, buttonID, btnX, btnY);

			}
		});
	}

	private void addPlayerButtonActionListener(JButton button, int playerID) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				action.playerButtonAction(button, playerID);

			}
		});
	}

	public void addGridSelectActionListener(JButton button, int buttonID) {

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.gridButtonAction(button, buttonID);

			}
		});

	}
	
	public void addThemeSelectionActionListener(JButton button, JButton other, JButton other2, int buttonID) {

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.themeButtonAction(button, other, other2, buttonID);

			}
		});

	}
	
	public void addContinueSelectionActionListener(JButton button) {

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.continueButtonAction(button, settings);
				

			}
		});
	}
}
