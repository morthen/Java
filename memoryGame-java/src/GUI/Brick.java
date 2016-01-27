package GUI;

/**
 * 
 * @author Amir
 * @version 2014
 * 
 *          This class will be a representation of a basic building block of the
 *          Game, Brick. It will be containing the coordinates and the Value of
 *          the Brick, it will also saves the status of the Brick, visible or to
 *          be hiden.
 *
 */
public class Brick implements Comparable<Brick> {

	private int x;
	private int y;
	private String brickValue;
	private boolean isFaceUp;

	/**
	 * default constructor for Brick
	 * 
	 * @param value
	 *            is the Text(later a PICTURE) to be shown when the Brick will
	 *            be clicked.
	 */
	public Brick(String value) {
		this.brickValue = value;

	}

	/**
	 * constructor for Brick with coordinates where it is on the grid
	 * 
	 * @param x
	 *            its the X-position of a Brick in the Grid
	 * @param y
	 *            its the Y-position of a Brick in the Grid
	 * @param value
	 *            It's the Text(later a PICTURE) to be shown when the Brick will
	 *            be clicked.
	 */
	public Brick(int x, int y, String value) {
		this.brickValue = value;
		this.x = x;
		this.y = y;
		isFaceUp = false;

	}

	//TODO: Clean away what's not used
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getValue() {
		return brickValue;
	}

	public void setValue(String value) {
		this.brickValue = value;
	}

	/**
	 * is the tile hidden or not?
	 * 
	 * @return false if it is hidden and true if it is FaceUp
	 */
	public boolean isFaceUp() {
		return isFaceUp;
	}

	/**
	 * set to true when tile is changed.
	 * 
	 * @param hidden
	 */
	public void setFaceUp(boolean hidden) {
		this.isFaceUp = hidden;
	}

	public boolean tilesMatch(Brick brick) {
		
		if (this.brickValue.equalsIgnoreCase(brick.brickValue)) {
			return true;
		}

		return false;
	}

	/**
	 * Compares the value of the brick with the value of another brick.
	 */
	public int compareTo(Brick o) {
		return this.brickValue.compareTo(((Brick) o).getValue());
	}

}
