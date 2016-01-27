package memoryGame;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Player {

	private int difficulty;
	private int[] coordinates;
	// private String[] addToMemory;
	private ArrayList<String[]> AImemory;
	private ArrayList<String> foundPairs;
	Random random;

	public AIPlayer(String name, int difficulty) {
		super(name);
		// addToMemory = new String[3];
		this.difficulty = difficulty;
		random = new Random();
		AImemory = new ArrayList<String[]>();
		foundPairs = new ArrayList<String>();
		coordinates = new int[4];

	}

	public ArrayList<String[]> getAImemory() {
		return AImemory;
	}

	public void addToMemory(String ID, int row, int column) {
		// adds ID of tile and poisition to AImemory
		AImemory.add(new String[] { "" + ID, "" + row, "" + column });

	}

	public void addToMemoryDifficulty(String ID, int row, int column) {
		boolean AIremembers = false;

		switch (difficulty) {
		case (0): { // 33%
			if (random.nextInt(3) == 2) {
				AIremembers = true;
			}
			break;
		}
		case (1): { // 66%
			if (random.nextInt(3) >= 1) {
				AIremembers = true;
			}
			break;
		}
		case (2): { // 100%
			AIremembers = true;
			break;
		}
		default: {
			break;
		}
		}

		if (AIremembers) {
			AImemory.add(new String[] { "" + ID, "" + row, "" + column });
		}
	}

	public int[] getFirstTile(Grid grid) {

		// ------------------ check for pairs ----------------------------

		for (int i = 0; i < AImemory.size(); i++) {
			for (int j = 0; j < AImemory.size(); j++) {

				if (i == j) { // leave empty, makes sure list does not check
								// against itself
				}

				else {
					checkForPairsLoop: // name of loop
					if (AImemory.get(i)[0].equals(AImemory.get(j)[0])) {

						for (String k : foundPairs) {

							if (k.equals(AImemory.get(i)[0])) {
								break checkForPairsLoop; // breaks outer loop
							}

						}

						coordinates[0] = Integer.parseInt(AImemory.get(i)[1]);
						coordinates[1] = Integer.parseInt(AImemory.get(i)[2]);
						coordinates[2] = Integer.parseInt(AImemory.get(j)[1]);
						coordinates[3] = Integer.parseInt(AImemory.get(j)[2]);

						foundPairs.add(AImemory.get(i)[0]);

						return coordinates;

					}
				}
			}

		}

		// ------------- get random tile -------------------------------------

		int[] randomTile = this.getRandomTile(grid);
		coordinates[0] = randomTile[0];
		coordinates[1] = randomTile[1];
		coordinates[2] = -1;
		coordinates[3] = -1;

		// -------------------------

		return coordinates;
	}

	public int[] getSecondTile(Brick tile1, Grid grid) {

		for (int i = 0; i < AImemory.size(); i++) {

			if ((AImemory.get(i)[0]).equals(tile1)) {

				if (String.valueOf(AImemory.get(i)[1]).equals(tile1.getX())) {
					if (String.valueOf(AImemory.get(i)[2]).equals(tile1.getY())) {
						break; // breaks if tile is already turned
					}
				}

				coordinates[2] = Integer.parseInt(AImemory.get(i)[1]);
				coordinates[3] = Integer.parseInt(AImemory.get(i)[2]);

				return coordinates;
			}

		}

		int[] randomTile = this.getRandomTile(grid);

		coordinates[2] = randomTile[0];
		coordinates[3] = randomTile[1];

		return coordinates;

	}

	public int[] getRandomTile(Grid grid) {
		// TODO: add grid to constructor, add gridsize to random generator
		int[] randomTile = new int[2];
		boolean foundTileToTurn = false;

		while (!foundTileToTurn) {

			randomTile[0] = random.nextInt(grid.getSizeX());
			randomTile[1] = random.nextInt(grid.getSizeY());
			// Add way to check if tile is turned
			
			// Much Syntax, very code.

			if (!grid.getBrick(randomTile[0], randomTile[1]).isFaceUp()) {
				foundTileToTurn = true;
			}

		}

		return randomTile;
	}

}
