package memoryGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSettings {

	private Scanner scanner;
	private int[] gridSize;
	private int rows;
	private int columns;
	private ArrayList<Player> allPlayers;

	// TODO: Clean away what is not used anymore

Theme currentTheme;
	

	public GameSettings() {
		scanner = new Scanner(System.in);
		allPlayers = new ArrayList<Player>();
		getTotalNumberOfPlayersFromUser();
		int aiPlayer =  askToIncludeAIPlayer();
		if(aiPlayer>0)
		{
			allPlayers.add(new AIGenius("genius", 2));
		}
		inputGridSize();


		inputThemeSelection();
		

	}


	private int askToIncludeAIPlayer() {
		
		System.out.println("Do you wana include AI Player? 0 or 1");
		// TODO: add errorhandling depending on how many players should be able to play the game
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input= -1;
		do {

			try {
				String temp = br.readLine();
				input = Integer.parseInt(temp);
				// numOfPlayers = scanner.nextInt();
			} catch (Exception e) {

				System.out.println("Please re-enter a valid number.");
				input = -1;
			}

		}while (input > 1 && input < 0);
		return input;
	}


	private void inputThemeSelection() {
	
		int x;
		do {
			System.out.println("Please choose the Theme [1 Black,2 Red,3 Green] ? ");

			try {
				
			
				x = scanner.nextInt();

				
				if (x<4 || x>0) {
					
					String themeName = "";
					switch(x)
					{
					case 1:
					themeName = "Black";
					break;
					case 2:
					themeName = "Red";
					break;
					case 3:
					themeName = "Green";
					break;
					}
					
					currentTheme = new Theme(x, themeName);
					break;
				}
		
				System.out
						.println(" Please choose between 1 and 3... again.");

			} catch (Exception e) {
				System.out.println("Wrong input " + e);
			}
		} while (true);

	}


	public int[] getGridSize() {
		return gridSize;
	}

	public void setGridSize(int[] gridSize) {
		this.gridSize = gridSize;
	}

	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}

	public void setTotalPlayers(ArrayList<Player> totalPlayers) {
		this.allPlayers = totalPlayers;
	}

	private void getTotalNumberOfPlayersFromUser() {
		System.out.println("How many players wants to play?");
		// TODO: add errorhandling depending on how many players should be able to play the game
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfPlayers = 0;
		while (numOfPlayers == 0) {

			try {
				String temp = br.readLine();
				numOfPlayers = Integer.parseInt(temp);
				// numOfPlayers = scanner.nextInt();
			} catch (Exception e) {

				System.out.println("Please re-enter a valid number.");
				numOfPlayers = 0;
			}

		}

		generatePlayerObjects(numOfPlayers);
	}

	private void generatePlayerObjects(int numOfPlayers) {

		// TODO: Should this be in another class?

		for (int x = 1; x <= numOfPlayers; x++) {
			System.out.println("Please Enter the Player " + (x) + " Name :");
			String name = scanner.next();
			scanner.nextLine();

			allPlayers.add(new Player(name));
		}

	}

	public void inputGridSize() {

		do {
			System.out.println("Please choose the size of the Grid ? ");

			try {
				System.out.print("Rows: ");
				rows = scanner.nextInt();
				System.out.print("Columns: ");
				columns = scanner.nextInt();

				if ((rows * columns) % 2 == 0) {
					break;
				}
				System.out
						.println("Cannot create a grid with an odd number of tiles. Please try again.");

			} catch (Exception e) {
				System.out.println("Wrong input " + e);
			}
		} while (true);

	}

	public Scanner getScanner() {
		return scanner;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}

}
