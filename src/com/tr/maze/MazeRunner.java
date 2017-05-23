package com.tr.maze;

public class MazeRunner {

	public static void main(String[] args) {
		// int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		//@formatter:off
		int[][] data = new int[][] { {1,0,1,1,1,1,1,1,1}, 
									 {1,0,0,0,1,0,0,0,1},
									 {1,0,1,1,1,0,1,0,1}, 
									 {1,0,1,0,0,0,1,0,1},
									 {1,0,1,0,1,0,1,1,1},
									 {1,0,0,0,1,0,1,0,1},
									 {1,0,1,1,1,0,1,0,1},
									 {1,0,0,0,1,0,0,0,1},
									 {1,1,1,1,1,1,1,0,1}
									 };
		//@formatter:on
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 8, 7);
		maze.solve(new MazeSolverDfs());
		System.out.println(maze.display());

	}
}
