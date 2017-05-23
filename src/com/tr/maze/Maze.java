package com.tr.maze;

public class Maze implements IMaze {

	private final Block[][] blocks;

	private final Block start;

	private final Block end;

	public Maze(Block[][] blocks, Block start, Block end) {
		super();
		this.blocks = blocks;
		this.start = start;
		this.end = end;
	}

	@Override
	public Block getNextAisle(Block block) {
		int x = block.getX();
		int y = block.getY();
		if (isValidAisle(x + 1, y)) {
			return blocks[x + 1][y];
		}
		if (isValidAisle(x, y + 1)) {
			return blocks[x][y + 1];
		}
		if (isValidAisle(x, y - 1)) {
			return blocks[x][y - 1];
		}
		if (isValidAisle(x - 1, y)) {
			return blocks[x - 1][y];
		}
		return null;
	}

	private boolean isValidAisle(int x, int y) {
		try {
			Block b = blocks[x][y];
			return (b instanceof Aisle) && !b.isVisited();
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}

	}

	@Override
	public void solve(IMazeSolver mazeSolver) {
		mazeSolver.solve(this);

	}

	@Override
	public Block getStart() {
		return start;
	}

	@Override
	public Block getEnd() {
		return end;
	}

	public Block[][] getBlocks() {
		return blocks;
	}

}
