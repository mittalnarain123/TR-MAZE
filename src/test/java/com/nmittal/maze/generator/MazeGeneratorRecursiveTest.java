package com.nmittal.maze.generator;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.nmittal.maze.IMaze;

public class MazeGeneratorRecursiveTest {

	private IMazeGenerator generator;

	@Before
	public void setup() {
		generator = new MazeGeneratorRecursive();

	}

	@Test
	public void mazeGeneratorValidArgs() {
		int grid = 10;
		try {
			IMaze maze = generator.generateMaze(grid, grid);
			assertThat("should have the size as input", maze.getBlock(grid - 1, grid - 1), notNullValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not throw error in maze generation");
		}

	}

}
