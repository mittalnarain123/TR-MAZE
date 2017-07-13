package com.tr.maze;

/**
 * Interface for any algorithm implementation for solving Maze problem
 * 
 * @author Narain Mittal
 * 
 */
public interface IMazeSolver {

	boolean solve(Maze maze);

	/**
	 * Tries to find the neighbor aisle which has not been visited yet
	 * 
	 * @param block
	 *            the current block
	 * @return aisle if found, null otherwise
	 */
	Block getNextTraversableAisle(Block block);

	boolean isBlockInSolution(Block block);

	boolean isBlockVisited(Block block);

}
