package GUI;

import java.util.ArrayList;

public class GUIGameSettings {



	
	private ArrayList<Player> players;
	private int numberOfPlayers, theme;
	private int gridRows, gridColumns, time;
	private boolean atSettingsWindow = true;
	
	public GUIGameSettings(){
		players = new ArrayList<Player>();
	}
	public GUIGameSettings(int x){
		
	}

	public boolean isSettingsWindow() {
		return atSettingsWindow;
	}

	public void setSettingsWindow(boolean settingsWindow) {
		this.atSettingsWindow = settingsWindow;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getGridRows() {
		return gridRows;
	}

	public void setGridRows(int gridRows) {
		this.gridRows = gridRows;
	}

	public int getGridColumns() {
		return gridColumns;
	}

	public void setGridColumns(int gridColumns) {
		this.gridColumns = gridColumns;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList <Player> players) {
		this.players = players;
	}
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public int getNumberOfPlayers(){
		return numberOfPlayers;
	}
	
	public void setTheme(int theme) {
		this.theme = theme;
	}
	
	public int getTheme(){
		return theme;
	}
	


}
