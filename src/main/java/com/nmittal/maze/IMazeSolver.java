package com.nmittal.maze;

/**
 * Interface for any algorithm implementation for solving Maze problem
 * 
 * @author Narain Mittal
 * 
 */
public interface IMazeSolver {

	/**
	 * @param maze
	 * @return
	 */
	boolean solve(Maze maze);

	/**
	 * @return
	 */
	long solutionPathSize();

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
