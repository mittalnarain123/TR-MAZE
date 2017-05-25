package com.tr.maze;

/**
 * Maze interface provides skeleton for Maze data structure.
 * 
 * @author Narain Mittal
 * 
 */
public interface IMaze {

	/**
	 * @return Start Block
	 */
	public Block getStart();

	/**
	 * @return End block
	 */
	public Block getEnd();

	/**
	 * Tries to find the neighbor aisle which has not been visited yet
	 * 
	 * @param block
	 *            the current block
	 * @return aisle if found, null otherwise
	 */
	public Block getNextAisle(Block block);

	/**
	 * Attempts to solve the maze with the selected algorithm
	 * 
	 * @param mazeSolver
	 * @return
	 */
	public boolean solve(IMazeSolver mazeSolver);

	/**
	 * Returns String representation of Maze
	 * 
	 * @return String
	 */
	public String display();
}
