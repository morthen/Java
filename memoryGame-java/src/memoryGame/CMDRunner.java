package memoryGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Runner class for the memory game
 * 
 * @author grupp2
 *
 */
public class CMDRunner {
	ArrayList<Player> players;
	static Scanner scanner;
	GameSettings settings;

	public static void main(String[] args) {
		// initialize scanner once
		scanner = new Scanner(System.in);
		CMDRunner cmdRunner = new CMDRunner();
		cmdRunner.playMemo();

	}

	public void playMemo() {
		players = new ArrayList<Player>();

		// Ask for game size
		settings = new GameSettings();
		settings.inputGridSize();
		//		settings.setGridSize(settings.inputGridSize());

		Grid grid = new Grid(settings.getGridSize()[0], settings.getGridSize()[1]);

		// Ask for Players Information

		settings.setTotalPlayers(generatePlayerObjects(inputNumberOfPlayers()));

		makeMoves(settings.getAllPlayers(), grid);

	}

	private void makeMoves(ArrayList<Player> totalPlayers, Grid grid) {

		while (grid.getRemaningBriks() > 0) {
			for (int i = 0; i < totalPlayers.size(); i++) {

				System.out
						.println("________________________________________________________________________");
				grid.showGrid();
				if (grid.getRemaningBriks() > 0)
					System.out.println(totalPlayers.get(i).getName()
							+ "'s Turn :");

				int playersCurrentTurns = 0;
				ArrayList<CoordinatesPoint> playersCurrentCoordinates = new ArrayList<CoordinatesPoint>();

				nameofloop: while (grid.getRemaningBriks() > 0) {

					// input from user
					int[] coordinates = inputFromUser(totalPlayers.get(i)
							.getName());
					playersCurrentCoordinates.add(new CoordinatesPoint(
							coordinates[0] - 1, coordinates[1] - 1, grid
									.getBrick(coordinates[0] - 1,
											coordinates[1] - 1).getValue()));
					// show tile

					grid.getBrick(coordinates[0] - 1, coordinates[1] - 1)
							.setFaceUp(true);

					// show grid]
					grid.showGrid();
					playersCurrentTurns++;
					if (playersCurrentTurns == 2) {

						if (playersCurrentCoordinates.get(0).value
								.equals(playersCurrentCoordinates.get(1).value)) {
							System.err
									.println(totalPlayers.get(i).getName()
											+ " got a Pair of "
											+ playersCurrentCoordinates.get(0).value
											+ "'s \u263A \u263A \u263A \u263A \u263A \u263A \u263A  ");
							totalPlayers.get(i).setNumOfMatches(
									totalPlayers.get(i).getNumOfMatches() + 1);
							playersCurrentCoordinates = new ArrayList<CoordinatesPoint>();
							playersCurrentTurns = 0;
							grid.setRemaningBriks(grid.getRemaningBriks() - 2);

						} else {
							for (CoordinatesPoint c : playersCurrentCoordinates) {
								grid.getBrick(c.x, c.y).setFaceUp(false);
							}

							break nameofloop;
						}
					}// ifplayersCurrentTurns == 2

				}// for (int j = 0; j < grid.getRemaningBriks(); j++)

			}// for (int i = 0; i < totalPlayers.size(); i++)

		}// while (grid.getRemaningBriks() > 0)

		for (Player p : totalPlayers) {
			System.out.println(p.getName() + " got " + p.getNumOfMatches()
					+ "matches");
		}

	}

	/**
	 * 
	 * @return array of 2 coordinates - x and y
	 */
	public int[] inputFromUser(String name) {

		System.out.println("What tile do " + name + " want to turn?");

		int[] coordinates = new int[2];

		try {
			System.out.print("What row: ");
			coordinates[0] = scanner.nextInt();
			System.out.print("What column: ");
			coordinates[1] = scanner.nextInt();

		} catch (Exception e) {
			System.out.println("Wrong input " + e);
		}

		return coordinates;
	}

	public int[] inputGridSize() {

		int[] gridSize = new int[2];
		do {
			System.out.println("Please choose the size of the Grid ? [x,y]");

			try {
				gridSize = new int[2];
				System.out.print("Rows: ");
				gridSize[0] = scanner.nextInt();
				System.out.print("Columns: ");
				gridSize[1] = scanner.nextInt();

			} catch (Exception e) {
				System.out.println("Wrong input " + e);
			}

		} while (((gridSize[0]*gridSize[1]) % 2) != 0) ;

		return gridSize;
	}

	public int inputNumberOfPlayers() {
		System.out.println("How many Players will be playing..");

		return scanner.nextInt();
	}

	public ArrayList<Player> generatePlayerObjects(int numOfPlayers) {
		for (int x = 1; x <= numOfPlayers; x++) {
			System.out.println("Please Enter the Player " + (x) + " Name :");
			String name = scanner.next();
			scanner.nextLine();

			players.add(new Player(name));
		}

		return players;

	}

	class CoordinatesPoint {
		public CoordinatesPoint(int i, int j, String value) {
			this.x = i;
			this.y = j;
			this.value = value;
		}

		int x;
		int y;
		String value;
	}
}
