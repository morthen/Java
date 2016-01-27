//package test;
//
//import memoryGame.Brick;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class BrickTest {
//
//	/**
//	 * Tests that two bricks with same value is compared as equals
//	 */
//	@Test
//	public void twoTilesAreAlikeWhenSameValue() {
//		Brick tile1 = new Brick("hej");
//		Brick tile2 = new Brick("hej");
//
//		Assert.assertTrue(tile1.tilesMatch(tile2));
//	}
//
//
//	/**
//	 * Tests that a brick is not FaceUp as default
//	 */
//	@Test
//	public void newBrickIsNotFaceUp(){
//		Brick tile = new Brick("Hej");
//		
//		Assert.assertFalse(tile.isFaceUp());
//	}
//
//	/**
//	 * Tests that a brick is faceUp when it has been turned and not before.
//	 */
//	@Test
//	public void brickIsFaceUpWhenTurned(){
//		Brick tile = new Brick("Hej");
//		
//		Assert.assertFalse(tile.isFaceUp());
//
//		tile.setFaceUp(true);
//		Assert.assertTrue(tile.isFaceUp());
//	}
//}
