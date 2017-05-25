package com.tr.maze;

/**
 * Maze data structure. Consists of 2D array of blocks, a starting block and end block.
 * 
 * @author Narain Mittal
 * 
 */
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

	/**
	 * Checks if the block at designated indices is an Aisle which is not visited yet.
	 * 
	 * @param x
	 * @param y
	 * @return true if valid, false otherwise
	 */
	private boolean isValidAisle(int x, int y) {
		try {
			Block b = blocks[x][y];
			return (b instanceof Aisle) && !b.isVisited();
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}

	}

	@Override
	public boolean solve(IMazeSolver mazeSolver) {
		return mazeSolver.solve(this);

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

	@Override
	public String display() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				builder.append(blocks[i][j].display());
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
