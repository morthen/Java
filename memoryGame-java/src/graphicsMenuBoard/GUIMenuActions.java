package graphicsMenuBoard;

import graphicsNameSelectBoard.GUINameSelectBoard;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class GUIMenuActions {

	private ArrayList <String> playerButtonText;
	private int [] playerButtonTextID, gridButtonSelection; // info about what mode of the button is in
	private int themeSelected;
	
	public GUIMenuActions() {
		
		playerButtonTextID = new int [6]; 
		gridButtonSelection = new int [2];
		gridButtonSelection[0] = 4;
		gridButtonSelection[1] = 4;
		playerButtonText = new ArrayList<String>();
		playerButtonText.add("Human");
		playerButtonText.add("AI Easy");
		playerButtonText.add("AI Medium");
		playerButtonText.add("AI Hard");
		playerButtonText.add("OFF");
	}
	
	// ----------------- getters and setters ---------
	
	public int[] getPlayerButtonTextID() {
		return playerButtonTextID;
	}

	public void setPlayerButtonTextID(int[] playerButtonTextID) {
		this.playerButtonTextID = playerButtonTextID;
	}

	public int[] getGridButtonSelection() {
		return gridButtonSelection;
	}

	public void setGridButtonSelection(int[] gridButtonSelection) {
		this.gridButtonSelection = gridButtonSelection;
	}

	public int getThemeSelected() {
		return themeSelected;
	}

	public void setThemeSelected(int themeSelected) {
		this.themeSelected = themeSelected;
	}
	
	// -------------------- actions ------------------------
	
	public void playerButtonAction(JButton button, int buttonID){
		button.setText(playerButtonText.get(playerButtonTextID[buttonID]));
		
		switch (playerButtonTextID[buttonID]){
		case 0: {
			button.setBackground(Color.GREEN);
			break;
		}
		case 1: {
			button.setBackground(Color.BLUE);
			break;
		}
		case 2: {
			button.setBackground(Color.YELLOW);
			break;
		}
		case 3: {
			button.setBackground(Color.PINK);
			break;
		}
		case 4: {
			button.setBackground(Color.RED);
			break;
		}
		default: break;
		}
		
		playerButtonTextID[buttonID]++;
		
		if (playerButtonTextID[buttonID] > 4){
			playerButtonTextID[buttonID] = 0; 
		}
		
	} // method end

	public void themeButtonAction(JButton[] buttons, int buttonID){
		
		for (int i = 0; i < 3; i++){
			if(buttonID!=i) {
				buttons[i].setBackground(null);
			}
			else {
				buttons[i].setBackground(Color.GRAY);
				themeSelected = i;
			}
			
		}
		
	}

	public void gridButtonAction(JButton[] buttons, int buttonID) {
		
		gridButtonSelection[buttonID]++; // adds one to the selection
		
		if ((gridButtonSelection[0]*gridButtonSelection[1])%2 != 0){ //makes so that you can not get odd input
			gridButtonSelection[buttonID]++;
		}
		
		if (gridButtonSelection[buttonID] > 12){ //loopar from 12 tom 4
			gridButtonSelection[buttonID] = 4;
		}
		
		if ((gridButtonSelection[0]*gridButtonSelection[1]) > 120){ // if total size of grid is more than 120
			gridButtonSelection[0] = 10;
			gridButtonSelection[1] = 12;
			buttons[0].setText(""+gridButtonSelection[0]);
			buttons[1].setText(""+gridButtonSelection[1]);
		}
		
		if(gridButtonSelection[0] == 10 && gridButtonSelection[1] == 12 && buttonID == 0){
			gridButtonSelection[buttonID] = 4; // sets id to 4 if the grid is 10 x 12
		}
		
		buttons[buttonID].setText(""+gridButtonSelection[buttonID]);
	}
	
}
