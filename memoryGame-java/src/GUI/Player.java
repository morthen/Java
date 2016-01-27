package GUI;

public class Player {

	private String name;
	private int numOfMatches;

	/**
	 * This will be constructor and generate player with the provided name.
	 * 
	 * @param name
	 *            will be the name of player.
	 */
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfMatches() {
		return numOfMatches;
	}

	public void setNumOfMatches(int numOfMatches) {
		this.numOfMatches = numOfMatches;
	}

	public void increaseNumOfMatches(){
		this.numOfMatches++;
	}
	
}
