package memoryGame;


public class AITest {

	public static void main(String[] args) {
		AIPlayer test = new AIPlayer("test", 2);
		Grid grid = new Grid(2, 3);

		/*
		 * for (int x = 0; x < grid.getSizeX(); x++) { for (int y = 0; y <
		 * grid.getSizeY(); y++) { test.addToMemoryDifficulty(grid.getBrick(x,
		 * y).getValue(), x, y); } }
		 */

		while (grid.hasUnturnedTiles()) {

			int[] tileToTurn = test.getFirstTile(grid);
			int[] tileToTurn2 = tileToTurn;

			grid.getBrick(tileToTurn[0], tileToTurn[1]).setFaceUp(true);

			System.out.println("SHOWING GRID AFTER FIRST TILE");
			grid.showGrid();
			System.out.println("");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (tileToTurn2[2]==-1 && tileToTurn2[3]==-1){
			tileToTurn2 = test.getSecondTile(grid.getBrick(tileToTurn[0], tileToTurn[1]), grid);
			}
			
			
			grid.getBrick(tileToTurn2[2], tileToTurn2[3]).setFaceUp(true);

			System.out.println("SHOWING GRID AFTER SECOND TILE");
			grid.showGrid();
			System.out.println("");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (grid.getBrick(tileToTurn[0], tileToTurn[1])
					.getValue()
					.equals(grid.getBrick(tileToTurn2[2], tileToTurn2[3])
							.getValue())) {
				System.out.println("PAIR!");
			}

			else {
				grid.getBrick(tileToTurn[0], tileToTurn[1]).setFaceUp(false);
				grid.getBrick(tileToTurn2[2], tileToTurn2[3]).setFaceUp(false);

				System.out.println("No Pair");

				test.addToMemoryDifficulty(
						grid.getBrick(tileToTurn[0], tileToTurn[1]).getValue(),
						grid.getBrick(tileToTurn[0], tileToTurn[1]).getX(),
						grid.getBrick(tileToTurn[0], tileToTurn[1]).getY());

				test.addToMemoryDifficulty(
						grid.getBrick(tileToTurn2[2], tileToTurn2[3])
								.getValue(),
						grid.getBrick(tileToTurn2[2], tileToTurn2[3]).getX(),
						grid.getBrick(tileToTurn2[2], tileToTurn2[3]).getY());

			}

			System.out.println("SHOWING GRID AFTER TURN");
			grid.showGrid();
			System.out.println(" ");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: zzzZZZzzz
			}

		}

	}

}
