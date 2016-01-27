package memoryGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameMotor {

	private GameSettings gameSettings;
	private Grid grid;
	private ArrayList<Player> allPlayers;
	private Player currentPlayer;
	static Scanner scanner;
	static Random random;

	public static void main(String[] args) {
		GameMotor gameMotor = new GameMotor();

		gameMotor.startGame();
	}

	public GameMotor() {
		scanner = new Scanner(System.in);
		// GameSettings settings;
		random = new Random();
	        gameSettings = new GameSettings();
	}

	public GameMotor(int x) {

	}

	private void startGame() {
	

		setAllPlayers(gameSettings.getAllPlayers());

		grid = new Grid(gameSettings.getRows(), gameSettings.getColumns());

		grid.showGrid(gameSettings.currentTheme.getThemeId());

		try {
			makeMoves(allPlayers, grid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeToNextPlayer() {

		int currentPosition = getAllPlayers().indexOf(getCurrentPlayer());
		int positionAtBottomOfList = getAllPlayers().size() - 1;

		if (currentPosition == positionAtBottomOfList) {
			setCurrentPlayer(getAllPlayers().get(0));
		} else {
			setCurrentPlayer(getAllPlayers().get(currentPosition + 1));
		}

	}

	public Coordinates getCoordinatesFromUser() {

		System.out.println(getCurrentPlayer().getName()
				+ ", which tile do you want to turn?");
		System.out.print("Row: ");
		int row = -1;
		while (row == -1) {

			row = inputAsInteger() - 1;

			if (row >= 0 && row <= gameSettings.getRows() - 1) {
				break;
			} else if (row != -1) {
				System.out
						.println("You've entered a row that is not included in the grid. Please re-enter.");
				row = -1;
			}
			// TODO: Clean validation - break out and place somewhere else in an
			// own method

		}
		System.out.print("Column: ");
		int column = -1;
		while (column == -1) {
			column = inputAsInteger() - 1;

			if (column >= 0 && column <= gameSettings.getColumns()- 1) {
				break;
			} else if (column != -1) {
				System.out
						.println("You've entered a column that is not included in the grid. Please re-enter.");
				column = -1;
			}
			// TODO: Clean validation - break out and place somewhere else in an
			// own method
		}

		// TODO: where to place this method? In what class?
		Coordinates coordinates = new Coordinates(row, column);
		return coordinates;
	}

	public int inputAsInteger() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int integer;
		try {
			String userInput = br.readLine();
			integer = Integer.parseInt(userInput);
		} catch (Exception e) {

			System.out.println("Please re-enter a valid number.");
			integer = 0;
		}

		// TODO: where to place this method?
		return integer;
	}

	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public GameSettings getGameSettings() {
		return gameSettings;
	}

	public Grid getGrid() {
		return grid;
	}

	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	void makeMoves(ArrayList<Player> totalPlayers, Grid grid) throws Exception {
		while (grid.hasUnturnedTiles()) {
			// if(grid.hasUnturnedTiles()){
			// grid.showGrid();
			// break;
			// }

			for (int i = 0; i < totalPlayers.size(); i++) {
				System.out.println(totalPlayers.get(i).getName() + "'s Turn :");
				Brick brick1, brick2;
				Thread.sleep(500);
				boolean hasPair = false;

				if (totalPlayers.get(i) instanceof AIGenius) {
					//System.out.println("Genius");
					do {
						hasPair = false;
						int[] coordinates = input1Random(
								(AIGenius) totalPlayers.get(i), grid);

						brick1 = grid.getBrick(new Coordinates(coordinates[0],
								coordinates[1]));
						brick1.setX(coordinates[0]);
						brick1.setY(coordinates[1]);

						brick1.setFaceUp(true);
						grid.showGrid();
						Thread.sleep(500);
                        System.out.println("--------------------");
                        
						coordinates = input2FromComputation(
								(AIGenius) totalPlayers.get(i), brick1,grid);
						brick2 = grid.getBrick(new Coordinates(coordinates[0],
								coordinates[1]));
						brick2.setX(coordinates[0]);
						brick2.setY(coordinates[1]);

						brick2.setFaceUp(true);
						grid.showGrid();

						if (brick1.tilesMatch(brick2)) {

							System.out.println(totalPlayers.get(i).getName()
									+ " you found a pair!");
							totalPlayers.get(i).increaseNumOfMatches();
							hasPair = true;
							removeFromMemoryOFGeniusPlayers((AIGenius) totalPlayers.get(i),
									brick2);

						} else {

							addToMemoryOFGeniusPlayers(totalPlayers, brick1,
									brick2);
							brick1.setFaceUp(false);
							brick2.setFaceUp(false);
						}
						Thread.sleep(500);
					} while (hasPair && grid.hasUnturnedTiles());

				} else if (totalPlayers.get(i) instanceof Player) {
					do {
						hasPair = false;
						int[] coordinates = inputFromUser(totalPlayers.get(i)

						.getName());
						brick1 = grid.getBrick(new Coordinates(coordinates[0],
								coordinates[1]));

						brick1.setX(coordinates[0]);
						brick1.setY(coordinates[1]);
						brick1.setFaceUp(true);
						grid.showGrid();

						coordinates = inputFromUser(totalPlayers.get(i)
								.getName());
						brick2 = grid.getBrick(new Coordinates(coordinates[0],
								coordinates[1]));
						brick2.setX(coordinates[0]);
						brick2.setY(coordinates[1]);
						brick2.setFaceUp(true);
						grid.showGrid();

						if (brick1.tilesMatch(brick2)) {

							System.out.println(totalPlayers.get(i).getName()
									+ " you found a pair!");
							totalPlayers.get(i).increaseNumOfMatches();
							hasPair = true;

						} else {
							hasPair = false;

							// turn the tiles back
							addToMemoryOFGeniusPlayers(totalPlayers, brick1,
									brick2);

							brick1.setFaceUp(false);
							brick2.setFaceUp(false);
						}
					} while (hasPair && grid.hasUnturnedTiles());

				}

			}
//
			// calculate winner

			// compare all players score - highest is winner
			if (getAllPlayers().size() == 1) {
				System.out.println("CONGRATULATIONS! You won "
						+ getCurrentPlayer().getName() + "! ");
			} else {
				Player winner = getAllPlayers().get(0);
				for (int i = 0; i < getAllPlayers().size(); i++) {
					if (winner.getNumOfMatches() < getAllPlayers().get(i)
							.getNumOfMatches()) {
						// TODO: clean this - hard to see what's happening
						// (comparing scores towards each other)
						// TODO: maybe use comparator on player and compare scores
						// Then sort list accordingly and get first player - will be
						// winner
						winner = getAllPlayers().get(i);
					}

				}

				System.out.println(winner.getName() + " is the winner with "
						+ winner.getNumOfMatches() + " pairs found.");
				}

			// we take random x and y.. and first Brik... so keep in temp.. and
			// SHOW TRUE
			// we take random 2 and secound brik... so

			// if they are same... pair..
			// do like normal player,,,, we add to score ,,,,

			// move both in memory if not... and turn back...

		}// while (grid.hasUnturnedTiles())
	}private void removeFromMemoryOFGeniusPlayers(AIGenius player, Brick brick2) {
		
		int index = getIndexOfBrick( player,  brick2);
		if(player.playersMemory.size()>0)
		player.playersMemory.remove(index);
	}

	private int getIndexOfBrick(AIGenius aiGenius, Brick brick2) {
		for  (int x=0;x<aiGenius.playersMemory.size();x++)
		{
			
			 if(aiGenius.playersMemory.get(x).getValue().equals(brick2.getValue())) 
			 {return x;}	 
					 
					
			
		}
		return 0;
		
//		for (Coordinates item : aiGenius.playersMemory) {
//			 if(item.getValue().equals(brick2.getValue())) 
//				
//			}
//		}
//		
//		return 0;
	}

	private int[] input1Random(AIGenius aiGenius, Grid grid) {

		int[] coordinates = new int[2];
		boolean currentTileOpen, hasInMemory;
		do {
			coordinates[0] = random.nextInt(grid.getSizeX());
			coordinates[1] = random.nextInt(grid.getSizeY());
			Coordinates c = new Coordinates(coordinates[0], coordinates[1]);
			currentTileOpen = grid.getBrick(c).isFaceUp();
			hasInMemory = alreadyInMemmory(aiGenius, c);
		} while (currentTileOpen || hasInMemory);
		return coordinates;
	}

	private boolean alreadyInMemmory(AIGenius aiGenius, Coordinates c) {
		boolean present = false;
		for (Coordinates item : aiGenius.playersMemory) {
			if ((item.getRow() == c.getRow())
					&& (item.getColumn() == c.getColumn())) {
				present = true;
			}
		}
		return present;
	}

	private int[] input2FromComputation(AIGenius aiGenius, Brick brick1,Grid grid) {
		int[] coordinates = new int[2];
		boolean currentTileOpen, hasInMemory;
		if (alreadyInMemmoryWithSameValue(aiGenius, brick1)) {
			return brickFromMemmoryWithSameValue(aiGenius,brick1);
			//
		}
		else
		{
			do {
				coordinates[0] = random.nextInt(grid.getSizeX());
				coordinates[1] = random.nextInt(grid.getSizeY());
				Coordinates c = new Coordinates(coordinates[0], coordinates[1]);
				currentTileOpen = grid.getBrick(c).isFaceUp();
				hasInMemory = alreadyInMemmory(aiGenius, c);
			} while (currentTileOpen || hasInMemory);
			
			
		}
		return coordinates;
	}

	private int[] brickFromMemmoryWithSameValue(AIGenius aiGenius,Brick brick1) {
		int[] coordinates = new int[2];
		for (Coordinates item : aiGenius.playersMemory) {
			   if(item.getValue().equals(brick1.getValue())) 
					   {
				   coordinates[0] = item.getRow();
				   coordinates[1] = item.getColumn();
				 
					   }
			}
			
		return coordinates;
	}

	private boolean alreadyInMemmoryWithSameValue(AIGenius aiGenius,
			Brick brick1) {
		boolean present = false;
		for (Coordinates item : aiGenius.playersMemory) {
		   if(item.getValue().equals(brick1.getValue())) 
				   {
			   present = true;
				   }
		}
		return present;
		
	}

	int[] generateRandomCoordinates() {
		return null;

	}

	private void addToMemoryOFGeniusPlayers(ArrayList<Player> totalPlayers,
			Brick brick1, Brick brick2) {
		for (int i = 0; i < totalPlayers.size(); i++) {
			if (totalPlayers.get(i) instanceof AIGenius) {
				AIGenius g = (AIGenius) totalPlayers.get(i);
				if (!alreadyInMemmoryWithSameValue(g,brick1) )
				{
					g.playersMemory.add(new Coordinates(brick1.getX(), brick1
							.getY(), brick1.getValue()));	
				}
				if (!alreadyInMemmoryWithSameValue(g,brick2) )
				{

					g.playersMemory.add(new Coordinates(brick2.getX(), brick2
							.getY(), brick2.getValue()));
				}
				
			}

		}

	}

	

	public int[] inputFromUser(String name) {

		System.out.println("What tile do " + name + " want to turn?");

		int[] coordinates = new int[2];

		try {
			System.out.print("What row: ");
			coordinates[0] = scanner.nextInt() - 1;
			System.out.print("What column: ");
			coordinates[1] = scanner.nextInt() - 1;

		} catch (Exception e) {
			System.out.println("Wrong input " + e);
		}

		return coordinates;
	}

	
}
