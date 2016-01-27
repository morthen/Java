package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUINameSelectWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1; //1
	private JTextField textField_2; //2
	private JTextField textField_3; //3
	private JTextField textField_4; //4
	private JTextField textField_5; //5
	private JTextField textField;   //6
	private boolean startButtonPressed = false;

	public boolean isStartButtonPressed() {
		return startButtonPressed;
	}

	public void setStartButtonPressed(boolean startButtonPressed) {
		this.startButtonPressed = startButtonPressed;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGameSettings settings = new GUIGameSettings();
					GUINameSelectWindow frame = new GUINameSelectWindow(settings);
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
	public GUINameSelectWindow(GUIGameSettings settings) {
		setTitle("Name Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 28, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{100, 320, 0};
		gbl_panel_2.rowHeights = new int[]{22, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		// ----------- Player 1 -------------------------------
		
		JLabel label_1 = new JLabel("Player 1 name: ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_2.add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		textField_1.setText("Player 1");
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_2.add(textField_1, gbc_textField_1);
		
		// ------------------
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{100, 320, 0};
		gbl_panel_3.rowHeights = new int[]{22, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		// ---------------- player 2 -------------------------
		
		JLabel label_2 = new JLabel("Player 2  name: ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 0;
		panel_3.add(label_2, gbc_label_2);
		
		textField_2 = new JTextField();
		textField_2.setText("Player 2");
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_3.add(textField_2, gbc_textField_2);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{100, 320, 0};
		gbl_panel_4.rowHeights = new int[]{22, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);

		// ---------------- player 3 -------------------------
		

		JLabel label_3 = new JLabel("Player 3 name: ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		panel_4.add(label_3, gbc_label_3);
		
		textField_3 = new JTextField();
		textField_3.setText("Player 3");
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		panel_4.add(textField_3, gbc_textField_3);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 3;
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{100, 320, 0};
		gbl_panel_6.rowHeights = new int[]{22, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		// ---------------- player 4 -------------------------
		

		JLabel label_5 = new JLabel("Player 4 name: ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 0;
		panel_6.add(label_5, gbc_label_5);
		
		textField_5 = new JTextField();
		textField_5.setText("Player 4");
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.anchor = GridBagConstraints.NORTH;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 0;
		panel_6.add(textField_5, gbc_textField_5);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 4;
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{100, 320, 0};
		gbl_panel_5.rowHeights = new int[]{22, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		// ---------------- player 5 -------------------------
		

		JLabel label_4 = new JLabel("Player 5 name: ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 0;
		panel_5.add(label_4, gbc_label_4);
		
		textField_4 = new JTextField();
		textField_4.setText("Player 5");
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 0;
		panel_5.add(textField_4, gbc_textField_4);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 5;
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{100, 320, 0};
		gbl_panel_1.rowHeights = new int[]{22, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		// ---------------- player 6 -------------------------
		

		JLabel label = new JLabel("Player 6 name: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setText("Player 6");
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		
		JButton btnStartGame = new JButton("Start Game");
		GridBagConstraints gbc_btnStartGame = new GridBagConstraints();
		this.addStartButtonActionListener(btnStartGame, settings);
		gbc_btnStartGame.gridx = 0;
		gbc_btnStartGame.gridy = 7;
		contentPane.add(btnStartGame, gbc_btnStartGame);
		
		// -----     add player name bars to board -------------------
		
		for (int i = 0; i < settings.getNumberOfPlayers(); i++){
			if (i == 0){contentPane.add(panel_2, gbc_panel_2); // player 1
			}
			if (i == 1){contentPane.add(panel_3, gbc_panel_3); // player 2
			}
			if (i == 2){contentPane.add(panel_4, gbc_panel_4); // player 3
			}
			if (i == 3){contentPane.add(panel_5, gbc_panel_5); // player 4
			}
			if (i == 4){contentPane.add(panel_6, gbc_panel_6); // player 5
			}
			if (i == 5){contentPane.add(panel_1, gbc_panel_1); // player 6
			}
						
		}
		
		
		
	}

	public void addStartButtonActionListener(JButton button, GUIGameSettings settings) {

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < settings.getNumberOfPlayers(); i++){
					if (i == 0) settings.getPlayers().get(i).setName(textField_1.getText());	
					if (i == 1) settings.getPlayers().get(i).setName(textField_2.getText());	
					if (i == 2) settings.getPlayers().get(i).setName(textField_3.getText());	
					if (i == 3) settings.getPlayers().get(i).setName(textField_4.getText());	
					if (i == 4) settings.getPlayers().get(i).setName(textField_5.getText());	
					if (i == 5) settings.getPlayers().get(i).setName(textField.getText());	
				} // loop end

				startButtonPressed = true;
				
			}
		});

	}
	
	
}
