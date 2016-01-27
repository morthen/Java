package memoryGame;

import java.util.ArrayList;

public class GUISettings {

	private int[] gridSize;
	private ArrayList<Player> players;
	private int numberOfPlayers, theme;
	private int gridRows, gridColumns;
	
	public GUISettings(){
		//empty constructor
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

	public int[] getGridSize() {
		return gridSize;
	}

	public void setGridSize(int[] gridSize) {
		this.gridSize = gridSize;
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
