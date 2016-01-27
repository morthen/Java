package memoryGame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;



public class MemoryBoard extends JPanel {
	String imagePath;
	static JButton[][] buttonGrid;
	int totalButtons = 0;
	GUIGameSettings settings;
	GUIRunner runner;
	private JPanel Menu;
	ArrayList<Brick> deckOfBricks;

	public MemoryBoard(GUIRunner runner) {
		this.settings = runner.settings;
		this.runner = runner;
		buttonGrid = new JButton[settings.getGridRows()][settings
				.getGridColumns()];
		totalButtons = settings.getGridRows() * settings.getGridColumns();
		imagePath = getLocalImageDirectory(settings.getTheme());
		System.out.println(imagePath);
	//	getContentPane()
		this.setLayout(
				(LayoutManager) new GridLayout(settings.getGridRows(), settings
						.getGridColumns()));
		
  //      addTheme(settings.getTheme());
		//
    
        
        //
        createGUI();
       // startGame();
		
	}

	

	


	private void createGUI() {
	deckOfBricks = new ArrayList<Brick>();

		for (int i = 0; i < totalButtons / 2; i++) { // loop start
			deckOfBricks.add(new Brick(imagePath + i + ".png")); // creates two
																	// bricks
																	// with id
			deckOfBricks.add(new Brick(imagePath + i + ".png"));
			
		} // loop end

		Collections.shuffle(deckOfBricks); // shuffles list
		int tilesAddedToGrid = 0;
		for (int x = 0; x < settings.getGridRows(); x++) {
			for (int y = 0; y < settings.getGridColumns(); y++) {
				buttonGrid[x][y] = (Brick) deckOfBricks.get(tilesAddedToGrid);
				// adds brick to grid
				tilesAddedToGrid++;
				((Brick) buttonGrid[x][y]).setCoordX(x);
				((Brick) buttonGrid[x][y]).setCoordY(y);

			

				buttonGrid[x][y].addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {

						//playSound(imagePath + "flip.wav");

						Brick button = (Brick) e.getSource();
						// ImageIcon icon = new ImageIcon(button.value);
						// button.setIcon(icon);
						System.out.println(button.value);

						button.setFaceUp(!button.isFaceUp());
						 refreshGrid();
						// button.setEnabled(false);
						 runner.clickedButton.add(button);
						 
						 
					}
				});

				buttonGrid[x][y].setBorder(LineBorder.createGrayLineBorder());
			
				this.add(buttonGrid[x][y]);
			}
		}
	}

	String getLocalImageDirectory(int path) {
		try {
			imagePath = new java.io.File(".").getCanonicalPath();
			imagePath = imagePath + "/" + path + "/";
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;
		return imagePath;
	}

	public static synchronized void playSound(final String url)
			{
		Clip clip;
		
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(url)));
			clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 public void refreshGrid()
	 {
		 for (int i = 0; i < settings.getGridRows(); i++) {
				for (int j = 0; j < settings.getGridColumns(); j++) {

					if (((Brick) buttonGrid[i][j]).isFaceUp() == false) { // if face down
						((Brick) buttonGrid[i][j]).setIcon(null);
					} else if (((Brick) buttonGrid[i][j]).isFaceUp() == true) {
						
						// if face up, get face value
						BufferedImage master = null ;
						ImageIcon icon = new ImageIcon(((Brick) buttonGrid[i][j]).value);
						try {
							 master = ImageIO.read(new File(((Brick) buttonGrid[i][j]).value));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						 Dimension size = ((Brick) buttonGrid[i][j]).getSize();
						 Image scaled = master.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
						 
						((Brick) buttonGrid[i][j]).setIcon(new ImageIcon(scaled));
		            
					}

				} // inner loop end
				//System.out.println(" "); // new line
			} // outer loop end
		 
		 SwingUtilities.updateComponentTreeUI(this); 
	 }
//	 private void addTheme(int theme) {
//		 try {
//				UIManager.setLookAndFeel( "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			} catch (ClassNotFoundException | InstantiationException
//					| IllegalAccessException | UnsupportedLookAndFeelException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//	 
	 public boolean hasUnturnedTiles() {

			for (Brick brick : deckOfBricks) {
			
					if (!brick.isFaceUp()) {
						return true;
					}
				
			}
			return false;
		}
	
}
