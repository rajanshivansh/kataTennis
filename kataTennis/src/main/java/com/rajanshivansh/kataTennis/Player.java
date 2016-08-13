package com.rajanshivansh.kataTennis;

/**
 * Player Class having details of a Tennis game player
 * 
 * @author shivansh.rajan
 *
 */
public class Player {

	private int score;
	private String name;	

	/**
	 * Parameterized constructor for Player class
	 * 
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
