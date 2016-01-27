package GUI;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anton
 *
 */
public class Grid {

	private int sizeX, sizeY; // size of grid
	// TODO: use rows and columns insteda of x and y?
	private Brick[][] gridOfBricks; // grid of bricks
	private int remaningBriks;

	/**
	 * @param sizeX
	 *            size of X axis of grid
	 * @param sizeY
	 *            size of Y axis of grid
	 */
	public Grid(int sizeX, int sizeY) // constructor
	{
		if ((sizeX * sizeY) % 2 == 1) {
			throw new IllegalArgumentException(
					"Cannot create grid with odd number of bricks. ");
		}
		gridOfBricks = new Brick[sizeX][sizeY];
		this.sizeX = sizeX; // number of rows
		this.sizeY = sizeY; // number of columns
		this.createGrid(); // creates grid and adds tiles to it
	}

	public void createGrid() {

		int numberOfBricks = sizeX * sizeY; // total number of bricks
		remaningBriks = numberOfBricks;
		ArrayList<Brick> deckOfBricks = new ArrayList<Brick>(); // list of
																// bricks to be
																// shuffled

		for (int i = 0; i < numberOfBricks / 2; i++) { // loop start
			deckOfBricks.add(new Brick("" + i)); // creates two bricks with id
			deckOfBricks.add(new Brick("" + i));
		} // loop end

		Collections.shuffle(deckOfBricks); // shuffles list

		int tilesAddedToGrid = 0; // number of bricks added to grid

		for (int i = 0; i < sizeX; i++) { // outer loop start
			for (int j = 0; j < sizeY; j++) { // inner loop start
				gridOfBricks[i][j] = deckOfBricks.get(tilesAddedToGrid);
				// adds brick to grid
				tilesAddedToGrid++;
			} // inner loop end
		} // outer loop end

	} // method createGrid end

	/**
	 * 
	 * @param x
	 *            coordinate, X axis
	 * @param y
	 *            coordinate, Y axis
	 * @return Brick at possition x, y
	 */
	public Brick getBrick(int x, int y) {
		return gridOfBricks[x][y];
	}

	public Brick getBrick(Coordinates coordinates) {

		return gridOfBricks[coordinates.getRow()][coordinates.getColumn()];
	}

	public void showGrid() {

		for (int i = 0; i < sizeX; i++) { // outer loop start
			for (int j = 0; j < sizeY; j++) { // inner loop start

				if (gridOfBricks[i][j].isFaceUp() == false) { // if face down
					System.out.print("X ");
				} else if (gridOfBricks[i][j].isFaceUp() == true) {
					// if face up, get face value
					System.out.print(gridOfBricks[i][j].getValue() + " ");
				}

			} // inner loop end
			System.out.println(" "); // new line
		} // outer loop end

	}

	public void showGrid(int x) {
		String GREEN = "\u001B[0;32m";
		String RED = "\u001b[1;31m";
		String BLACK = "\u001b[0m";
		switch(x)
		{
		case 1:
			 System.out.println(BLACK);break;
		case 2:
			 System.out.println(RED);break;
		case 3:
			 System.out.println(GREEN);break;
		}


		for (int i = 0; i < sizeX; i++) { // outer loop start
			for (int j = 0; j < sizeY; j++) { // inner loop start

				if (gridOfBricks[i][j].isFaceUp() == false) { // if face down
					System.out.print("X ");
				} else if (gridOfBricks[i][j].isFaceUp() == true) {
					// if face up, get face value
					System.out.print(gridOfBricks[i][j].getValue() + " ");
				}

			} // inner loop end
			System.out.println(" "); // new line
		} // outer loop end

	}
	public int getSizeX() {
		return sizeX;
	}

	public boolean hasUnturnedTiles() {

		for (Brick[] bricks : gridOfBricks) {
			for (Brick brick : bricks) {
				if (!brick.isFaceUp()) {
					return true;
				}
			}
		}
		return false;
	}

	public int getRemaningBriks() {
		return remaningBriks;
	}

	public void setRemaningBriks(int remaningBriks) {
		this.remaningBriks = remaningBriks;
	}

	public int getSizeY() {
		return sizeY;
	}

}
