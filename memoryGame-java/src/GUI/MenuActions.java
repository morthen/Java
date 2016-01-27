package GUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class MenuActions {

	private ArrayList<String> playerButtonText;
	private int[] playerButtonTextID, gridButtonSelection; // info about what
															// mode of the
															// button is in
	private int themeSelected, timeSelected;

	public MenuActions() {

		playerButtonTextID = new int[6];
		gridButtonSelection = new int[2];
		gridButtonSelection[0] = 4;
		gridButtonSelection[1] = 4;
		playerButtonText = new ArrayList<String>();
		playerButtonText.add("Human");
		playerButtonText.add("Easy");
		playerButtonText.add("Medium");
		playerButtonText.add("Hard");
		playerButtonText.add("OFF");
		timeSelected = 30;
		themeSelected = 1;
	}

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

	public int getTimeSelected() {
		return timeSelected;
	}

	public void setTimeSelected(int timeSelected) {
		this.timeSelected = timeSelected;
	}

	// -------------------- actions ------------------------

	public void playerButtonAction(JButton button, int buttonID) {
		button.setText(playerButtonText.get(playerButtonTextID[buttonID]));
		// TODO: set better colors. Fix first click of button

		playerButtonTextID[buttonID]++;
		if (playerButtonTextID[buttonID] > 4) {
			playerButtonTextID[buttonID] = 0;
		}
		
		switch (playerButtonTextID[buttonID]) {
		case 1: {
			button.setBackground(Color.GREEN);
			break;
		}
		case 2: {
			button.setBackground(Color.BLUE);
			break;
		}
		case 3: {
			button.setBackground(Color.YELLOW);
			break;
		}
		case 4: {
			button.setBackground(Color.PINK);
			break;
		}
		case 0: {
			button.setBackground(Color.RED);
			break;
		}
		default:
			break;
		}



	} // method end

	public void themeButtonAction(JButton selection, JButton other,
			JButton other2, int buttonID) {

		selection.setBackground(Color.GRAY);
		other.setBackground(null);
		other2.setBackground(null);
		themeSelected = buttonID;

	}

	public void gridButtonAction(JButton button, int buttonID) {

		gridButtonSelection[buttonID]++; // adds one to the selection

		if (gridButtonSelection[buttonID] > 12) { // loopar from 12 tom 4
			gridButtonSelection[buttonID] = 4;
		}

		if (gridButtonSelection[0] == 10 && gridButtonSelection[1] == 12
				&& buttonID == 0) {
		}

		button.setText("" + gridButtonSelection[buttonID]);
	}

	public void gridFixedSizeAction(JButton button, int buttonID, JButton btnX,
			JButton btnY) {

		switch (buttonID) {

		case 1: {
			gridButtonSelection[0] = 4;
			gridButtonSelection[1] = 4;
			break;
		}

		case 2: {
			gridButtonSelection[0] = 6;
			gridButtonSelection[1] = 8;
			break;

		}

		case 3: {
			gridButtonSelection[0] = 10;
			gridButtonSelection[1] = 12;
			break;

		}

		}

		btnX.setText("" + gridButtonSelection[0]);
		btnY.setText("" + gridButtonSelection[1]);

	}
	
	public void continueButtonAction(JButton button, GUIGameSettings settings){
		
		int gridRows =0, gridColumns =0;
		
		if (gridButtonSelection[0] > gridButtonSelection[1]){
			gridColumns = gridButtonSelection[0];
			gridRows = gridButtonSelection[1];
		}
		else{
			gridColumns = gridButtonSelection[1];
			gridRows = gridButtonSelection[0];
		}
		
		
		settings.setGridColumns(gridColumns);
		settings.setGridRows(gridRows);
		settings.setTime(timeSelected);
		settings.setTheme(themeSelected);
		
		
		// generate players
		for (int i = 0; i < 6; i++){
			switch (playerButtonTextID[i]){
			
			case 0:{ // off. do not create player
				break;
			}
			case 1:{ // human
				settings.getPlayers().add(new Player("Player"+i));
				break;
			}
			case 2: { // easy
				settings.getPlayers().add(new AIGenius("Player"+i, 1));
				break;
			}
			case 3: { // medium
				settings.getPlayers().add(new AIGenius("Player"+i, 2));
				break;
			}
			case 4: { // hard
				settings.getPlayers().add(new AIGenius("Player"+i, 3));
				break;
			}
			default: break;	
			}
		
		} // loop end
		
		settings.setNumberOfPlayers(settings.getPlayers().size());
		settings.setSettingsWindow(false);
		
	}


	

}
