package com.tr.maze;

public class MazeRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		maze.solve(new MazeSolverDfs());

	}
}
