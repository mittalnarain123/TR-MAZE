package com.tr.maze;

import junit.framework.Assert;

import org.junit.Test;

import com.tr.maze.Aisle;
import com.tr.maze.Block;
import com.tr.maze.IMazeSolver;
import com.tr.maze.Maze;
import com.tr.maze.MazeBuilder;
import com.tr.maze.MazeSolverDfs;
import com.tr.maze.Wall;

/**
 * JUnit to test the Maze
 * 
 * @author Narain Mittal
 * 
 */
public class MazeTest {
	@Test(expected = IllegalArgumentException.class)
	public void testInsufficientMazeDataException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		maze.solve(new MazeSolverDfs());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeDataException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 2 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		maze.solve(new MazeSolverDfs());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeDataException2() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		maze.solve(new MazeSolverDfs());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeStartException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 5, 5, 3, 1);
		maze.solve(new MazeSolverDfs());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeEndException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 5, 5);
		maze.solve(new MazeSolverDfs());
	}

	@Test
	public void testMazeSolution() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		IMazeSolver solver = new MazeSolverDfs();
		Assert.assertTrue(maze.solve(solver));
		Block[][] blocks = maze.getBlocks();
		for (Block[] bl : blocks) {
			for (Block b : bl) {
				if (b instanceof Wall) {
					Assert.assertFalse(solver.isBlockVisited(b));
					Assert.assertFalse(solver.isBlockInSolution(b));
				} else if (b instanceof Aisle) {
					Assert.assertTrue(solver.isBlockVisited(b));
					Assert.assertTrue(solver.isBlockInSolution(b));
				}
			}
		}
	}

	@Test
	public void testMazeNoSolution() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 2);
		Assert.assertFalse(maze.solve(new MazeSolverDfs()));
	}

}
