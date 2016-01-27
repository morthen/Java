//package test;
//
//import memoryGame.Brick;
//import memoryGame.Grid;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class GridTest {
//
//	@Test
//	public void numberOfBricksInGridIsEven() {
//		Grid grid = new Grid(3, 6);
//		Assert.assertTrue((grid.getSizeX() * grid.getSizeY()) % 2 == 0);
//
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void illegalArgumentExceptionThrown_whenAttempingToCreateOddSizedGrid() {
//		new Grid(3, 3);
//	}
//
//	@Test
//	public void aGridContainsExactlyTwoOfEachBrick() {
//		int rows = 2;
//		int columns = 2;
//		Grid grid = new Grid(rows, columns);
//		int[] noOfPairs = new int[rows*columns];
//
//		for (int i = 0; i < noOfPairs.length; i++) {
//			noOfPairs[i] = 0;
//		}
//		
//		int positionOfTile = -1;
//
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < columns; j++) {
//
//				Brick tileToCompare = grid.getBrick(i, j);
//
//				positionOfTile++;
//
//				for (int k = 0; k < rows; k++) {
//					for (int k2 = 0; k2 < columns; k2++) {
//						Brick tileToBeCompared = grid.getBrick(k, k2);
//
//						if (tileToCompare.equals(tileToBeCompared)) {
//							continue;
//						}
//
//						if (tileToCompare.compareTo(tileToBeCompared) == 0) {
//							noOfPairs[positionOfTile]++;
//						}
//					}
//				}
//			}
//		}
//
//		int[] expecteds = new int[rows*columns];
//		for (int i = 0; i < expecteds.length; i++) {
//			expecteds[i] = 1;
//		}
//
//		Assert.assertArrayEquals(
//				"Tiles exists that there are not exactly two of", expecteds,
//				noOfPairs);
//	}
//	
//	@Test
//	public void newGridHasUnturnedTiles(){
//		int rows=2;
//		int columns = 2;
//		Grid grid = new Grid(rows, columns);
//		
//		Assert.assertTrue(grid.hasUnturnedTiles());
//		
//	}
//	
//	@Test
//	public void gridHasNoUnturnedTilesWhenAllTilesAreFaceUp(){
//		int rows=1;
//		int columns = 2;
//		
//		Grid grid = new Grid(rows, columns);
//		
//		grid.getBrick(0,1).setFaceUp(true);
//		grid.getBrick(0,0).setFaceUp(true);
//		
//		Assert.assertFalse(grid.hasUnturnedTiles());
//		
//	}
//	
//}
