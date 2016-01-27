//package test;
//
//import java.util.ArrayList;
//
//import memoryGame.*;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class GameMotorTest {
//	GameMotor gameMotor;
//	Player startPlayer;
//	Player playerTwo;
//	ArrayList<Player> allPlayers;
//
//	@Before
//	public void setUpArrays() {
//		allPlayers = new ArrayList<Player>();
//		
//		startPlayer = new Player("Lina");
//		allPlayers.add(startPlayer);
//
//		playerTwo = new Player("PlayerTwo");
//		allPlayers.add(playerTwo);
//		
//		gameMotor = new GameMotor(1);
//		gameMotor.setAllPlayers(allPlayers);
//		
//	}
//
//	@Test
//	public void nextPlayerIsStillStartPlayerWhenOnlyOnePlayer() {
//
//		ArrayList<Player> allPlayers = new ArrayList<Player>();
//		allPlayers.add(new Player("player1"));
//
//		GameMotor gameMotor = new GameMotor(1);
//		gameMotor.setAllPlayers(allPlayers);
//		gameMotor.setCurrentPlayer(gameMotor.getAllPlayers().get(0));
//		Player startPlayer= gameMotor.getCurrentPlayer();
//		gameMotor.changeToNextPlayer();
//
//		Player currentPlayer = gameMotor.getCurrentPlayer();
//
//		Assert.assertEquals(startPlayer, currentPlayer);
//	}
//
//	@Test
//	public void nextPlayerIsPlayerTwoWhenPlayerChangedOnce() {
//
//		gameMotor.setCurrentPlayer(startPlayer);
//
//		gameMotor.changeToNextPlayer();
//
//		Assert.assertEquals(gameMotor.getCurrentPlayer().getName()
//				+ " is currentPlayer",playerTwo, gameMotor.getCurrentPlayer());
//
//	}
//
//	@Test
//	public void nextPlayerIsFirstPlayerWhenAllPlayersHaveDoneAMove() {
//
//		gameMotor.setCurrentPlayer(playerTwo);
//
//		gameMotor.changeToNextPlayer();
//
//		Assert.assertEquals(gameMotor.getCurrentPlayer().getName()
//				+ "is currentPlayer",startPlayer, gameMotor.getCurrentPlayer());
//
//	}
//
//}
