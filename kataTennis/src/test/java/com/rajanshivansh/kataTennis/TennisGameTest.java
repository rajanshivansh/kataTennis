package com.rajanshivansh.kataTennis;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * TennisGameTest class to test functionality of TennisGame class
 * 
 * @author shivansh.rajan
 *
 */
public class TennisGameTest {
	Player player1, player2;
	TennisGame game;

	@Before
	public void beforeGameTest() {
		player1 = new Player("player1");
		player2 = new Player("player2");
		game = new TennisGame(player1, player2);
	}

	/**
	 * Tests condition of the game getting win by
	 * the first player to have win at least four
	 * points in total and at least two points more 
	 * than the opponent
	 * 
	 */
	@Test
	public void testWinForPlayer1() {
		for (int index = 1; index <= 4; index++) {
			game.wonPoint("player1");
		}
		for (int index = 1; index <= 3; index++) {
			game.wonPoint("player2");
		}
		assertNotEquals(game.getScore(), "Win for player1");
		assertNotEquals(game.getScore(), "Win for player2");
		game.wonPoint("player1");
		assertEquals(game.getScore(), "Win for player1");

	}
	
	/**
	 * Tests condition of the game getting win by
	 * the second player to have win at least four
	 * points in total and at least two points more 
	 * than the opponent
	 * 
	 */
	@Test
	public void testWinForPlayer2() {
		for (int index = 1; index <= 3; index++) {
			game.wonPoint("player1");
		}
		for (int index = 1; index <= 4; index++) {
			game.wonPoint("player2");
		}
		assertNotEquals(game.getScore(), "Win for player1");
		assertNotEquals(game.getScore(), "Win for player2");
		game.wonPoint("player2");
		assertEquals(game.getScore(), "Win for player2");

	}

	/**
	 * Tests condition of at least three points
	 * have been scored by each side and a player
	 * has one more point than his opponent
	 *  
	 */
	@Test
	public void testAdvantageForPlayer1() {
		for (int index = 1; index <= 4; index++) {
			game.wonPoint("player1");
		}
		for (int index = 1; index <= 3; index++) {
			game.wonPoint("player2");
		}
		assertEquals(game.getScore(), "Advantage player1");
	}
	
	/**
	 * Tests condition of at least three points
	 * have been scored by each player, and the
	 * scores are equal
	 *  
	 */
	@Test
	public void testDeuceCondition() {
		for (int index = 1; index <= 2; index++) {
			game.wonPoint("player1");
		}
		for (int index = 1; index <= 2; index++) {
			game.wonPoint("player2");
		}
		assertNotEquals(game.getScore(), "Deuce");
		game.wonPoint("player1");
		assertNotEquals(game.getScore(), "Deuce");
		game.wonPoint("player2");
		assertEquals(game.getScore(), "Deuce");
	}

	/**
	 * Tests running score of each game as described
	 * in a manner peculiar to tennis
	 *  
	 */
	@Test
	public void testScoreDescription() {
		game.wonPoint("player2");
		assertEquals(game.getScore(), "Love-Fifteen");
		game.wonPoint("player1");
		assertEquals(game.getScore(), "Fifteen-Fifteen");
		game.wonPoint("player1");
		assertEquals(game.getScore(), "Thirty-Fifteen");
		game.wonPoint("player1");
		assertEquals(game.getScore(), "Forty-Fifteen");
	}
	
	/**
	 * Test player name change feature
	 *  
	 */
	@Test
	public void testPlayerNameChangeFeature() {
		player1.setName("Björn Borg");
		player2.setName("John McEnroe");
		for (int index = 1; index <= 4; index++) {
			game.wonPoint("Björn Borg");
		}
		for (int index = 1; index <= 3; index++) {
			game.wonPoint("John McEnroe");
		}
		assertNotEquals(game.getScore(), "Win for John McEnroe");
		assertNotEquals(game.getScore(), "Win for Björn Borg");
		game.wonPoint("Björn Borg");
		assertEquals(game.getScore(), "Win for Björn Borg");

	}

}
