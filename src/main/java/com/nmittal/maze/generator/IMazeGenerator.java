package com.nmittal.maze.generator;

import com.nmittal.maze.IMaze;

public interface IMazeGenerator {

	public IMaze generateMaze(int gridRows, int gridColumns);
}
