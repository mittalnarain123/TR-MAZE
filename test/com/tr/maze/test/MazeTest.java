package com.tr.maze.test;

import junit.framework.Assert;

import org.junit.Test;

import com.tr.maze.Aisle;
import com.tr.maze.Block;
import com.tr.maze.Maze;
import com.tr.maze.MazeBuilder;
import com.tr.maze.MazeSolverDfs;
import com.tr.maze.Wall;

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
	public void testEazyMazeSolution() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		maze.solve(new MazeSolverDfs());
	}

	@Test
	public void testEqualsWallAisle() {
		Block a = new Wall(0, 0);
		Block b = new Aisle(0, 0);

		Assert.assertTrue(a.equals(b));
	}
}
