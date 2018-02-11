package com.nmittal.maze;

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
	public String display(IMazeSolver solver);

	public Block getBlock(int x, int y);

}
