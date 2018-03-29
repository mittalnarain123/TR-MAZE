package com.nmittal.maze.util;

import com.nmittal.maze.domain.IMaze;
import com.nmittal.maze.solve.IMazeSolver;
import com.nmittal.maze.solve.MazeSolverBfs;
import com.nmittal.maze.solve.MazeSolverDfs;

/**
 * Test program to run the Maze problem
 * 
 * @author Narain Mittal
 * 
 */
public class MazeRunner {

	public static void main(String[] args) {
		// @formatter:off
		int[][] data = new int[][] { { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 }, };
		// @formatter:on
		IMaze maze = MazeBuilder.buildMaze(data, 0, 2, 15, 14);

		System.out.println("-------------DFS---------------");
		IMazeSolver solver = new MazeSolverDfs(maze);
		System.out.println(maze.solve(solver));
		System.out.println(maze.display(solver));
		System.out.println("Solution path size: " + solver.solutionPathSize());

		System.out.println("-------------BFS---------------");
		solver = new MazeSolverBfs(maze);
		System.out.println(maze.solve(solver));
		System.out.println(maze.display(solver));
		System.out.println("Solution path size: " + solver.solutionPathSize());

	}
}
