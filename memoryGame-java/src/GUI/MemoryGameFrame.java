package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Window.Type;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.UIManager;

public class MemoryGameFrame extends JFrame {

	private JPanel MemoryGameFrame;
	private JPanel Menu;
	private JPanel MainBoard;
	private JPanel PlayerNames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryGameFrame frame = new MemoryGameFrame();
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
	public MemoryGameFrame() {
		setResizable(false);
		setTitle("Memory Game Group2");
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1000);
		MemoryGameFrame = new JPanel();
		MemoryGameFrame.setBackground(Color.WHITE);
		MemoryGameFrame.setToolTipText("");
		MemoryGameFrame.setFocusCycleRoot(true);
		MemoryGameFrame.setRequestFocusEnabled(false);
		MemoryGameFrame.setName("Group 2 Memory Game\r\n");
		MemoryGameFrame.setBorder(null);
		
		setContentPane(MemoryGameFrame);
		GridBagLayout gbl_MemoryGameFrame = new GridBagLayout();
		gbl_MemoryGameFrame.columnWidths = new int[] {150, 1050};
		gbl_MemoryGameFrame.rowHeights = new int[] {50, 900, 50};
		gbl_MemoryGameFrame.columnWeights = new double[]{1.0, 1.0};
		gbl_MemoryGameFrame.rowWeights = new double[]{1.0, 1.0, 0.0};
		MemoryGameFrame.setLayout(gbl_MemoryGameFrame);
		
		Menu = new JPanel();
		GridBagConstraints gbc_Menu = new GridBagConstraints();
		gbc_Menu.insets = new Insets(0, 0, 5, 5);
		gbc_Menu.fill = GridBagConstraints.BOTH;
		gbc_Menu.gridx = 1;
		gbc_Menu.gridy = 0;
		MemoryGameFrame.add(Menu, gbc_Menu);
		
		JPanel LeftBorder = new JPanel();
		GridBagConstraints gbc_LeftBorder = new GridBagConstraints();
		gbc_LeftBorder.insets = new Insets(0, 0, 5, 5);
		gbc_LeftBorder.fill = GridBagConstraints.BOTH;
		gbc_LeftBorder.gridx = 0;
		gbc_LeftBorder.gridy = 1;
		MemoryGameFrame.add(LeftBorder, gbc_LeftBorder);
		
		MainBoard = new JPanel();
		GridBagConstraints gbc_MainBoard = new GridBagConstraints();
		gbc_MainBoard.insets = new Insets(0, 0, 5, 5);
		gbc_MainBoard.fill = GridBagConstraints.BOTH;
		gbc_MainBoard.gridx = 1;
		gbc_MainBoard.gridy = 1;
		MemoryGameFrame.add(MainBoard, gbc_MainBoard);
		
		PlayerNames = new JPanel();
		PlayerNames.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_PlayerNames = new GridBagConstraints();
		gbc_PlayerNames.gridwidth = 3;
		gbc_PlayerNames.gridx = 0;
		gbc_PlayerNames.gridy = 2;
		MemoryGameFrame.add(PlayerNames, gbc_PlayerNames);
		PlayerNames.setLayout(new GridLayout(0, 6, 0, 0));
	}

	public JPanel getMenu() {
		return Menu;
	}
	public JPanel getMainBoard() {
		return MainBoard;
	}
	public JPanel getPlayerBar() {
		return PlayerNames;
	}
}
