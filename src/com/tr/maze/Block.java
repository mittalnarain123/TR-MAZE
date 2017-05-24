package com.tr.maze;

/**
 * Provides the skeleton implementation for a Block in a Maze
 * 
 * @author Narain Mittal
 * 
 */
public abstract class Block {

	private final Color color;

	private final int x;

	private final int y;

	/**
	 * Set to true when a block is visited, false otherwise
	 */
	private boolean visited;

	/**
	 * Set to true only if the block is in path to finish, false otherwise
	 */
	private boolean inPath;

	public Block(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public abstract String display();

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isInPath() {
		return inPath;
	}

	public void setInPath(boolean inPath) {
		this.inPath = inPath;
	}

	/*
	 * 2 Blocks are considered equal if they are at same index.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Block other = (Block) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + x;
		result = (prime * result) + y;
		return result;
	}

	@Override
	public String toString() {
		return "Block [x=" + x + ", y=" + y + "]";
	}

}
