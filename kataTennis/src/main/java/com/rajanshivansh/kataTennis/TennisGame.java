package com.rajanshivansh.kataTennis;

import java.util.Arrays;
import java.util.List;

/**
 * TennisGame class to track tennis game and 
 * build score-board
 * 
 * @author shivansh.rajan
 *
 */
public class TennisGame {

	private Player player1;
	private Player player2;
	public static final List<String> pointsDescription = Arrays.asList("Love",
			"Fifteen", "Thirty", "Forty");

	/**
	 * Parameterized constructor for TennisGame class
	 * 
	 * @param player1
	 * @param player2
	 */
	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * Method to be called when umpire presses the button “{playerName} scores” 
	 * 
	 * @param playerName
	 */
	public void wonPoint(String playerName) {
		if (player1.getName().equals(playerName))
			player1.setScore(player1.getScore() + 1);
		else {
			player2.setScore(player2.getScore() + 1);

		}
	}
	
	/**
	 * Method to be called by score-board to display 
	 * the current score during tennis game
	 * 
	 * @return score
	 */
	public String getScore() {
		if ((player1.getScore() >= 4 || player2.getScore() >= 4)
				&& (Math.abs(player2.getScore() - player1.getScore()) >= 2)) {
			return "Win for " + getLeadPlayer().getName();

		} else if (player1.getScore() >= 3 && player2.getScore() >= 3) {
			if (player1.getScore() == player2.getScore()) {
				return "Deuce";
			} else {
				return "Advantage " + getLeadPlayer().getName();
			}
		} else {
			return pointsDescription.get(player1.getScore()) + "-"
					+ pointsDescription.get(player2.getScore());
		}
	}
	
	/**
	 * Method to return player leading the game
	 * i.e. having current score greater than other player
	 * @return player
	 */
	public Player getLeadPlayer() {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }

}
