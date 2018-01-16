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
	Block getNextTraversalAisle(Block block);


	/**
	 * @param block
	 *
	 * @return true if the block is part of the solution path/ false otherwise
	 */
	boolean isBlockInSolution(Block block);


	/**
	 * @param block
	 *
	 * @return true if the block has been visited in the maze/ false otherwise
	 */
	boolean isBlockVisited(Block block);

}
