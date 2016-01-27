package GUI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AIGTester {
	static Scanner scanner;
	static Random random;

	AIGTester() {
		AIGenius genius = new AIGenius("genius", 2);
		Player player = new Player("human");
		Grid grid = new Grid(2, 3);
		scanner = new Scanner(System.in);
		// GameSettings settings;
		random = new Random();

		ArrayList<Player> allPlayers = new ArrayList<Player>();

		allPlayers.add(player);
		allPlayers.add(genius);

		makeMoves(allPlayers, grid);

	}

	void makeMoves(ArrayList<Player> totalPlayers, Grid grid) {
		while (grid.hasUnturnedTiles()) {
			// if(grid.hasUnturnedTiles()){
			// grid.showGrid();
			// break;
			// }

			for (int i = 0; i < totalPlayers.size(); i++) {
				System.out.println(totalPlayers.get(i).getName() + "'s Turn :");
				Brick brick1, brick2;
				boolean hasPair = false;

				if (totalPlayers.get(i) instanceof AIGenius) {
					System.out.println("Genius");
					do {
						int[] coordinates = input1Random(
								(AIGenius) totalPlayers.get(i), grid);

						brick1 = grid.getBrick(new Coordinates(coordinates[0],
								coordinates[1]));
						brick1.setX(coordinates[0]);
						brick1.setY(coordinates[1]);

						brick1.setFaceUp(true);
						grid.showGrid();

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
					} while (hasPair && grid.hasUnturnedTiles());

				} else if (totalPlayers.get(i) instanceof Player) {
					do {
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
			

			// we take random x and y.. and first Brik... so keep in temp.. and
			// SHOW TRUE
			// we take random 2 and secound brik... so

			// if they are same... pair..
			// do like normal player,,,, we add to score ,,,,

			// move both in memory if not... and turn back...

		}// while (grid.hasUnturnedTiles())
	}

	private void removeFromMemoryOFGeniusPlayers(AIGenius player, Brick brick2) {
		
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

	public static void main(String[] args) {
		AIGTester tester = new AIGTester();
	}
}
