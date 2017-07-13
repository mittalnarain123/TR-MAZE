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
	public String display(IMazeSolver solver) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				builder.append(blocks[i][j].display(solver));
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	@Override
	public Block getBlock(int x, int y) {
		return blocks[x][y];
	}
}
