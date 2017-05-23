package com.tr.maze;

public abstract class Block {

	private final Color color;

	private final int x;

	private final int y;

	private boolean visited;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// if (getClass() != obj.getClass()) {
		// return false;
		// }
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
